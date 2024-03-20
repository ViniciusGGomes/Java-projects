package MaquinaDeRefrigerante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bebidas cocaCola = new Bebidas("Coca-Cola", 3.0, 10);
        Bebidas fanta = new Bebidas("Fanta", 2.5, 8);
        Bebidas pepsi = new Bebidas("Pepsi", 2.8, 6);
        Bebidas monster = new Bebidas("Monster", 4.0, 5);
        Bebidas sprite = new Bebidas("Sprite", 2.7, 7);

        Bebidas[] estoqueInicial = { cocaCola, fanta, pepsi, monster, sprite };

        MaquinaRefrigerante maquina = new MaquinaRefrigerante(20, 50.0, estoqueInicial);

        Scanner scan = new Scanner(System.in);

        System.out.println("Bem-vindo à Máquina de Refrigerante!");

        boolean sair = false;

        while (sair != true) {
            ObterMenuOpcoes(estoqueInicial);

            int escolha = scan.nextInt();

            if (escolha >= 1 && escolha <= estoqueInicial.length) {
                System.out.println("Insira o valor (R$):");
                double valorInserido = scan.nextDouble();
                scan.nextLine();

                
                double troco = maquina.comprar(escolha - 1, valorInserido);

                if (troco >= 0) {
                    Bebidas bebidaSelecionada = estoqueInicial[escolha - 1];
                    System.out.println("Quantidade de " + bebidaSelecionada.getNome() + " restante: " + bebidaSelecionada.getQuantidade());
                    System.out.println("Dinheiro na máquina após compra: " + maquina.getDinheiro());
                    System.out.println("Troco: R$" + troco);
                } else {
                    System.out.println("Desculpe, não é possível realizar a compra.");
                    System.out.println("Devolvendo dinheiro: R$" + valorInserido);
                }
            } else {
                System.out.println("Opção inválida.");
            }

        
            System.out.println("Deseja comprar outra bebida? (s/n)");
            String continuar = scan.nextLine();
            if(continuar.equalsIgnoreCase("n")) {
            	sair = true;
            }
        }
    }

    
    // Método static para exibir o menu de opções
    private static void ObterMenuOpcoes(Bebidas[] estoque) {
        System.out.println("Escolha uma bebida:");
        for (int i = 0; i < estoque.length; i++) {
            System.out.println((i + 1) + ". " + estoque[i].getNome() + " - R$" + estoque[i].getValor());
        }
        
        
    }
}