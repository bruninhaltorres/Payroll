package src.employees;
import java.util.Random;

public class Syndicate extends Employees {
    private int idSyndicate;
    private double feeMonthly;
    private double feeService;
    private static Syndicate syndicateList[];

    private void generate_idSyndicate() {
        Random random = new Random();
        int id;
        id = random.nextInt(500);
        while (syndicateList[id] != null){
            id = random.nextInt(500);
        }
        this.idSyndicate = id;
    }

    public Syndicate(int count) { // Contrutor para defini o tamanho do array que vai juntar todos os sindicatos em uma lista.
        Syndicate.syndicateList = new Syndicate[count];
    }

    public Syndicate(String name, String adress, int method, int id) {
        super(name, adress, method, id);
        this.generate_idSyndicate();
    }
}
