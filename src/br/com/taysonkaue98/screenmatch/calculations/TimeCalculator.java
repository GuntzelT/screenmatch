package br.com.taysonkaue98.screenmatch.calculations;
import br.com.taysonkaue98.screenmatch.models.Title;

public class TimeCalculator {

    //Atributo para armazenar o total de minutos calculados

    private int totalMinutes;

    //Metodo para obter o total de minutos calculados

    public int getTotalMinutes() {
        return this.totalMinutes;
    }

    //Metodo para adicionar os minutos de um título ao total de minutos calculados
    public void add(Title title) {
        this.totalMinutes += title.getDurationInMinutes();
    }
}
