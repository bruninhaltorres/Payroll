import src.employees.Employees;
import src.employees.Syndicate;
import src.employees.Hourly;
import src.employees.Syndicate;

import java.util.Scanner;
import java.lang.String;
import java.util.Random;
import java.util.ArrayList;


public class Main {

    public static int generateId(ArrayList<Employees> employeeList) {
        Random random = new Random();
        int id, qntEmployees = employeeList.size(); // quantos empregados já foram cadastrados.
        id = random.nextInt(30);
        for (int i = 0; i < qntEmployees; i++){
            if (id == employeeList.get(i).getId()){
                id = random.nextInt(30);
                i = 0; // verificar lista toda do começo garantindo a não repetição do novo id.
            }
        }
        return id;
    }
    public static int generateIdSyndicate(ArrayList<Syndicate> syndicateList) {
        Random random = new Random();
        int id, qntEmployees = syndicateList.size(); // quantos empregados já foram cadastrados.
        id = random.nextInt(30);
        for (int i = 0; i < qntEmployees; i++){
            if (id == syndicateList.get(i).getIdSyndicate()){
                id = random.nextInt(30);
                i = 0; // verificar lista toda do começo garantindo a não repetição do novo id.
            }
        }
        return id;
    }
    public static void main(String[] args) {
        System.out.println("Esse é o sistema para folha de pagamento.");    
        Scanner input = new Scanner(System.in);

        System.out.println("Ações:"); // printar aos poucos?
        System.out.println("1 - Adicionar empregado"); 
        System.out.println("2 - Remoção empregado"); 
        System.out.println("3 - Lançar um cartão"); 
        System.out.println("4 - Lançar resultado venda");
        System.out.println("5 - Lançar taxa serviço"); 
        System.out.println("6 - Alterar detalhes"); 
        System.out.println("7 - Folha de pagamento para hoje");
        System.out.println("8 - Undo/redo");
        System.out.println("9 - Agendar pagamento");
        System.out.println("10 - Criar novas agendas");
        System.out.println("0 - Encerrar");

        int comando = input.nextInt();

        ArrayList<Employees> listEmployess = new ArrayList<Employees>(); 
        ArrayList<Syndicate> listSyndicate = new ArrayList<Syndicate>(); 

        while (comando != 0){
            if (comando == 1) {
                System.out.println("Adicionando empregado:"); 

                int idEmployee = generateId(listEmployess);

                Employees employees = new Employees(idEmployee);
                employees.add();

                System.out.println("O empregado é...\n1 - Horista\n2 - Comissionado");
                int type = input.nextInt();
                
                if (type == 1) { // horista
                    employees = new Hourly(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId());
                } if (type == 2) {
                    /*int comissioned;
                    System.out.println("O empregado é comissionado?\n1 - Sim\n2 - Não");
                    comissioned = input.nextInt();*/
                }
                if(employees.getClass() == Hourly.class){
                    System.out.println("Horista");
                }
                listEmployess.add(employees);

                System.out.println("Ele irá fazer parte do Sindicato?\n1 - Sim\n2 - Não");
                int isSyndicate = input.nextInt();
                if(isSyndicate == 1) {
                    int idSyndicate = generateIdSyndicate(listSyndicate);
                    Syndicate syndicate = new Syndicate(idSyndicate);
                    syndicate.add(idEmployee);
                    listSyndicate.add(syndicate);
                    // Syndicate add_syndicate = new Syndicate(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId()); // como usar o array de empregados aqui?
                } else {
                    System.out.println("Okay.\n");
                }
            } else if (comando == 2) {
                //remove();
                System.out.println("Removendo empregado..."); 
            } else if (comando == 3) {
                //
            } else if (comando == 4) {
                //
            } else if (comando == 5) {
                //
            } else if (comando == 6) {
                //
            } else if (comando == 7) {
                //
            } else if (comando == 8) {
                //
            } else if (comando == 9) {
                //
            } else {
                //
            }
            System.out.println("11 - Ver as opções novamente\n0 - Encerrar");
            comando = input.nextInt();
            if (comando == 11) {
                System.out.println("1 - Adicionar empregado"); 
                System.out.println("2 - Remoção empregado"); 
                System.out.println("3 - Lançar um cartão"); 
                System.out.println("4 - Lançar resultado venda");
                System.out.println("5 - Lançar taxa serviço"); 
                System.out.println("6 - Alterar detalhes"); 
                System.out.println("7 - Folha de pagamento para hoje");
                System.out.println("8 - Undo/redo");
                System.out.println("9 - Agendar pagamento");
                System.out.println("10 - Criar novas agendas");
                System.out.println("0 - Encerrar");
            }
            input.nextLine();
        }
        input.close();
    }
}
