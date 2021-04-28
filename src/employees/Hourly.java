package src.employees;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Time;
import src.TimeCard;


public class Hourly extends Employees {
    private ArrayList<TimeCard> listTimeCards = new ArrayList<TimeCard>(); // um horista tem varios cartões de ponto

    public Hourly(String name, String adress, String method, int id) {
        super(name, adress, method, id);// chama o construtor da classe pai.
    }

    public void addTimeCard(TimeCard timeCard){
        listTimeCards.add(timeCard);
    }

    public void getHoursWeekly(TimeCard timeCard){
        timeCard.setHoursWeekly(listTimeCards);
    }

    public void add(){
        Scanner input = new Scanner(System.in);
        System.out.println("Data: (DD/MM/AA)");
        String date = input.nextLine();
        System.out.println("Hora de entrada: (24h)");
        int in = input.nextInt();
        System.out.println("Hora de saida: (24h)");
        int out = input.nextInt();
        TimeCard timeCard = new TimeCard(in, out, date);
        addTimeCard(timeCard);
    }
}
