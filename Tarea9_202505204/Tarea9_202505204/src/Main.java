public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA LISTA SIMPLE ---");
        ListaEstudiantes listaSimple = new ListaEstudiantes();
        listaSimple.agregarInicio("202300001", "Ana", 85.0);
        listaSimple.agregarInicio("202300002", "Luis", 90.0);
        listaSimple.agregarFinal("202300003", "Maria", 78.0);
        
        listaSimple.imprimirLista();
        System.out.println("Promedio: " + listaSimple.obtenerPromedio());
        
        System.out.println("\n--- PRUEBA LISTA DOBLE ---");
        ListaDobleEstudiantes listaDoble = new ListaDobleEstudiantes();
        listaDoble.insertarOrdenado("202300001", "Ana", 85.0);
        listaDoble.insertarOrdenado("202300002", "Luis", 90.0);
        listaDoble.insertarOrdenado("202300003", "Maria", 78.0);
        
        listaDoble.imprimirAdelante();
    }
}