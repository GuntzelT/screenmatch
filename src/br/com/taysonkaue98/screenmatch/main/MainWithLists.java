package br.com.taysonkaue98.screenmatch.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; 
import br.com.taysonkaue98.screenmatch.models.Movie;
import br.com.taysonkaue98.screenmatch.models.Series;
import br.com.taysonkaue98.screenmatch.models.Title;
import java.util.List;

public class MainWithLists {
    public static void main(String[] args) {
        
        // Criando instâncias de filmes e séries, adicionando avaliações e armazenando-os em uma lista de títulos
        
        var movie1 = new Movie("The Matrix", 1999);
        movie1.addReview(9);

        var movie2 = new Movie("Interstellar", 2014);
        movie2.addReview(8);

        var movie3 = new Movie("Alien", 1979);
        movie3.addReview(7);

        var series1 = new Series("Breaking Bad", 2008);
        series1.addReview(10);
        
        var series2 = new Series("Game of Thrones", 2011);
        series2.addReview(7);

        // Criando uma lista de títulos e adicionando os filmes e séries criados
        List<Title> watchList = new ArrayList<>();
        watchList.add(movie2);
        watchList.add(series1);
        watchList.add(movie1);
        watchList.add(series2);

        // Imprime o título de cada item na lista de títulos e, se o item for um filme, imprime sua classificação
        for (Title item : watchList) {
            System.out.println(item.getTitle());

            // Verifica se o item é uma instância de Movie usando pattern matching
            // Se for, o pattern matching permite fazer o cast diretamente na declaração do if

            if (item instanceof Movie movie) {

                // Realiza o cast para Movie e imprime a classificação do filme
                //var movie = (Movie) item;

                System.out.println("Classification: " + movie.getClassification());
            }
        }


        // Ordena a lista de títulos usando a implementação do método compareTo na classe Title
        Collections.sort(watchList);
        System.out.println(watchList);

        // Ordena a lista de títulos usando um Comparator para comparar os títulos em ordem de lancamento
        watchList.sort(Comparator.comparing(Title::getReleaseDate));
        System.out.println(watchList);
    }

}