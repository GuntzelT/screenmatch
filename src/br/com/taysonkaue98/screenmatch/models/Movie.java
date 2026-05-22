package br.com.taysonkaue98.screenmatch.models;

public class Movie extends Title {

//Atributos da classe Movie

    private String director;

//Metodo para obter o diretor do filme

    public String getDirector() {
        return director;
    }

//Metodo para definir o diretor do filme

    public void setDirector(String director) {
        this.director = director;
    }

}