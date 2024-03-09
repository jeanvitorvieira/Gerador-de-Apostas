import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Gerador_Apostas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random gerador = new Random();
        int con = 1;
        System.out.println("\n $ GERADOR DE APOSTAS $");
        // Loop do algoritmo
        while (con != 2) {
            // Try utilizado para garantir que apenas números inteiros sejam digitados
            try {
                System.out.println("\n Digite quantos números você precisa para apostar: ");
                int quantidadeNumeros = scan.nextInt();
                System.out.println("\n Digite o início do intervalo desses números: ");
                int inicioIntervalo = scan.nextInt();
                int fimIntervalo;
                // Do While utilizado para garantir que o fim do intervalo seja maior que o início
                do {
                    System.out.println("\n Digite o fim do intervalo desses números (deve ser maior que o início): ");
                    fimIntervalo = scan.nextInt();
                } while (fimIntervalo <= inicioIntervalo);
                // Array com o tamanho de quantidadeNumeros utilizado para guardar os números finais
                int[] apostas = new int[quantidadeNumeros];
                // For utilizado para determinar cada número
                for (int i = 0; i < quantidadeNumeros; i++) {
                    int numeroGerado;
                    boolean numeroRepetido;
                    // Do While utilizado para gerar os números
                    do {
                        numeroGerado = gerador.nextInt((fimIntervalo - inicioIntervalo) + 1) + inicioIntervalo;
                        numeroRepetido = false;
                        // For utilizado para verificar se o número ja foi gerado e, caso sim, gerar outro
                        for (int j = 0; j < i; j++) {
                            if (apostas[j] == numeroGerado) {
                                numeroRepetido = true;
                                break;
                            }
                        }
                    } while (numeroRepetido);
                    // Por fim, o número gerado que não é repetido é adicionado a aposta
                    apostas[i] = numeroGerado;
                }
                System.out.print("\n Os números gerados foram: \n");
                // Método que organiza o array em ordem crescente
                Arrays.sort(apostas);
                // For que percorre o array apostas e vai colocando em linha única com espaços
                for (int aposta : apostas) {
                    System.out.print(aposta + " ");
                }
                System.out.println("\n\n Deseja continuar? \n");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO \n");
                scan.nextLine();
                String cons = scan.next();
                // Permite apenas números inteiros
                try {
                    con = Integer.parseInt(cons);
                } catch (NumberFormatException e) {
                    System.out.println("\n Apenas números inteiros são permitidos!");
                    break;
                }
                // Apenas opções permitidas
                if (con != 1 && con != 2) {
                    System.out.println("\n Opção inválida! \n");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Apenas números inteiros são permitidos! \n");
                break;
            }
        }
        scan.close();
    }
}
