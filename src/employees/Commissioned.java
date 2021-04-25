package src.employees;

import java.util.ArrayList;
import src.Sale;

public class Commissioned extends Employees {
    private double committee;
    private ArrayList<Sale> list_sales = new ArrayList<Sale>(); // cria uma lista dinâmica e não um array fixo que vai armazenas o todas as vendas dos comissionados.

    public Commissioned(String name, String adress, int method, int id, double committee) {
        super(name, adress, method, id);
        this.setCommittee(committee);
    }

    public void registerSale(String date, String nameItem, double value, int id_employee) {
        Sale sale = new Sale(date, nameItem, value, id_employee);
        this.list_sales.add(sale);
    }

    public double getCommittee() {
        return this.committee; // this opicional, pois só tem uma variavel com o nome "committee" nessa função.
    }

    public void setCommittee(double committee) {
        this.committee = committee;
    }
    

}