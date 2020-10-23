import java.util.List;
import java.util.Scanner;

public final class Jsh {

    public static void promptTerminal() {

        while (true) {
            exibirPrompt();
            ComandoPrompt comandoEntrado = lerComando();
            executarComando(comandoEntrado);
        }
    }

    public static void exibirPrompt() {

        String path = System.getProperty("user.dir");
        System.out.print("alunos2012#1337" + path + ": ");
    }

    public static ComandoPrompt lerComando() {

        Scanner scanner = new Scanner(System.in);
        String args = scanner.nextLine();

        return new ComandoPrompt(args);
    }

    public static void executarComando(ComandoPrompt comando) {

        throw new RuntimeException("Método ainda não implementado.");
    }

    public static int executarPrograma(ComandoPrompt comando) {
        throw new RuntimeException("Método ainda não implementado.");
    }

    public static void main(String[] args) {

        promptTerminal();
    }

    private Jsh() {}
}
