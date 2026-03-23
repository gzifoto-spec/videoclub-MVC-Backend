package org.example.model;

public class Movie {
    private int id;
    private String titulo;
    private int anio;
    private double rating;
    private String poster;
    private String sinopsis;

    public Movie(int id, String titulo, int anio, double rating, String poster, String sinopsis) {

        this.titulo = titulo;
        this.anio = anio;
        this.rating = rating;
        this.poster = poster;
        this.sinopsis = sinopsis;
    }

    public Movie(String titulo, Integer anio, double rating, String poster, String sinopsis) {
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
