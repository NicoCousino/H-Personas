import "../Estilos/AltaPersona.css"
import React from "react";
import {Link} from "react-router-dom";
import {useState} from "react";
import  * as PersonaServicio from "../Servicios/PersonaServicio";

export default function AltaPersona(){

    const [nombre, setNombre] = useState("");
    const [apellido, setApellido] = useState("");
    const [edad, setEdad] = useState("");
    const [direccion, setDireccion] = useState("");

    const [fecha, setFecha] = useState("");

    const [cargando, setCargando] = useState(false);


    const handleNombre = (evento) => {
        setNombre(evento.target.value)
    }
    const handleApellido = (evento) => {
        setApellido(evento.target.value)
    }
    const handleEdad = (evento) => {
        setEdad(evento.target.value)
    }
    const handleDireccion = (evento) => {
        setDireccion(evento.target.value)
    }

    const handleFecha = (evento) => {
        setFecha(evento.target.value)  
    }


    const clickSubmit = async (e) =>{
        e.preventDefault()
        setCargando(true)
        if (nombre==='' || apellido ==='' || edad==='' || edad <= 0 || direccion === '' || fecha==='') {
            setCargando(false)
            alert("Complete todos los campos correctamente")
        }
        else{
            setCargando(true)
            console.log(fecha)

            let fechaSplit = fecha.split("-")
            let date = new Date()
            date.setDate(parseInt(fechaSplit[2]))
            date.setMonth(parseInt(fechaSplit[1]))
            date.setFullYear(parseInt(fechaSplit[0]))
            let persona = {
                nombre: nombre,
                apellido: apellido,
                edad: parseInt(edad),
                direccion: direccion,
                fechaNacimiento: date
            }
            console.log(persona)
            
            let respuesta = await PersonaServicio.addPersona(persona)
            if (respuesta){
                alert("Persona cargada correctamente")
            }
            else {
                alert("Ocurrio un error")
            }
            setNombre("")
            setApellido("")
            setEdad("")
            setDireccion("")
            setFecha("")
            setCargando(false)

            
        }
    }

    return (
    <div className="AltaPersona">
        {
        cargando ? 
        <div className="loader-container">
            <div className="spinner"></div>
        </div>
        : null
        }
        <h1 className="titulo">Alta Persona</h1>
        <form>
            <div>
                <label>
                    {"Nombre: "} 
                    <input
                        value={nombre}
                        onChange={handleNombre}
                        type="text" placeholder="Ingrese Nombre">
                    </input>
                </label>
            </div>
            <div>
                <label>
                    {"Apellido: "} 
                    <input
                        value={apellido}
                        onChange={handleApellido}
                        type="text" placeholder="Ingrese Apellido">
                    </input>
                </label>
            </div>
            <div>
                <label>
                    {"Edad: "} 
                    <input
                        value={edad}
                        onChange={handleEdad}
                        type="number" placeholder="Ingrese Edad">
                    </input>
                </label>
            </div>
            <div>
                <label>
                    {"Direccion: "} 
                    <input
                        value={direccion}
                        onChange={handleDireccion}
                        type="text" placeholder="Ingrese Direccion">
                    </input>
                </label>
                <div>
                    <label>
                        {"Nacimiento: "}
                        <span>
                            <input
                                value={fecha}
                                onChange={handleFecha}
                                type="date" placeholder="Fecha">
                            </input>
                        </span>
                    </label>
                </div>
            </div>
            <div className="submit">
                <input
                    onClick={clickSubmit}
                    type="submit" 
                    name="Enviar">
                </input>
            </div>
            
        </form>
        <div className="volver">
            <Link to="/">Volver</Link>
        </div>
        
    </div>
    )

}