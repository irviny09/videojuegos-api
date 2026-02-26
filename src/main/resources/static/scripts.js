const urlAgregar = "http://localhost:8080/api/agregar-videojuego";
const formulario = document.getElementById("formVideojuego");
const btnEnviar = document.getElementById("btnEnviar");


btnEnviar.addEventListener('click' , async (e) =>{
    e.preventDefault();
    let formData = new FormData(formulario);
    let response = await fetch(urlAgregar , {
        method: 'POST',
        body: formData
    });
    let result = await response.json;
    alert(result.message);
});