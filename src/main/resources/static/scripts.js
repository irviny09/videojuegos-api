const urlAgregar = "http://localhost:8080/api/agregar-videojuego";
const urlMostrar = "http://localhost:8080/api/mostrar-videojuegos"
const urlAgregarMultimedia = "http://localhost:8080/api/subir-multimedia";
const sectionMostrar = document.getElementById("mostrar");
const btnMostrar = document.getElementById("mostrar-tab");

document.getElementById('formVideojuego').addEventListener('submit', async (e) => {
    e.preventDefault();
    const btn = document.getElementById('btnSiguiente');
    btn.disabled = true;

    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData.entries());

    data.categorias = Array.from(formData.getAll('categorias')).join(',');
    data.plataformas = Array.from(formData.getAll('plataformas')).join(',');
    data.activo = data.activo === "true";

    try {
        const response = await fetch(urlAgregar, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        const contentType = response.headers.get("content-type");
        let result;

        if (contentType && contentType.includes("application/json")) {
            result = await response.json();
        } else {
            const text = await response.text();
            result = { mensaje: text, id: null };

        }
        console.log(response);
        if (response.ok && result.id) {
            document.getElementById('videojuegoId').value = result.id;
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

btnMostrar.addEventListener('click', async (e) => {
    const galeryVideojuegos = document.getElementById("galeryVideojuegos");
    galeryVideojuegos.innerHTML = "";
    let videojuegos = [];
    await fetch(urlMostrar)
        .then(response => response.json())
        .then(data => {
            videojuegos = data;
        });

    videojuegos.forEach(videojuego => {
        galeryVideojuegos.innerHTML += `
                <a class="card-body" href="http://localhost:8080/videojuego/${videojuego.VideojuegosId}">
                    <div class="lc-block bg-white rounded shadow card">
                        <img src="${videojuego.Multimedia_ImagenURL}"
                                alt="${videojuego.Videojuegos_Titulo}" class="img-fluid card-img-top"
                                sizes="(max-width: 1080px) 100vw, 1080px" width="1080" height="768" loading="lazy">
                            <div class="lc-block p-4">
                                <div editable="rich">
                                    <h2>${videojuego.Videojuegos_Titulo}</h2>
                                    <p>${videojuego.Videojuegos_Descripcion}</p>
                                    <p class="">Categorias : <strong>${videojuego.categorias}</strong></p>
                                </div>
                            </div>
                        </div>
                </a>
            `;
    });

    console.log(videojuegos);

});