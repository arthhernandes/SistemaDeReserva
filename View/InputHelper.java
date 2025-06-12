package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int getInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }

}