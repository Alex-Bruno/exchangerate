package br.com.alura.conversor.modelos;

import java.time.LocalDateTime;

public record Log(
        String data,
        String codigoBase,
        String codigoDestino,
        Double valor,
        Double conversao
) {
}
