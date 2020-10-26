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

    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
