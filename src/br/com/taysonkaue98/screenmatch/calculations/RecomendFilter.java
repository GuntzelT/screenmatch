package br.com.taysonkaue98.screenmatch.calculations;

public class RecomendFilter {

//Metodo para filtrar recomendações com base na classificação
    public void filterByClassification(Classification classification) {

        if (classification.getClassification() >= 4) {
            System.out.println("Highly recommended!");
        } else if (classification.getClassification() >= 2) {
            System.out.println("Recommended.");
        } else {
            System.out.println("Not recommended.");
        }
    }
}
