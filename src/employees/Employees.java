package src.employees;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Employees {
    protected String name;
    protected String adress;
    protected String methodPayment;
    protected double salary;
    protected int id;
    private static Employees employeeList[]; // Fixa para todos os empregados. Por exemplo, se for uma classe referente a carros e a variavel static se referir a marca dos pneus, todos os carros terão pneus da mesma marca.
    
    public Employees(int count) { // construtor 1
        Employees.employeeList = new Employees[count];
    }

    public Employees(String name, String adress, int method, int id) { // contrutor 2. Pode ter vários e o que vai mudar de um pro outro são os parâmetros.
        this.name = name;
        this.adress = adress;
        this.id = id;
        this.payment_method(method);
    }

    public void payment_method(int method) {
        if (method == 1) {
            this.methodPayment = "hand";
        } else if (method ==  2) {
            this.methodPayment = "deposit";
        } else if (method == 3) {
            this.methodPayment = "mail";
        } else {
            System.out.println("Metodo de pagamento inválido!\n");
        }
    }

    private void generate_id() {
        Random random = new Random();
        int id;
        id = random.nextInt(500);
        while (employeeList[id] != null){
            id = random.nextInt(500);
        }
        this.id = id;
    }

    public void add(){
        // ---- NOME ----
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do empregado:");
        String name = input.nextLine();
    
        System.out.println("Insira o endereco do empregado:");
        String address = input.nextLine();
    
        // ---- FORMA PAGAMENTO ----
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Em mãos");
        System.out.println("2 - Depósito bancário");
        System.out.println("3 - Cheque pelos correios");
        int method = input.nextInt();
    
        // ---- GERAR ID ----
        this.generate_id();
    
        // ---- TIPO EMPREGADO ----
        System.out.println("O empregado é horista(1) ou assalariado(2)?");
        int type = input.nextInt();
        
        if (type == 1) { // horista
            employeeList[id] = new Hourly(name, address, method, id);
        } else {
            int comissioned;
            System.out.println("O empregado é comissionado?(s/n)");
            comissioned = input.nextInt();
        }
    System.out.println("Empregado adicionado com sucesso!");
    System.out.println(employeeList[id].toString()); // sem o to.string só printaria o tipo da lista.
    input.close();
    }
}
