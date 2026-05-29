package br.com.taysonkaue98.screenmatch.models;
import br.com.taysonkaue98.screenmatch.calculations.Classification;


public class Episodie extends Title implements Classification {

    // Atributos da classe Episodie
    private int episodeNumber;
    private String title;
    private Series series;
    private int totalReviews;

    public Episodie() {
        super("", 0);
    }

    // Metodos para obter o total de avaliações do episódio
    public int getTotalReviews() {
        return totalReviews;
    }

    public int setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
        return totalReviews;
    }

    // Metodos para obter e definir o número do episódio
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    // Metodos para obter e definir o título do episódio
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Metodos para obter e definir a série a qual o episódio pertence
    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
    
    // Sobrescreve o método getClassification da interface Classification para calcular a classificação do episódio com base na média das avaliações

    @Override
        public int getClassification() {
            if (totalReviews > 100) {
                return 5;
            } else if (totalReviews > 50) {
                return 4;
            } else if (totalReviews > 20) {
                return 3;
            } else if (totalReviews > 10) {
                return 2;
            } else {
                return 1;
            }
        }
}
