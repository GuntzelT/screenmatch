package br.com.taysonkaue98.screenmatch.models;

public class Series extends Title {

// Atributos da classe Series + Herança da classe Title

    private int seasons;
    private int episodesPerSeason;
    private boolean active;
    private int minutesPerEpisode;

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


    
}
