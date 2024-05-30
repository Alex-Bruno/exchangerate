package br.com.alura.conversor.auxiliares;

import br.com.alura.conversor.modelos.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogAuxiliar {
    private static final String arquivo = "log.json";
    private static final List<Log> logs = new ArrayList<>();

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static Log criar(String codigoBase, String codigoDestino, Double valor, Double conversao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return new Log(LocalDateTime.now().format(formatter), codigoBase, codigoDestino, valor, conversao);
    }

    public static void addLog(String codigoBase, String codigoDestino, Double valor, Double conversao) {
        Log log = criar(codigoBase, codigoDestino, valor, conversao);
        logs.add(log);
        salvarLogs();
    }

    private static void salvarLogs() {
        try (FileWriter fw = new FileWriter(arquivo);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(gson.toJson(logs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
