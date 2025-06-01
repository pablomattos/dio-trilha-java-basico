import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int conta = -1;
        String agencia = "";
        String nomeDoCliente = "";
        float saldo = 0;

        // Validação do nome do cliente
        while (true) {
            System.out.print("Digite o seu nome completo: ");
            nomeDoCliente = scanner.nextLine();

            if (nomeDoCliente.matches("^[A-Za-zÀ-ÿ ]+$")) {
                break;
            } else {
                System.out.println("Nome inválido. Digite apenas letras (sem números ou símbolos).");
            }
        }

        // Validação da agência
        String regex = "^\\d{4}-\\d{1}$";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            System.out.print("Olá " + nomeDoCliente + ", digite sua agência bancária (formato XXXX-X): ");
            agencia = scanner.nextLine();

            Matcher matcher = pattern.matcher(agencia);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Formato inválido. Use o formato XXXX-X (ex: 2414-2).");
            }
        }

        // Validação da conta
        while (true) {
            System.out.print("Digite os cinco números da sua conta (Ex.:00001): ");

            if (scanner.hasNextInt()) {
                conta = scanner.nextInt();

                if (conta > 0 && conta <= 99999) {
                    break;
                } else {
                    System.out.println("Conta inválida. Deve estar entre 1 e 99999.");
                }
            } else {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                scanner.next(); // Limpa entrada inválida
            }
        }

        // Leitura do saldo
        while (true) {
            System.out.print("Digite o seu saldo atual: ");
            if (scanner.hasNextFloat()) {
                saldo = scanner.nextFloat();
                break;
            } else {
                System.out.println("Entrada inválida. Digite um valor numérico (use vírgula ou ponto).");
                scanner.next(); // Limpa entrada inválida
            }
        }

        // Formatação da conta com 5 dígitos
        String contaFormatada = String.format("%05d", conta);

        // Saída final
        System.out.println();
        System.out.println("Olá " + nomeDoCliente + "! Obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agencia + ", conta " + contaFormatada);
        System.out.println("Seu saldo é de R$ " + String.format("%.2f", saldo) + " já está disponível para saque.");

        scanner.close();
    }
}
