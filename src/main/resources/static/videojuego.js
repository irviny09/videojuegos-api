const urlEliminar = "http://localhost:8080/api/eliminar-videojuego";
const btnActualizar = document.getElementById("btnActualizar");
const btnEliminar = document.getElementById("btnEliminar");

btnEliminar.addEventListener('click', (e) => {
    try {
        let VideojuegoId = document.getElementById("idVideojuego").value;
        const response = fetch(urlEliminar, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: { "id": VideojuegoId }
        })
        if (response.ok) {
            alert("Videojuego Eliminado Correctamente");
        }
    } catch (error) {
        alert("Error: " + error.getMessage());
    }
});