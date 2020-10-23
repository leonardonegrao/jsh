import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ComandoPrompt {

    public ComandoPrompt(String comando) {

        String[] argsToArray = comando.split(" ");
        String nomeDoComando = argsToArray[0];

        this.argumentos = new String[2];
        this.argumentos[0] = argsToArray[0];

        if (argsToArray.length > 1) {
            this.argumentos[1] = argsToArray[1];
        }

        this.nome = nomeDoComando;
    }

    /**
     * Método acessor get para o nome do comando.
     *
     * @return o nome do comando, exatamente como foi entrado.
     */
    public String getNome() {

        return nome;
    }

    /**
     * Método acessor get para os argumentos que seguram ao nome do comando.
     *
     * @return Lista de argumentos do comando, protegida contra modificações externas.
     */
    public List<String> getArgumentos() {

        return Collections.unmodifiableList(Arrays.asList(argumentos));
    }

    private final String nome;
    private final String[] argumentos;
}
