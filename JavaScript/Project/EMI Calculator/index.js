// EMI Calculator Script

// Function to calculate EMI
function calculateEMI(principal, rate, tenure) {
    // Convert annual interest rate to monthly and percentage
    let monthlyRate = rate / (12 * 100);

    // Calculate EMI using the formula
    let emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
              (Math.pow(1 + monthlyRate, tenure) - 1);

    return emi.toFixed(2); // Return EMI rounded to 2 decimal places
}

// Function to handle form submission
function handleEMICalculation(event) {
    event.preventDefault();

    // Get input values
    const principal = parseFloat(document.getElementById('principal').value);
    const rate = parseFloat(document.getElementById('rate').value);
    const tenure = parseInt(document.getElementById('tenure').value);

    // Validate inputs
    if (isNaN(principal) || isNaN(rate) || isNaN(tenure) || principal <= 0 || rate <= 0 || tenure <= 0) {
        alert('Please enter valid positive numbers for all fields.');
        return;
    }

    // Calculate EMI
    const emi = calculateEMI(principal, rate, tenure);

    // Display result
    document.getElementById('emi-result').innerText = `Your EMI is ₹${emi}`;
}

// Attach event listener to the form
document.getElementById('emi-form').addEventListener('submit', handleEMICalculation);