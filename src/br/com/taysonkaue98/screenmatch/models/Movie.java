package br.com.taysonkaue98.screenmatch.models;
import br.com.taysonkaue98.screenmatch.calculations.Classification;

public class Movie extends Title implements Classification {

//Atributos da classe Movie

    private String director;

//Construtor da classe Movie para inicializar o título e a data de lançamento do filme
    public Movie(String title, int releaseDate) {
        super(title, releaseDate);
    }

//Metodo para obter o diretor do filme

    public String getDirector() {
        return director;
    }

//Metodo para definir o diretor do filme

    public void setDirector(String director) {
        this.director = director;
    }

//Sobrescreve o método getClassification da interface Classification para calcular a classificação do filme com base na média das avaliações
    
    public int getClassification() {
        return (int) avarageRating() / 2;
    }

// Sobrescreve o método toString para fornecer uma representação personalizada do objeto Movie
    @Override
    public String toString() {
        return "Movie: " + this.getTitle() + " (" + this.getReleaseDate() + ")";
    }

}