import { baseUrl } from "../Constantes/Constantes"


    export const addPersona = async (persona) => {
        let url = `${baseUrl}addPersona`
        let respuesta = await fetch (url, {
            method: "POST", mode: 'cors',
            body: JSON.stringify(persona),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        if (respuesta.status === 200){
            return true
        }
        else{
            return false
        }
    }

    export const getPersonas = async () => {
        let url = `${baseUrl}getPersonas`
        let res =await fetch(url)
        let respuesta = await res.json()
        return respuesta
    }

    export const getPersonasFiltro = async (nombre,edad)=>{
        let url = `${baseUrl}getPersonasFiltro?nombre=${nombre}&edad=${edad}`
        let res = await fetch(url)
        return await res.json()
    }