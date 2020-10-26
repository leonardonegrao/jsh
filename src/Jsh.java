import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
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

        List<String> args = comando.getArgumentos();

        switch (comando.getNome()) {
            case "encerrar":
                System.out.println("Encerrando JSH...");
                System.exit(0);
                break;
            case "relogio":
                ComandosInternos.exibirRelogio();
                break;
            case "la":
                String path = System.getProperty("user.dir");
                ComandosInternos.escreverListaArquivos(java.util.Optional.ofNullable(path));
                break;
            case "cd":
                ComandosInternos.criarNovoDiretorio(args.get(1));
                break;
            case "ad":
                ComandosInternos.apagarDiretorio(args.get(1));
                break;
            default:
                break;
        }
    }

    public static int escreverListaArquivos(Optional<String> nomeDir) {
        File f = new File(nomeDir.get());
        String[] pathNames = f.list();

        for (String pathName : pathNames) {
            System.out.println(pathName);
        }

        return 0;
    }

    public static int criarNovoDiretorio(String nomeDir) {
        String pathString = System.getProperty("user.dir");

        Path path = Paths.get(pathString, nomeDir);

        try {
            Files.createDirectories(path);
            System.out.println("Diretório criado: " + path);
            return 0;
        } catch (IOException e) {
            System.err.println(e);
            return 1;
        }
    }

    public static int apagarDiretorio(String nomeDir) {
        String pathString = System.getProperty("user.dir");
        File index = new File(pathString, nomeDir);

        String[] entries = index.list();

        for (String s : entries) {
            File currentFile = new File(index.getPath(), s);
            currentFile.delete();
        }

        index.delete();

        System.out.println("Diretório removido: " + nomeDir);

        return 0;
    }

    public static void main(String[] args) {

        promptTerminal();
    }

    private Jsh() {}
}
