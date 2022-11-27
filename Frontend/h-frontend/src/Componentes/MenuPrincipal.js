import "../Estilos/MenuPrincipal.css"
import React from "react";
import {useState, useEffect} from "react";
import {Link} from "react-router-dom";

export default function MenuPrincipal() {

    const PERSONAS = []
  
    const [inputNombre, setInputNombre] = useState('')
    const [inputEdad, setInputEdad] = useState('')
    const [personas, setPersonas] = useState(PERSONAS)
    
    useEffect (()=>{
        let url = `http://localhost:8080/getPersonas`
        fetch(url)
        .then(res =>res.json()
        .then(
            respuesta => {
            setPersonas(respuesta)
            }
        ))
    },[])
  
    const handleInputNombre = (evento) =>{
      setInputNombre(evento.target.value)
    }
  
    const handleInputEdad = (evento) =>{
      setInputEdad(evento.target.value)
    }
    
    const clickAltaPersona = () => {
    }
  
    const clickBuscar = ()=>{
      if (inputEdad!='' && inputEdad<0) {
        alert("Ingrese una Edad Valida")
      }
      else{
        let edad = inputEdad
        if (inputEdad == ""){
          edad = -1
        }
        let url = `http://localhost:8080/getPersonasFiltro?nombre=${inputNombre}&edad=${edad}`
        fetch(url)
        .then(res =>res.json()
        .then(respuesta =>{
          setPersonas(respuesta)
        }))
      }
  
  
    }

    return(
        <div className="MenuPrincipal">
        <div>
            <h1 className='titulo'>Personas</h1>
        </div>
        <div>
            <h2>Filtros</h2>
            <span>
            <input 
            placeholder='Nombre' 
            value={inputNombre} 
            onChange={handleInputNombre}>
            </input>
            <input 
                placeholder='Edad' 
                type={'number'}
                value={inputEdad}
                onChange={handleInputEdad}>
            </input>
            <button 
                onClick={clickBuscar}
            >
                Buscar
            </button>
            </span>
        </div>
        <div>
            <button 
                onClick={clickAltaPersona}
            >
                <Link to={"/AltaPersona"}>Alta Persona</Link>
            </button>
        </div>
        <div>
            <table className="tabla">
            <thead>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Direccion</th>
                <th>Edad</th>
            </thead>
            <tbody>
                {personas.map((item)=>{ 
                return (
                <tr>
                    <td>{item.idPersona}</td>
                    <td>{item.nombre}</td>
                    <td>{item.apellido}</td>
                    <td>{item.direccion}</td>
                    <td>{item.edad}</td>
                </tr>
                )
                })}
            </tbody>
            </table>
        </div>
        </div>
    )
}