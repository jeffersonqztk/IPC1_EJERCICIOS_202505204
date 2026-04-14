public class NodoEstudianteDoble {
    
    String carnet;
    String nombre;
    double nota;
    NodoEstudianteDoble next;
    NodoEstudianteDoble prev;

    public NodoEstudianteDoble(String carnet, String nombre, double nota) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
        this.next = null;
        this.prev = null;
    }

}
