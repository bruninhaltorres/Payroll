package src.employees;

import java.util.Scanner;
import java.lang.String;

public class Employees {
    private String name;
    private String adress;
    private String methodPayment;
    private double salary;
    private int id;


    public String getName(){
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getAdress(){
        return adress;
    }

    public void setAdress(String setAdress) {
        this.adress = setAdress;
    }

    public String getMethodPayment(){
        return methodPayment;
    }

    public double getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

    public Employees(int id) {
        this.id = id;
    }

    public Employees(String name, String adress, String method, int id) { // contrutor 2. Pode ter vários e o que vai mudar de um pro outro são os parâmetros.
        this.setName(name);
        this.setAdress(adress);
        this.id = id;
        this.methodPayment = method;
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

    public void add(){
        // ---- NOME ----
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do empregado:");
        this.name = input.nextLine();
    
        System.out.println("Insira o endereco do empregado:");
        this.adress = input.nextLine();
    
        // ---- FORMA PAGAMENTO ----
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Em mãos");
        System.out.println("2 - Depósito bancário");
        System.out.println("3 - Cheque pelos correios");
        int method = input.nextInt();
        payment_method(method);
        // ---- TIPO EMPREGADO ----
        
        System.out.println("Empregado adicionado com sucesso!");
        System.out.println(this.name);
    //System.out.println(id);
    }
}
