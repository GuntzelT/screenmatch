package br.com.taysonkaue98.screenmatch.calculations;
import br.com.taysonkaue98.screenmatch.models.Title;

public class TimeCalculator {

    //Atributo para armazenar o total de minutos calculados

    private int totalMinutes;

    public int getTotalMinutes() {
        return this.totalMinutes;
    }

    public void addMinutes(Title title) {
        this.totalMinutes += title.getDurationInMinutes();
    }
}
