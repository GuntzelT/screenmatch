public class Movie {
    String title;
    int releaseDate;
    double sumRating;
    int duration;
    int budget;
    int totalReviews;
    boolean isAvailableOnStreaming;


//Metodo para mostrar informações do filme
    void displayMovieInfo() {
        System.out.println("Title: " + title);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Budget: R$" + budget);
    }

//Metodo para adicionar uma avaliação ao filme
    void addReview(double rating) {
        sumRating += rating;
        totalReviews++;
    }
//Metodo para calcular a média das avaliações do filme
    double avarageRating() {
        if (totalReviews == 0) {
            return 0;
        }

        return sumRating / totalReviews;
    }

}