package conversion;

import adapters.LocalDateTimeAdapter;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

/**Clase que representa una conversión entre monedas.*/
public class Conversion {

    /**Código de moneda origen. */
    @SerializedName("Moneda_Origen")
    private String monedaOrigen;

    /** Código de moneda destino. */
    @SerializedName("Moneda_Destino")
    private String monedaDestino;

    /** Cantidad de moneda a convertir. */
    @SerializedName("Monto_a_Convertir")
    private double monto;

    /** Resultado de la conversión. */
    @SerializedName("Resultado")
    private double resultado;

    /** La tasa de conversión. */
    @SerializedName("Tasa_Conversion")
    private double conversionRate;

    /** Constructor vacío. */
    public Conversion() {}

    /**
     * Constructor con parámetros.
     * @param monedaOrigen El código de la moneda de origen.
     * @param monedaDestino El código de la moneda de destino.
     * @param monto El monto a convertir.
     */
    public Conversion(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
    }

    // Getters y setters

    public String getMonedaOrigen() {
        return monedaOrigen;
    }
    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }
    public String getMonedaDestino() {
        return monedaDestino;
    }
    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public double getResultado() {
        return resultado;
    }
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    public double getConversionRate() {
        return conversionRate;
    }
    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
        // Construir la URI para la solicitud a la API
        URI direccion_API = URI.create("https://v6.exchangerate-api.com/v6/ee44a5eea5830bf4729509a0/pair/"
                + codMonOrigen + "/" + codMonDestino + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion_API)
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (JsonReader reader = new JsonReader(new StringReader(response.body()))) {
            reader.setLenient(true);

            Gson gson = new GsonBuilder().setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();
            ConversionResponse conversionResponse = gson.fromJson(reader, ConversionResponse.class);

            this.conversionRate = conversionResponse.getConversionRate();
            this.resultado = monto * conversionRate;


            Conversion conversion = new Conversion(conversionResponse.getMonedaOrigen(), conversionResponse.getMonedaDestino(), monto);
            conversion.setResultado(resultado);
            conversion.setConversionRate(conversionResponse.getConversionRate());

            RegistroConversion registroConversion = new RegistroConversion(conversion);

            RegistroConversion[] historial;
            try (Reader fileReader = new FileReader("records.json")) {
                historial = gson.fromJson(fileReader, RegistroConversion[].class);
            } catch (FileNotFoundException e) {
                historial = new RegistroConversion[0];
            }

            RegistroConversion[] nuevoHistorial = new RegistroConversion[historial.length + 1];
            System.arraycopy(historial, 0, nuevoHistorial, 0, historial.length);
            nuevoHistorial[historial.length] = registroConversion;

            try (Writer fileWriter = new FileWriter("records.json")) {
                gson.toJson(nuevoHistorial, fileWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return registroConversion;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
