public class Main {
    public static void main(String[] args) {

//Instanciando um objeto da classe Movie e atribuindo valores aos seus atributos
        Movie movie1 = new Movie();
        movie1.title = "The Matrix";
        movie1.releaseDate = 1999;
        movie1.duration = 136;
        movie1.budget = 63000000;
    
        movie1.displayMovieInfo();
        movie1.addReview(9.5);
        movie1.addReview(8.0);
        movie1.addReview(6.0);

        System.out.println(movie1.sumRating);
        System.out.println(movie1.totalReviews);
        System.out.println(movie1.avarageRating());
    }
}
