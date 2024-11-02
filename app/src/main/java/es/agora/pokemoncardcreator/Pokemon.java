package es.agora.pokemoncardcreator;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {

    private String nombre;
    private String numero;
    private ArrayList<Tipo> tipos;
    private String descripcion;
    private String rutaImagen;

    public Pokemon() {
        this.nombre = " ";
        this.numero =" ";
        this.tipos = new ArrayList<>();
        this.descripcion = " ";
        this.rutaImagen = " ";
    }

    public Pokemon(String numero, String nombre, ArrayList<Tipo> tipos, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipos = tipos;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }
    public String getDrawableId() {

        return "p"+this.getNumero();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", tipos=" + tipos +
                ", descripcion='" + descripcion + '\'' +
                ", rutaImagen='" + rutaImagen + '\'' +
                '}';
    }
}



