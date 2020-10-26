import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class ComandosInternos {

    public static int exibirRelogio() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();

        String[] formattedDateAndTime = dateTimeFormatter.format(now).split(" ");
        System.out.println(formattedDateAndTime[0] + " às " + formattedDateAndTime[1]);

        return 0;
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

    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
