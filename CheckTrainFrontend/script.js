document.addEventListener('DOMContentLoaded', () => {
    // Get references to DOM elements
    const searchForm = document.getElementById('searchForm');
    const sourceCodeInput = document.getElementById('sourceCode');
    const destinationCodeInput = document.getElementById('destinationCode');
    const sourceCodeError = document.getElementById('sourceCodeError');
    const destinationCodeError = document.getElementById('destinationCodeError');
    const swapBtn = document.getElementById('swapBtn');
    const clearBtn = document.getElementById('clearBtn');
    const searchBtn = document.getElementById('searchBtn');

    const searchSection = document.querySelector('.search-section');
    const loadingSection = document.getElementById('loadingSection');
    const alertSection = document.getElementById('alertSection');
    const alertBox = document.getElementById('alertBox');
    const alertMessage = document.getElementById('alertMessage');
    const alertClose = document.getElementById('alertClose');
    const resultsSection = document.getElementById('resultsSection');
    const resultsCount = document.getElementById('resultsCount');
    const trainResultsContainer = document.getElementById('trainResults');
    const noResultsSection = document.getElementById('noResultsSection');
    const searchAgainBtn = document.getElementById('searchAgainBtn');
    const navLinks = document.querySelector('.nav-links');
    const navToggle = document.querySelector('.nav-toggle');

    // --- Utility Functions ---

    /**
     * Shows a specific section and hides others.
     * @param {HTMLElement} sectionToShow The section to display.
     */
    function showSection(sectionToShow) {
        [searchSection, loadingSection, alertSection, resultsSection, noResultsSection].forEach(section => {
            if (section) { // Check if the section element exists
                section.style.display = 'none';
            }
        });
        if (sectionToShow) {
            sectionToShow.style.display = 'block';
        }
    }

    /**
     * Displays an alert message.
     * @param {string} message The message to display.
     * @param {string} type The type of alert (e.g., 'error', 'success', 'warning', 'info').
     */
    function showAlert(message, type = 'error') {
        alertMessage.textContent = message;
        alertBox.className = `alert ${type}`; // Reset and apply new class
        showSection(alertSection);
    }

    /**
     * Clears and hides any active alert.
     */
    function hideAlert() {
        if (alertSection) {
            alertSection.style.display = 'none';
            alertMessage.textContent = '';
            alertBox.className = 'alert'; // Reset to default class
        }
    }

    /**
     * Toggles the loading state of a button.
     * @param {HTMLButtonElement} button The button element.
     * @param {boolean} isLoading True to show loader, false to hide.
     */
    function toggleButtonLoading(button, isLoading) {
        if (isLoading) {
            button.classList.add('loading');
            button.disabled = true;
        } else {
            button.classList.remove('loading');
            button.disabled = false;
        }
    }

    // --- Form Validation ---

    /**
     * Validates an input field based on its pattern and required attributes.
     * @param {HTMLInputElement} inputElement The input element to validate.
     * @param {HTMLElement} errorElement The element to display validation messages.
     * @returns {boolean} True if valid, false otherwise.
     */
    function validateInput(inputElement, errorElement) {
        if (inputElement.validity.valueMissing) {
            errorElement.textContent = 'This field is required.';
            return false;
        }
        if (inputElement.validity.patternMismatch) {
            errorElement.textContent = inputElement.title || 'Please match the required format.';
            return false;
        }
        errorElement.textContent = ''; // Clear error if valid
        return true;
    }

    // --- Event Listeners ---

    // Navbar toggle for mobile
    if (navToggle && navLinks) {
        navToggle.addEventListener('click', () => {
            navLinks.classList.toggle('visible');
            navToggle.classList.toggle('open'); // Add a class for animating the burger icon
            // Optional: Animate burger icon
            const spans = navToggle.querySelectorAll('span');
            if (navLinks.classList.contains('visible')) {
                spans[0].style.transform = 'rotate(45deg) translate(5px, 5px)';
                spans[1].style.opacity = '0';
                spans[2].style.transform = 'rotate(-45deg) translate(5px, -5px)';
            } else {
                spans[0].style.transform = 'none';
                spans[1].style.opacity = '1';
                spans[2].style.transform = 'none';
            }
        });
    }

    // Close alert
    if (alertClose) {
        alertClose.addEventListener('click', hideAlert);
    }

    // Swap button functionality
    if (swapBtn && sourceCodeInput && destinationCodeInput) {
        swapBtn.addEventListener('click', () => {
            const temp = sourceCodeInput.value;
            sourceCodeInput.value = destinationCodeInput.value;
            destinationCodeInput.value = temp;
            // Re-validate after swap if needed
            validateInput(sourceCodeInput, sourceCodeError);
            validateInput(destinationCodeInput, destinationCodeError);
        });
    }

    // Clear button functionality
    if (clearBtn && sourceCodeInput && destinationCodeInput) {
        clearBtn.addEventListener('click', () => {
            sourceCodeInput.value = '';
            destinationCodeInput.value = '';
            sourceCodeError.textContent = '';
            destinationCodeError.textContent = '';
            hideAlert(); // Hide any active alerts
            showSection(searchSection); // Return to search form
            trainResultsContainer.innerHTML = ''; // Clear previous results
            resultsCount.textContent = '';
        });
    }

    // Input validation on blur (when user clicks out of input)
    if (sourceCodeInput) {
        sourceCodeInput.addEventListener('blur', () => validateInput(sourceCodeInput, sourceCodeError));
    }
    if (destinationCodeInput) {
        destinationCodeInput.addEventListener('blur', () => validateInput(destinationCodeInput, destinationCodeError));
    }

    // Search Again button functionality
    if (searchAgainBtn) {
        searchAgainBtn.addEventListener('click', () => {
            showSection(searchSection);
            trainResultsContainer.innerHTML = ''; // Clear previous results
            resultsCount.textContent = '';
            hideAlert();
        });
    }

    // Handle form submission
    if (searchForm) {
        searchForm.addEventListener('submit', async (event) => {
            event.preventDefault(); // Prevent default form submission

            hideAlert(); // Hide any previous alerts

            // Validate all inputs before proceeding
            const isSourceValid = validateInput(sourceCodeInput, sourceCodeError);
            const isDestinationValid = validateInput(destinationCodeInput, destinationCodeError);

            if (!isSourceValid || !isDestinationValid) {
                showAlert('Please correct the errors in the form.', 'error');
                return; // Stop if validation fails
            }

            const sourceCode = sourceCodeInput.value.toUpperCase();
            const destinationCode = destinationCodeInput.value.toUpperCase();

            // Check if source and destination are the same
            if (sourceCode === destinationCode) {
                showAlert('Source and Destination station codes cannot be the same.', 'warning');
                return;
            }

            showSection(loadingSection); // Show loading animation
            toggleButtonLoading(searchBtn, true); // Enable loading state on search button

            try {
                // Simulate network delay (remove in production)
                // await new Promise(resolve => setTimeout(resolve, 2000));

                const response = await fetch(`http://localhost:8080/search/by-code?sourceCode=${sourceCode}&destinationCode=${destinationCode}`);

                if (!response.ok) {
                    // Handle HTTP errors (e.g., 404, 500)
                    if (response.status === 404) {
                        showAlert('No direct route found between these stations. Please try different codes.', 'info');
                        showSection(noResultsSection); // Show no results section if 404
                        return; // Exit function
                    }
                    const errorData = await response.json(); // Attempt to parse error message
                    throw new Error(errorData.message || `HTTP error! Status: ${response.status}`);
                }

                const data = await response.json();

                if (data && data.length > 0) {
                    displayTrainResults(data, sourceCode, destinationCode);
                    showSection(resultsSection);
                } else {
                    showSection(noResultsSection);
                    showAlert('No trains found for this route.', 'info');
                }

            } catch (error) {
                console.error('Error fetching train data:', error);
                showAlert(`Failed to fetch train data: ${error.message}. Please try again later.`, 'error');
                showSection(searchSection); // Go back to search form on error
            } finally {
                toggleButtonLoading(searchBtn, false); // Disable loading state
            }
        });
    }

    // --- Display Results ---

    /**
     * Renders the train results into the DOM.
     * @param {Array} trains An array of train objects.
     * @param {string} sourceC The source station code.
     * @param {string} destinationC The destination station code.
     */
    function displayTrainResults(trains, sourceC, destinationC) {
        trainResultsContainer.innerHTML = ''; // Clear previous results
        resultsCount.textContent = `Showing ${trains.length} train(s) from ${sourceC} to ${destinationC}`;

        trains.forEach(trainData => {
            const trainCard = document.createElement('div');
            trainCard.classList.add('train-card');

            trainCard.innerHTML = `
                <div class="train-header">
                    <div class="train-info">
                        <h3 class="train-name">${trainData.train.trainName}</h3>
                        <span class="train-number">#${trainData.train.trainNumber}</span>
                    </div>
                </div>
                <div class="journey-details">
                    <div class="station-info source">
                        <span class="station-code">${trainData.source.stationCode}</span>
                        <h4 class="station-name">${trainData.source.stationName}</h4>
                        <span class="time">${trainData.departureTime}</span>
                        <span class="time-label">Departure</span>
                    </div>
                    <div class="journey-line">
                        <div class="train-progress"></div>
                    </div>
                    <div class="station-info destination">
                        <span class="station-code">${trainData.destination.stationCode}</span>
                        <h4 class="station-name">${trainData.destination.stationName}</h4>
                        <span class="time">${trainData.arrivalTime}</span>
                        <span class="time-label">Arrival</span>
                    </div>
                </div>
            `;
            trainResultsContainer.appendChild(trainCard);
        });
    }

    // --- Initial State ---
    showSection(searchSection); // Display the search section initially

});