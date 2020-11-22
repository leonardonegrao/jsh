package com.unifil.gerencia;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComandosInternosTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void deveExibirRelogio() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();

        String[] formattedDateAndTime = dateTimeFormatter.format(now).split(" ");
        String response = formattedDateAndTime[0] + " às " + formattedDateAndTime[1];

        ComandosInternos.exibirRelogio();
        Assert.assertEquals(response, outContent.toString().trim());
    }

    @Test
    public void deveEscreverListaArquivos() {
        String path = System.getProperty("user.dir");

        File f = new File(java.util.Optional.ofNullable(path).get());
        String[] pathNames = f.list();

        String response = String.join("\n", pathNames);

        ComandosInternos.escreverListaArquivos(java.util.Optional.ofNullable(path));

        Assert.assertEquals(response, outContent.toString().trim());
    }

    @Test
    public void deveCriarNovoDiretório() {
        String pathString = System.getProperty("user.dir");

        Path path = Paths.get(pathString, "deveCriarNovoDiretorio");
        String response = "Diretório criado: " + path;

        ComandosInternos.criarNovoDiretorio("deveCriarNovoDiretorio");

        Assert.assertEquals(response, outContent.toString().trim());
    }

    @Test
    public void deveApagarDiretorio() {
        String pathString = System.getProperty("user.dir");

        Path path = Paths.get(pathString, "deveApagarEsseDiretório");
        String responseOfCreation = "Diretório criado: " + path;

        ComandosInternos.criarNovoDiretorio("deveApagarEsseDiretório");

        ComandosInternos.apagarDiretorio("deveApagarEsseDiretório");
        String response = responseOfCreation + "\n" + "Diretório removido: " + "deveApagarEsseDiretório";

        Assert.assertEquals(response, outContent.toString().trim());
    }
}
