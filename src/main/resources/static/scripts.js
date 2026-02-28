const urlAgregar = "http://localhost:8080/api/agregar-videojuego";
const urlAgregarMultimedia = "http://localhost:8080/api/subir-multimedia";

document.getElementById('formVideojuego').addEventListener('submit', async (e) => {
            e.preventDefault();
            const btn = document.getElementById('btnSiguiente');
            btn.disabled = true;
            btn.innerText = "Procesando...";

            const formData = new FormData(e.target);
            const data = Object.fromEntries(formData.entries());

            // Formatear arrays de checkboxes a Strings separados por comas
            data.categorias = Array.from(formData.getAll('categorias')).join(',');
            data.plataformas = Array.from(formData.getAll('plataformas')).join(',');
            // Asegurar el booleano
            data.activo = data.activo === "true";

            try {
                const response = await fetch(urlAgregar, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(data)
                });

                const result = await response.json();

                if (response.ok && result.id) {
                    // Guardamos el ID que nos dio el SP
                    document.getElementById('videojuegoId').value = result.id;
                    // Abrimos el Modal para la imagen
                    const modal = new bootstrap.Modal(document.getElementById('modalMultimedia'));
                    modal.show();
                } else {
                    alert("Error: " + (result.mensaje || "No se pudo registrar"));
                    btn.disabled = false;
                    btn.innerText = "Siguiente: Multimedia";
                }
            } catch (err) {
                console.error(err);
                alert("Error de conexión con el servidor");
                btn.disabled = false;
            }
        });

        // FASE 2: Subir Multimedia (Multipart)
        document.getElementById('formMultimedia').addEventListener('submit', async (e) => {
            e.preventDefault();
            
            const multimediaForm = new FormData();
            multimediaForm.append('id', document.getElementById('videojuegoId').value);
            multimediaForm.append('imagenFile', document.getElementById('imagenFile').files[0]);
            multimediaForm.append('trailerUrl', document.getElementById('trailerUrl').value);

            try {
                const response = await fetch(urlAgregarMultimedia, {
                    method: 'POST',
                    body: multimediaForm // No se pone header, el navegador detecta el multipart solo
                });

                if (response.ok) {
                    alert("¡Videojuego registrado completamente!");
                    window.location.reload(); // Recargar página
                } else {
                    const errorMsg = await response.text();
                    alert("Error en multimedia: " + errorMsg);
                }
            } catch (err) {
                alert("Error crítico al subir archivo");
            }
        });