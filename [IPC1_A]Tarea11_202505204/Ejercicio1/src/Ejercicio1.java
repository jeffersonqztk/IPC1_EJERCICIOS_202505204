import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio1 {

    public static void main(String[] args) {
        // Pruebas Método 1 - Carnet universitario
        System.out.println("--- Pruebas Carnet ---");
        System.out.println("202300123: " + (validarCarnet("202300123") ? "Válido" : "Inválido"));
        System.out.println("202512345: " + (validarCarnet("202512345") ? "Válido" : "Inválido"));
        System.out.println("20230012: " + (validarCarnet("20230012") ? "Válido" : "Inválido"));
        System.out.println("2023ABC12: " + (validarCarnet("2023ABC12") ? "Válido" : "Inválido"));

        // Pruebas Método 2 - Correo institucional USAC
        System.out.println("\n--- Pruebas Correo ---");
        System.out.println("juan.perez@usac.edu.gt: " + (validarCorreo("juan.perez@usac.edu.gt") ? "Válido" : "Inválido"));
        System.out.println("carla_001@usac.edu.gt: " + (validarCorreo("carla_001@usac.edu.gt") ? "Válido" : "Inválido"));
        System.out.println("juan@gmail.com: " + (validarCorreo("juan@gmail.com") ? "Válido" : "Inválido"));
        System.out.println(".juan@usac.edu.gt: " + (validarCorreo(".juan@usac.edu.gt") ? "Válido" : "Inválido"));

        // Pruebas Método 3 - Teléfono 
        System.out.println("\n--- Pruebas Teléfono ---");
        System.out.println("5555-1234: " + (validarTelefono("5555-1234") ? "Válido" : "Inválido"));
        System.out.println("30001234: " + (validarTelefono("30001234") ? "Válido" : "Inválido"));
        System.out.println("1234-5678: " + (validarTelefono("1234-5678") ? "Válido" : "Inválido"));
        System.out.println("555-1234: " + (validarTelefono("555-1234") ? "Válido" : "Inválido"));
    }

    public static boolean validarCarnet(String carnet) {
        // El patrón exige exactamente 9 dígitos, año y correlativo.
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(carnet);
        return matcher.matches();
    }

    public static boolean validarCorreo(String correo) {
        // Obliga a iniciar con alfanumérico, permite caracteres válidos en medio y exige terminar en @usac.edu.gt
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9._]*@usac\\.edu\\.gt$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean validarTelefono(String telefono) {
        // Inicia con 3, 4, 5 o 6, seguido de 3 dígitos, un guión opcional y 4 dígitos finales.
        Pattern pattern = Pattern.compile("^[3456]\\d{3}-?\\d{4}$");
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }
}