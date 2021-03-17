import java.util.Scanner;
import java.lang.String;

public class Projeto {
    public static void main(String[] args) {
        System.out.println("Seja bem vindx. Esse é o sistema para folha de pagamento.");    
        Scanner input = new Scanner(System.in);
        System.out.println("É a sua primeira vez nesse sistema?(S/N)");
        String ativo = input.nextLine();
        if (ativo.equals("S")) {
            System.out.println("Okay, então vamos lá. Qual o seu nome:");
            String name = input.nextLine();
            // Pedir mais informações, como por exemplo, endereço.
            System.out.println("Perfil criado para o nome: " + name);
        } else {
            System.out.println("Digite seu nome para que seja pesquisado nos registros.");
            String name = input.nextLine();
            // if o nome for encontrado, continua.
            // if o nome não for encontrado, criar cadastro.
        }
        System.out.println("Pronto, agora o que você deseja fazer?");
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
        System.out.println("0 - Nenhuma das opções");
        int comando = input.nextInt();
        while (comando != 0){
            if (comando == 1) {
                //add();
                System.out.println("Adicionando empregado..."); 
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
            System.out.println("Para ver as opções novamente, digite 11, para encerrar, digite 0.");
            comando = input.nextInt();
            if (comando == 11) {
                System.out.println("Pronto, agora o que você deseja fazer?");
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
                System.out.println("0 - Nenhuma das opções");
            }
        }
    }
}
