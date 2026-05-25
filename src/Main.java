import br.com.taysonkaue98.screenmatch.models.Movie;
import br.com.taysonkaue98.screenmatch.models.Series;
import br.com.taysonkaue98.screenmatch.models.Episodie;
import br.com.taysonkaue98.screenmatch.calculations.TimeCalculator;
import br.com.taysonkaue98.screenmatch.calculations.RecomendFilter;


public class Main {
    public static void main(String[] args) {

//Instanciando um objeto da classe Movie e atribuindo valores aos seus atributos

        Movie movie1 = new Movie();
        movie1.setTitle("The Matrix");
        movie1.setReleaseDate(1999);
        movie1.setDurationInMinutes(136);

//Chamando os métodos do objeto movie1 para exibir informações, adicionar avaliações e calcular a média das avaliações

        movie1.displayTitleInfo();
        movie1.addReview(9.5);
        movie1.addReview(8.0);
        movie1.addReview(6.0);

        System.out.println("Total Reviews: " + movie1.getTotalReviews());
        System.out.println(movie1.avarageRating());

//Instanciando um objeto da classe Series e atribuindo valores aos seus atributos

        Series series1 = new Series();
        series1.setTitle("Breaking Bad");
        series1.setReleaseDate(2008);
        series1.setSeasons(5);
        series1.setEpisodesPerSeason(13);
        series1.setMinutesPerEpisode(45);
        System.out.println("Time for consume the series: " + series1.getDurationInMinutes() + " minutes");

//Instanciando outro objeto da classe Movie e atribuindo valores aos seus atributos

        Movie otherMovie = new Movie();
        otherMovie.setTitle("Interstellar");
        otherMovie.setReleaseDate(2014);
        otherMovie.setDurationInMinutes(169);

// Instanciando um objeto da classe TimeCalculator e utilizando-o para calcular o tempo total necessário para consumir os títulos criados
        
        TimeCalculator calculator = new TimeCalculator();
        calculator.addMinutes(movie1);
        calculator.addMinutes(otherMovie);
        calculator.addMinutes(series1);
        System.out.println("Total time to consume the titles: " + calculator.getTotalMinutes() + " minutes");


        RecomendFilter recomendFilter = new RecomendFilter();
        recomendFilter.filterByClassification(movie1);
        
        Episodie episode1 = new Episodie();

        episode1.setTitle("Pilot");
        episode1.setEpisodeNumber(1);
        episode1.setTotalReviews(120);
        episode1.setSeries(series1);
        recomendFilter.filterByClassification(episode1);
    }

    
}
