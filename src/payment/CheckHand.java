package src.payment;

public class CheckHand extends Payment {
    private String nameEmployee;
    private int idEmployee;

    public String getNameEmployee() {
        return nameEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public CheckHand(int id, String nameEmployee) {
        setIdEmployee(id);
        setNameEmployee(nameEmployee);
    }
}