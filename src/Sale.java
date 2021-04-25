package src;

public class Sale {
    public String date;
    public String nameItem;
    public double value;
    public int id_employee;

    public Sale(String date, String nameItem, double value, int id_employee) {
        this.date = date;
        this.nameItem = nameItem;
        this.value = value;
        this.id_employee = id_employee;
    }
}