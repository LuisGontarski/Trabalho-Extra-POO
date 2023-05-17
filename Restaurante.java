import java.util.Scanner;

public class Restaurante {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome, itemSelecionado;
        double totalPedido = 0;
        double taxaServico = 0;
        double valorRecebido;
        double troco;
        int escolha = 0;
        do {
            System.out.println("--- Sistema Virtual ---");
            System.out.println("1 - Realizar Pedido");
            System.out.println("2 - Sair");
            int contador1 = 0;
            int contador2 = 0;
            int contador3 = 0;
            escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o seu nome: ");
                    nome = input.nextLine();

                    System.out.println("---- CARDÁPIO ----");
                    System.out.println("1 - Omelete - R$ 10.00");
                    System.out.println("2 - Misto Quente - R$ 12.00");
                    System.out.println("3 - Refrigerante - R$ 5.00");
                    System.out.println("0 - Finalizar Pedido");

                    do {
                        System.out.print("Digite o número do item desejado: ");
                        itemSelecionado = input.nextLine();

                        switch (itemSelecionado) {
                            case "1":
                                totalPedido += 10.00;
                                contador1 = contador1 + 1;
                                break;
                            case "2":
                                totalPedido += 12.00;
                                contador2 = contador2 + 1;
                                break;
                            case "3":
                                totalPedido += 5.00;
                                contador3 = contador3 + 1;
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Item inválido, tente novamente.");
                        }
                    } while (!itemSelecionado.equals("0"));

                    taxaServico = totalPedido * 0.1;
                    double valorTotal = totalPedido + taxaServico;

                    System.out.println("---- NOTA FISCAL ----");
                    System.out.println("Cliente: " + nome);
                    System.out.println("Itens: ");
                    System.out.println(contador1 + " - Omelete - R$ 10.00");
                    System.out.println(contador2 + " - Misto Quente - R$ 12.00");
                    System.out.println(contador3 + " - Refrigerante - R$ 5.00");
                    System.out.printf("Taxa de Serviço (%.0f%%): R$ %.2f%n", (taxaServico/totalPedido)*100, taxaServico);
                    System.out.printf("Total: R$ %.2f%n", valorTotal);

                    do {
                        System.out.print("Digite o valor recebido: ");
                        valorRecebido = input.nextDouble();
                        troco = valorRecebido - valorTotal;

                        if (troco < 0) {
                            System.out.println("Valor insuficiente, digite um valor maior.");
                        }
                    } while (troco < 0);

                    System.out.printf("Troco: R$ %.2f%n", troco);
                    totalPedido = 0;
                    taxaServico = 0;
                    break;
                case 2:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (escolha != 2);
    }

}
