package br.com.taysonkaue98.screenmatch.models;
import br.com.taysonkaue98.screenmatch.calculations.Classification;

public class Series extends Title implements Classification {

// Atributos da classe Series + Herança da classe Title

    private int seasons;
    private int episodesPerSeason;
    private boolean active;
    private int minutesPerEpisode;

//Construtor da classe Series para inicializar o título e a data de lançamento da série
    public Series(String title, int releaseDate) {
        super(title, releaseDate);
    }

// Metodos para obter e definir as temporadas da série

    public int getSeasons() {    
        return seasons;
    }   

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

//Metodos para obter e definir os episódios por temporada da série

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }  

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }   

//Metodos para obter e definir se a série está ativa ou não

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }  

//Metodos para obter e definir a duração de cada episódio da série

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

//Sobrescreve o método getDurationInMinutes da classe Title para calcular a duração total da série com base no número de temporadas, episódios por temporada e minutos por episódio
    
    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

//Sobrescreve o método getClassification da interface Classification para calcular a classificação da série com base na média das avaliações
    
@Override
    public int getClassification() {
        return (int) avarageRating() / 2;
    }

// Sobrescreve o método toString para fornecer uma representação personalizada do objeto Series
    @Override
    public String toString() {
        return "Series: " + this.getTitle() + " (" + this.getReleaseDate() + ")";
    }


    
}
