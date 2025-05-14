// Chargement initial des données
document.addEventListener('DOMContentLoaded', () => {
    fetch('/users/1')
        .then(res => res.json())
        .then(user => {
            document.getElementById('user-profile').innerHTML = `
                <h2>${user.username}</h2>
                <p>${user.email}</p>
            `;
        });
});