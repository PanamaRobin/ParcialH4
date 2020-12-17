package com.example.parcialh4.entidad;

import java.io.Serializable;

public class PartidaGuardada  implements Serializable {
    private Integer id,actividad,puntaje;
    private String personaje;

    public PartidaGuardada()
    {}
    public PartidaGuardada(Integer id, Integer actividad, Integer puntaje, String personaje) {
        this.id = id;
        this.actividad = actividad;
        this.puntaje = puntaje;
        this.personaje = personaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActividad() {
        return actividad;
    }

    public void setActividad(Integer actividad) {
        this.actividad = actividad;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
}
