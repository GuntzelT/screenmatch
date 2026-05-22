import br.com.taysonkaue98.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {

//Instanciando um objeto da classe Movie e atribuindo valores aos seus atributos
        Movie movie1 = new Movie();
        movie1.setTitle("The Matrix");
        movie1.setReleaseDate(1999);
        movie1.setDuration(136);
//Chamando os métodos do objeto movie1 para exibir informações, adicionar avaliações e calcular a média das avaliações
        movie1.displayMovieInfo();
        movie1.addReview(9.5);
        movie1.addReview(8.0);
        movie1.addReview(6.0);

        System.out.println("Total Reviews: " + movie1.getTotalReviews());
        System.out.println(movie1.avarageRating());
    }
}
