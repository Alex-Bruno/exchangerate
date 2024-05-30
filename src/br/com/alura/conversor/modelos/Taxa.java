package br.com.alura.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public record Taxa(
        @SerializedName("result")
        String resultado,
        @SerializedName("base_code")
        String codigoBase,
        @SerializedName("target_code")
        String codigoDestino,
        @SerializedName("conversion_rate")
        double taxa
) {
}
