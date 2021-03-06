import src.employees.Commissioned;
import src.employees.Employees;
import src.employees.Syndicate;
import src.payment.Payroll;
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

    public static void invalid() {
        System.out.println("Acão inválida! Tente novamente.");
    }
    
    public static void main(String[] args) {
        System.out.println("Esse é o sistema para folha de pagamento.");    
        Scanner input = new Scanner(System.in);
        actions();
        int comando = input.nextInt();
        ArrayList<Employees> listEmployees = new ArrayList<Employees>(); 
        ArrayList<Syndicate> listSyndicate = new ArrayList<Syndicate>();
        Payroll payroll = new Payroll();
        while (comando != 0){
            if (comando == 1) {
                System.out.println("Adicionando empregado..."); 

                int idEmployee = generateId(listEmployees);

                Employees employees = new Employees(idEmployee);
                employees.add();

                System.out.println("O empregado é...\n1 - Horista\n2 - Comissionado\n3 - Assalariado");
                int type = input.nextInt();
                
                if (type == 1) { // horista
                    //System.out.println("Então preciso de mais algumas informações");
                    Hourly hourly = new Hourly(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId());                    
                    listEmployees.add(hourly);
                    // hourly.add();
                } else if (type == 2) {
                    double valueComissioned;
                    System.out.println("Valor da comissão:");
                    valueComissioned = input.nextDouble();
                    Commissioned commissioned = new Commissioned(employees.getName(), employees.getAdress(), employees.getMethodPayment(), employees.getId(), valueComissioned);
                    listEmployees.add(commissioned);
                } else {
                    listEmployees.add(employees);
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
                }
                for (Syndicate syndicateOk : listSyndicate) {
                    System.out.println("Empregado " + syndicateOk.getIdSyndicate() + " adicionado com sucesso na lista do Sindicato!");
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
            } else if (comando == 3) { // adicionando cartão de ponto
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
            } else if (comando == 4) { // cadastrando venda
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
                System.out.println("Qual seu número de identificação?");
                int idChange = input.nextInt();
                for(Syndicate syndicate : listSyndicate){
                    if(syndicate.getIdSyndicate() == idChange){
                        System.out.println("Qual a taxa cobrada pelo serviço? (R$)");
                        double feeService = input.nextDouble();
                        syndicate.setFeeService(feeService);
                    }
                }
                System.out.println("Taxa de serviço adicionada!");
            } else if (comando == 6) {
                System.out.println("O que você deseja alterar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Endereço");
                System.out.println("3 - Tipo(Horista/Comissionado/Assalariado)");
                System.out.println("4 - Método de pagamento");
                System.out.println("5 - Informações relacionadas ao sindicato");
                int change = input.nextInt();
                
                System.out.println("Qual seu número de identificação?");
                int idChange = input.nextInt();

                if (change == 1) {
                    System.out.println("Novo nome:");
                    String newName = input.next();
                    for(Employees employees : listEmployees){
                        if(employees.getId() == idChange){
                            employees.setName(newName);
                        }
                    }
                    // TESTANDO:
                    /*
                    for(Employees employees : listEmployees){
                        System.out.println("Data adicionada: " + timecard.getDate());
                    }
                    */
                } else if (change == 2) {
                    for(Employees employees : listEmployees){
                        if(employees.getId() == idChange){
                            System.out.println("Novo endereço:");
                            String newAdress = input.next();
                            employees.setName(newAdress);
                        }
                    }
                } else if(change == 3) {
                    for(Employees employees : listEmployees){
                        if(employees.getId() == idChange){
                            System.out.println("Para qual tipo o empregado será alterado?\n1 - Horista\n2 - Comissionado\n3 - Assalariado");
                            int newType = input.nextInt();
                            Employees aux = employees;
                            listEmployees.remove(employees);
                            if(newType == 1){
                                Hourly hourly = new Hourly(aux.getName(), aux.getAdress(), aux.getMethodPayment(), aux.getId());
                                listEmployees.add(hourly);
                            } else if (newType == 2) {
                                double valueComissioned;
                                System.out.println("Valor da comissão:");
                                valueComissioned = input.nextDouble();
                                Commissioned commissioned = new Commissioned(aux.getName(), aux.getAdress(), aux.getMethodPayment(), aux.getId(), valueComissioned);
                                listEmployees.add(commissioned);
                            } else {
                                Employees employees2 = new Employees(idChange);
                                employees2.add();
                                listEmployees.add(employees2);
                            }
                        }
                    }
                } else if (change == 4) {
                    for(Employees employees : listEmployees){
                        if(employees.getId() == idChange){
                            System.out.println("Qual o novo método de pagamento?");
                            System.out.println("1 - Em mãos");
                            System.out.println("2 - Depósito bancário");
                            System.out.println("3 - Cheque pelos correios");
                            int method = input.nextInt();
                            employees.payment_method(method, idChange);
                        }
                    }
                } else if (change == 5) {
                    System.out.println("Mais sobre essa opção...");
                    System.out.println("1 - Você deseja entrar ou sair do sindicato\n2 - Mudar a sua identificação de usuario no sindicato\n3 - Alterar taxa sindical");
                    int changeS = input.nextInt();
                    if (changeS == 1) {
                        System.out.println("1 - Entrar.\n2 - Sair");
                        int inOut = input.nextInt();
                        int pertence = 0;
                        if (inOut == 1) {
                            int idSyndicate = generateIdSyndicate(listSyndicate);
                            Syndicate syndicate2 = new Syndicate(idSyndicate);
                            syndicate2.add(idChange);
                            listSyndicate.add(syndicate2);
                        } else {
                            for(Syndicate syndicate : listSyndicate){
                                if(syndicate.getIdSyndicate() == idChange){
                                    listSyndicate.remove(syndicate);
                                    pertence = pertence + 1;
                                }
                            }
                            if (pertence == 0) {
                                System.out.println("Você não faz parte do sindicato.");
                            }
                        }
                    } if(changeS == 2) {
                        //2 - Mudar a sua identificação de usuario no sindicato
                        for(Syndicate syndicate : listSyndicate){
                            if(syndicate.getIdSyndicate() == idChange){
                                int idSyndicate = generateIdSyndicate(listSyndicate); // gero novo Id
                                syndicate.setIdSyndicate(idSyndicate);
                            }
                        }
                    } if (changeS == 3) { // Alterar taxa sindical
                        System.out.println("Qual a nova taxa sindical?");
                        double newFeeSyndical = input.nextDouble();
                        for(Syndicate syndicate : listSyndicate){
                            if(syndicate.getIdSyndicate() == idChange){
                                syndicate.setFeeSyndicate(newFeeSyndical);
                            }
                        }
                    }
                } else {
                    invalid();
                }
                System.out.println("Alteração feita!");
            } else if (comando == 7) {
                Payroll.payEmployees(listEmployees, payroll);
//                System.out.println("Pagamentos efetuados com sucesso!");
            } else if (comando == 8) {
                //
                System.out.println("Ação desfeita. (undo)");
                System.out.println("Ação refeita. (redo)");
            } else if (comando == 9) {
                //
            } else if (comando == 10) {
                //
            } else {
                invalid();
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
