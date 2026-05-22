package br.com.taysonkaue98.screenmatch.models;

public class Movie {

//Atributos da classe Movie
    private String title;
    private int releaseDate;
    private double sumRating;
    private int duration;
    private int totalReviews;
    private boolean isAvailableOnStreaming;

//Metodo para obter o total de avaliações do filme
    public int getTotalReviews() {
        return totalReviews;
    }

//Metodo para obter o título do filme
    public void setTitle(String title) {
        this.title = title;
    }

//Metodo para obter a data de lançamento do filme
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

//Metodo para obter a duração do filme
    public void setDuration(int duration) {
        this.duration = duration;
    }


//Metodo para mostrar informações do filme
    public void displayMovieInfo() {
        System.out.println("Title: " + title);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Duration: " + duration + " minutes");
    }

//Metodo para adicionar uma avaliação ao filme
    public void addReview(double rating) {
        sumRating += rating;
        totalReviews++;
    }
//Metodo para calcular a média das avaliações do filme
    public double avarageRating() {
        if (totalReviews == 0) {
            return 0;
        }

        return sumRating / totalReviews;
    }

}