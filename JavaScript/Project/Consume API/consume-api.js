const apiUrl=''

function fetchStdData()
{
    fetch(apiUrl)
    .then(response => response.json())
    .then(data=>{
        const usersTableBody =document.querySelector('#usersTable tbody');

        //Clear any existing data
        usersTableBody.innerHTML='';

        //loop through data and create table rows
        data.forEach(user => {
            const row = document.createElement('tr');
            
            
            row.innerHTML=
            `
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            `;
            
            usersTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('error fetching data:',error);
    })
    
}

//calling fetchStdData
window.onload=fetchStdData;