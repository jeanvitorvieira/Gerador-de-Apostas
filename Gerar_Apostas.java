import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Gerar_Apostas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random gerador = new Random();
        // Try utilizado para garantir que apenas números inteiros sejam digitados
        try {
            System.out.println("\n $ GERADOR DE APOSTAS $");
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
            scan.close();
            System.out.print("\n Os números gerados foram: \n");
            // For utilizado para mostrar os números gerados na mesma linha e espaçados
            for (int i = 0; i < quantidadeNumeros; i++) {
                System.out.print(apostas[i] + " ");
            }
            System.out.println("\n\n BOA SORTE! \n");
        } catch (InputMismatchException e) {
            System.out.println("\n Apenas números inteiros são permitidos! \n");
        } finally {
            scan.close();
        }
    }
}