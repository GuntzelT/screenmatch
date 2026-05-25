package br.com.taysonkaue98.screenmatch.models;

public class Title {

//Atributos da classe Title

    private String title;
    private int releaseDate;
    private double sumRating;
    private int durationInMinutes;
    private int totalReviews;
    private boolean isAvailableOnStreaming;

//Metodo para obter o total de avaliações dos titulos

    public int getTotalReviews() {
        return totalReviews;
    }


//Metodo para obter e definir o título dos titulos

    public String getTitle() {
        return title;
    }   
    public void setTitle(String title) {
        this.title = title;
    }

//Metodo para obter e definir a data de lançamento dos titulos

    public int getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

//Metodo para obter e definir a duração dos titulos

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }


//Metodo para mostrar informações dos titulos

    public void displayTitleInfo() {
        System.out.println("Title: " + title);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Duration: " + durationInMinutes + " minutes");
    }

//Metodo para adicionar uma avaliação ao titulo

    public void addReview(double rating) {
        sumRating += rating;
        totalReviews++;
    }
//Metodo para calcular a média das avaliações do titulo

    public double avarageRating() {
        if (totalReviews == 0) {
            return 0;
        }

        return sumRating / totalReviews;
    }

}