package src.employees;

import java.util.ArrayList;
import src.TimeCard;

public class Hourly extends Employees {
    private ArrayList<TimeCard> list_timeCards = new ArrayList<TimeCard>(); // cria uma lista dinâmica e não um array fixo que vai armazenas o cartão de ponto de todos os horistas.

    public Hourly(String name, String adress, int method, int id) {
        super(name, adress, method, id);// chama o construtor da classe pai.
    }

    public void getTimeCards() {
        int hoursWeekly = 0;
        for (TimeCard timecard : list_timeCards) {
            hoursWeekly += timecard.getHoursWorked();
        }
        System.out.println("Horas trabalhadas essa semana: " + hoursWeekly);
    }

    public void setTimeCards(int in, int out, String date) {
        TimeCard timeCard = new TimeCard(in, out, date); // vai ser chamado quando eu for fazer a função que cria o cartão de ponto.
        this.list_timeCards.add(timeCard); // adiciona o cartão de ponto a lista.
    }
}
