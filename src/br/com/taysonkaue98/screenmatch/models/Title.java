package br.com.taysonkaue98.screenmatch.models;

public class Title {

//Atributos da classe Movie

    private String title;
    private int releaseDate;
    private double sumRating;
    private int durationInMinutes;
    private int totalReviews;
    private boolean isAvailableOnStreaming;

//Metodo para obter o total de avaliações do filme

    public int getTotalReviews() {
        return totalReviews;
    }


//Metodo para obter e definir o título do filme

    public String getTitle() {
        return title;
    }   
    public void setTitle(String title) {
        this.title = title;
    }

//Metodo para obter e definir a data de lançamento do filme

    public int getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

//Metodo para obter e definir a duração do filme

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }


//Metodo para mostrar informações do filme

    public void displayMovieInfo() {
        System.out.println("Title: " + title);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Duration: " + durationInMinutes + " minutes");
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