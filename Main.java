import src.employees.Commissioned;
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
    public static void actions(){
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
    }
    public static void main(String[] args) {
        System.out.println("Esse é o sistema para folha de pagamento.");    
        Scanner input = new Scanner(System.in);
        actions();
        int comando = input.nextInt();
        ArrayList<Employees> listEmployees = new ArrayList<Employees>(); 
        ArrayList<Syndicate> listSyndicate = new ArrayList<Syndicate>(); 

        while (comando != 0){
            if (comando == 1) {
                System.out.println("Adicionando empregado..."); 

                int idEmployee = generateId(listEmployees);

                Employees employees = new Employees(idEmployee);
                employees.add();

                System.out.println("O empregado é...\n1 - Horista\n2 - Comissionado");
                int type = input.nextInt();
                
                if (type == 1) { // horista
                    //System.out.println("Então preciso de mais algumas informações");
                    Hourly hourly = new Hourly(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId());                    
                    listEmployees.add(hourly);
                    // hourly.add();
                } if (type == 2) {
                    double valueComissioned;
                    System.out.println("Valor da comissão:");
                    valueComissioned = input.nextDouble();
                    Commissioned commissioned = new Commissioned(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId(), valueComissioned);
                    listEmployees.add(commissioned);
                }

                System.out.println("Ele irá fazer parte do Sindicato?\n1 - Sim\n2 - Não");
                int isSyndicate = input.nextInt();
                if(isSyndicate == 1) {
                    int idSyndicate = generateIdSyndicate(listSyndicate);
                    Syndicate syndicate = new Syndicate(idSyndicate);
                    syndicate.add(idEmployee);
                    listSyndicate.add(syndicate);
                }
                System.out.println("Id adicionado: " + idEmployee);
                for (Employees employeesOk : listEmployees) {
                    System.out.println("Empregado " + employeesOk.getName() + " adicionado com sucesso!");
                    /*if(employeesOk.getId() == idEmployee) {
                        System.out.println("Empregado " + employeesOk.getName() + " adicionado com sucesso!");
                    }*/
                }
            } else if (comando == 2) {
                System.out.println("Qual o identificador do empregado que você deseja remover?");
                int idRemove = input.nextInt();
                Employees employeeRemove = null;
                for(Employees employees : listEmployees){
                    if(employees.getId() == idRemove){
                        employeeRemove = employees;
                    }
                }
                listEmployees.remove(employeeRemove);

                Syndicate syndicateRemove = null;
                for(Syndicate syndicate : listSyndicate){
                    if(syndicate.getIdSyndicate() == idRemove){
                        syndicateRemove = syndicate;
                    }
                }
                listSyndicate.remove(syndicateRemove);

                /*
                List<Employees> employeeRemove = new ArrayList<Employees>();
                for(Employees employees : listEmployees){
                    if(employees.getId() == idRemove){
                        employeeRemove.add(employees);
                    }
                }
                listEmployees.removeAll(employeeRemove);
                */
                System.out.println("Removendo empregado..."); 

                System.out.println("Todos os empregados: ");
                for (Employees employeesOk : listEmployees) {
                    System.out.println(employeesOk.getName());
                }

                System.out.println("Empregado removido!"); 
            } else if (comando == 3) {
                System.out.println("Qual seu numero de identificação?");
                int idTimeCard = input.nextInt();
                /*
                int size = listEmployees.size();
                for(int i = 0; i < size; i++) {
                    if(listEmployees.get(i).getId() == idTimeCard) {
                        if(listEmployees.get(i).getClass() == Hourly.class) {
                            ((Hourly)listEmployees.get(i)).addTimeCard(); // A posição i da lista é convertida para Houyrly nesse momento. Depois volta a ser Employee. 
                        }
                    }
                }
                */
                for(Employees employees : listEmployees){
                    if(employees.getId() == idTimeCard){
                        if(employees.getClass() == Hourly.class){
                            ((Hourly)employees).addTimeCard();
                        }
                    }
                }
                System.out.println("Cartão de ponto lançado!");
            } else if (comando == 4) {
                System.out.println("Qual seu numero de identificação?");
                int idVendedor = input.nextInt();
                /*
                int size = listEmployees.size();
                for(int i = 0; i < size; i++) {
                    if(listEmployees.get(i).getId() == idTimeCard) {
                        if(listEmployees.get(i).getClass() == Hourly.class) {
                            ((Hourly)listEmployees.get(i)).addTimeCard(); // A posição i da lista é convertida para Houyrly nesse momento. Depois volta a ser Employee. 
                        }
                    }
                }
                */
                for(Employees employees : listEmployees){
                    if(employees.getId() == idVendedor){
                        if(employees.getClass() == Commissioned.class){
                            ((Commissioned)employees).addSale();
                        }
                    }
                }
                System.out.println("Venda cadastrada!");
            } else if (comando == 5) {
                //
                System.out.println("Taxa de serviço adicionada!");
            } else if (comando == 6) {
                //
                System.out.println("Alteração feita!");
            } else if (comando == 7) {
                //
                System.out.println("Pagamentos efetuados com sucesso!");
            } else if (comando == 8) {
                //
                System.out.println("Ação desfeita. (undo)");
                System.out.println("Ação refeita. (redo)");
            } else if (comando == 9) {
                //
            } else {
                //
            }
            System.out.println("11 - Ver as opções novamente\n0 - Encerrar");
            comando = input.nextInt();
            if (comando == 11) {
                actions();
            }
            input.nextLine();
        }
        input.close();
    }
}
