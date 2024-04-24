package conversion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*** Clase que representa un registro de conversión.*/
public class RegistroConversion {
    private Conversion conversion; // Representa la conversión realizada
    private LocalDateTime timestamp; // Marca de tiempo de la conversión

    public RegistroConversion(Conversion conversion) {
        this.conversion = conversion;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y setters
    public Conversion getConversion() {
        return conversion;
    }


    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Registro de Conversión: {" +
                "\n  Moneda de Origen: " + conversion.getMonedaOrigen() +
                "\n  Moneda de Destino: " + conversion.getMonedaDestino() +
                "\n  Monto: " + conversion.getMonto() +
                "\n  Conversion Rate: " + conversion.getConversionRate() +
                "\n  Resultado: " + conversion.getResultado() +
                "\n  Marca de Tiempo: " + timestamp.format(formatter) +
                "\n}";
    }
}
