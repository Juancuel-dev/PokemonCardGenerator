package es.agora.pokemoncardcreator;

import java.util.ArrayList;

public class Pokemon {

    private String nombre;
    private int numero;
    private ArrayList<Tipo> tipos;
    private String descripcion;
    private String rutaImagen;

    public Pokemon() {
        this.nombre = " ";
        this.numero =-1;
        this.tipos = new ArrayList<>();
        this.descripcion = " ";
        this.rutaImagen = " ";
    }

    public Pokemon(String nombre, int numero, ArrayList<Tipo> tipos, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipos = tipos;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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



