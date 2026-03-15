const btnEliminar = document.getElementById("btnEliminar");

btnEliminar.addEventListener('click', async (e) => { 
    e.preventDefault();
    
    const inputId = document.getElementById("idVideojuego");
    const VideojuegoId = inputId.value;

    // Validación simple
    if (!VideojuegoId) {
        Swal.fire("Cuidado", "No hay un ID de videojuego válido", "info");
        return;
    }

    const urlEliminar = `/api/eliminar-videojuego?id=${VideojuegoId}`;

    try {
        btnEliminar.disabled = true;

        const response = await fetch(urlEliminar, { method: 'POST' });
        console.log(response);
        if (response.ok) {
            await Swal.fire({
                title: "¡Eliminado!",
                text: "El videojuego ha sido borrado correctamente.",
                icon: "success",
                confirmButtonColor: "#3085d6"
            });
            
            window.location.href = "/"; 
        } else {
            const errorMsg = await response.text(); 
            Swal.fire({
                title: "Error",
                text: "No se pudo eliminar: " + errorMsg,
                icon: "error"
            });
            btnEliminar.disabled = false;
        }
    } catch (error) {
        Swal.fire({
            title: "Error de conexión",
            text: "No se pudo contactar con el servidor.",
            icon: "warning"
        });
        btnEliminar.disabled = false;
    }
});