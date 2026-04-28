import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio2 {

    // Texto declarado como constante
    private static final String TEXTO = 
            "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA\n" +
            "Facultad de Ingeniería - Boletín Informativo 2024-04-25\n" +
            "Actividades programadas:\n" +
            "Conferencia el 2024-05-01 a las 10:30 en el Edificio T3\n" +
            "Examen parcial el 2024-05-15 a las 08:00 en el Edificio S11\n" +
            "Defensa de proyecto el 2024-06-10 a las 14:30 en el Edificio T7\n" +
            "Contactos del departamento:\n" +
            "Coordinador: coord.ipc1@ingenieria.usac.edu.gt Tel: 2418-8000\n" +
            "Auxiliar 1: aux01_ipc1@ingenieria.usac.edu.gt Tel: 5555-1234\n" +
            "Auxiliar 2: aux02.ipc1@gmail.com Tel: 4321-9876";

    public static void main(String[] args) {
        System.out.println("--- Método 1: Extraer Fechas ---");
        extraerFechas();

        System.out.println("\n--- Método 2: Extraer Correos ---");
        extraerCorreos();

        System.out.println("\n--- Método 3: Censurar Datos ---");
        String pruebaCensura = "Llama a 5555-1234 o escribe a juan@usac.edu.gt para más info.";
        System.out.println("Entrada: " + pruebaCensura);
        System.out.println("Salida:  " + censurarDatos(pruebaCensura));
    }

    public static void extraerFechas() {
        // Uso de grupos de captura para separar Año (1), Mes (2) y Día (3)
        Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher matcher = pattern.matcher(TEXTO);

        while (matcher.find()) {
            System.out.println("Año: " + matcher.group(1) + 
                               " | Mes: " + matcher.group(2) + 
                               " | Día: " + matcher.group(3));
        }
    }

    public static void extraerCorreos() {
        // Patrón para capturar la estructura estándar de un correo electrónico
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(TEXTO);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static String censurarDatos(String entrada) {
        // 1. Reemplazar correos electrónicos
        Pattern patronCorreo = Pattern.compile("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcherCorreo = patronCorreo.matcher(entrada);
        String paso1 = matcherCorreo.replaceAll("[CORREO]"); // Reemplazo mediante Matcher

        // 2. Reemplazar teléfonos
        Pattern patronTelefono = Pattern.compile("\\d{4}-?\\d{4}");
        Matcher matcherTelefono = patronTelefono.matcher(paso1);
        String resultadoFinal = matcherTelefono.replaceAll("[TEL]"); // Reemplazo mediante Matcher

        return resultadoFinal;
    }
}