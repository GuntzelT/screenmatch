package br.com.taysonkaue98.screenmatch.models;

import com.google.gson.annotations.SerializedName;

import br.com.taysonkaue98.screenmatch.exceptions.ErrorConvertYearException;

public class Title implements Comparable<Title> {

// Atributos da classe Title, cada um mapeado para um campo específico no JSON usando a anotação @SerializedName

    private String title;
    private int releaseDate;
    private double sumRating;
    private int durationInMinutes;
    private int totalReviews;

    
//Construtor da classe Title para inicializar o título e a data de lançamento do título    

    public Title(String title, int releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }


//Construtor da classe Title que recebe um objeto TitleOmdb e extrai as informações relevantes para inicializar os atributos do título. Lança uma exceção se o formato do ano for inesperado ou se a conversão de runtime falhar.
    public Title(TitleOmdb myTitleOmdb) {

    this.title = myTitleOmdb.title();

// Verifica se o campo 'year' tem um formato inesperado (mais de 4 caracteres) e lança uma exceção personalizada se for o caso
    if (myTitleOmdb.year().length() > 4) {
        throw new ErrorConvertYearException("O campo 'year' tem um formato inesperado: " + myTitleOmdb.year());
    }
// Tenta converter o campo 'year' para um inteiro e o campo 'runtime' para um inteiro, removendo a parte " min". Se ocorrer um erro de conversão, lança uma exceção personalizada com uma mensagem de erro detalhada.
    this.releaseDate = Integer.valueOf(myTitleOmdb.year());
    this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().replace(" min", ""));
}

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

//Metodo para comparar os títulos com base no título para permitir a ordenação de uma lista de títulos
    @Override
    public int compareTo(Title other) {
        return this.getTitle().compareTo(other.getTitle());
    }

    @Override
    public String toString() {
        return "(Title: " + title + 
        ", Release Date: " + releaseDate + 
        ", Duration: " + durationInMinutes + " minutes)";
    }

}