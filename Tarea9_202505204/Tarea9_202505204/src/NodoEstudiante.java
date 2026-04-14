public class NodoEstudiante {
    
    String carnet;
    String nombre;
    double nota;
    NodoEstudiante next;

    public NodoEstudiante(String carnet, String nombre, double nota) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
        this.next = null;
    }

}
