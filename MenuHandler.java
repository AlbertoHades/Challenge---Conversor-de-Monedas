package menu;

import conversion.Conversion;
import conversion.RegistroConversion;

import java.util.Scanner;

public class MenuHandler {
    public static void mostrarMenu() {
        System.out.println("************************************************************");
        System.out.println("""
                Selecione la opcion deseada:
                1- Convertir de MXN (peso mexicano) a USD (dólar).
                2- Convertir de USD (dólar) a MXN (peso mexicano).
                3- Convertir de BRL (real brasileño) a USD (dólar).
                4- Convertir de USD (dólar) a BRL (real brasileño).
                5- Convertir de EUR (Euro) a USD (dólar).
                6- Convertir de USD (dólar) a EUR (Euro).
                7- Elegir otras monedas para convertir.
                8- Salir
                Elija una opción:""");
    }

    public static void ejecutarOpcion(int opcion, Conversion conversion, Scanner lectura) {
        switch (opcion) {
            case 1:
                convertirMoneda("MXN", "USD", conversion, lectura);
                break;
            case 2:
                convertirMoneda("USD", "MXN", conversion, lectura);
                break;
            case 3:
                convertirMoneda("BRL", "USD", conversion, lectura);
                break;
            case 4:
                convertirMoneda("USD", "BRL", conversion, lectura);
                break;
            case 5:
                convertirMoneda("EUR", "USD", conversion, lectura);
                break;
            case 6:
                convertirMoneda("USD", "EUR", conversion, lectura);
                break;
            case 7:
                elegirOtrasMonedas(conversion, lectura); // Llama al método para elegir otras monedas a convertir
                break;
            case 8:
                System.out.println("¡Gracias, hasta la proxima!");
                System.exit(0);
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
                break;
        }
    }

    // Método privado para realizar la conversión de moneda
    private static void convertirMoneda(String monedaBase, String monedaDestino, Conversion c, Scanner lectura) {
        System.out.println("Ingrese el monto a convertir:");
        double monto = lectura.nextDouble();
        int montoEntero = (int) monto;
        RegistroConversion registro = c.convertir(monedaBase, monedaDestino, montoEntero);
        mostrarResultado(registro, monedaBase, monedaDestino);
    }


    private static void elegirOtrasMonedas(Conversion conversion, Scanner lectura) {
        try {
            System.out.println("""
            Top 10 de monedas más importantes de America Latina:
        
             1.  COP: Colombia                  6.  BZD: Belize
             2.  KYD: Cayman Islands            7.  ARS: Argentina 
             3.  CAD: Canada                    8.  UYU: Uruguay  
             4.  GTQ: Guatemala                 9.  CLP: Chile
             5.  PEN: Peru                      10. PYG: Parguay 
            
            Para monedas no enlistadas utilizar el codigo a 3 letras de la moneda deseada.
                              
            Ingrese el código de moneda base:""");

            String monedaBase = lectura.next().toUpperCase(); // Código de moneda base ingresado por el usuario, LETRAS NO NUMEROS
            System.out.println("Ingrese el código de moneda destino: (I.E. MXN)");
            String monedaDestino = lectura.next().toUpperCase(); // Lee el código de moneda destino ingresado por el usuario
            convertirMoneda(monedaBase, monedaDestino, conversion, lectura); // Realiza la conversión
        } catch (Exception e) {
            System.out.println("Error: Ingrese un código de moneda válido.");
        }
    }

    // Método privado para mostrar el resultado de la conversión
    private static void mostrarResultado(RegistroConversion registro, String monedaBase, String monedaDestino) {
        if (registro != null) {
            Conversion conversion = registro.getConversion();
            if (conversion != null) {
                double monto = conversion.getMonto();
                double resultado = conversion.getResultado();
                double conversionRate = conversion.getConversionRate();

                // Redondear los valores para mostrar solo dos decimales
                monto = Math.round(monto * 10000.0) / 10000.0;
                resultado = Math.round(resultado * 10000.0) / 10000.0;
                conversionRate = Math.round(conversionRate * 10000.0) / 10000.0;

                System.out.println("************************************************************");
                System.out.println("Resultado de la conversión:");
                System.out.println("---------------------------------");
                System.out.println("Moneda base: " + conversion.getMonedaOrigen() + ": " + String.format("%.0f", monto));
                System.out.println("Moneda destino: " + conversion.getMonedaDestino() + ": " + String.format("%.2f", resultado));
                System.out.println("Monto: " + String.format("%.1f", monto));
                System.out.println("Tasa de conversión: " + String.format("%.5f", conversionRate));
                System.out.println("Resultado: " + String.format("%.2f", resultado));
                System.out.println("************************************************************");

            } else {
                System.out.println("Ha ocurrido un error al obtener la conversión.");
            }
        } else {
            System.out.println("Ha ocurrido un error al convertir la moneda.");
        }
    }
}
