public class ListaEstudiantes {
    
    NodoEstudiante head; // referencia al primer nodo

    public ListaEstudiantes() {
        this.head = null; // lista inicia vacía
    }

    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota); // crea nodo
        if (head == null) { // si no hay elementos
            head = nuevo; // se vuelve el primero
        } else {
            nuevo.next = head; // apunta al actual primero
            head = nuevo; // se actualiza el inicio
        }
    }

    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota); // crea nodo
        if (head == null) { // lista vacía
            head = nuevo; // se vuelve el primero
        } else {
            NodoEstudiante aux = head; // recorre la lista
            while (aux.next != null) { // hasta el último nodo
                aux = aux.next;
            }
            aux.next = nuevo; // lo enlaza al final
        }
    }

    public void eliminarPorCarnet(String carnet) {
        if (head == null) { // lista vacía
            return;
        }
        if (head.carnet.equals(carnet)) { // si es el primero
            head = head.next; // se elimina moviendo head
            return;
        }
        NodoEstudiante aux = head; // recorre la lista
        while (aux.next != null && !aux.next.carnet.equals(carnet)) {
            aux = aux.next; // busca el nodo anterior
        }
        if (aux.next != null) { // si lo encontró
            aux.next = aux.next.next; // elimina el nodo
        }
    }

    public NodoEstudiante buscarPorCarnet(String carnet) {
        NodoEstudiante aux = head; // inicia recorrido
        while (aux != null) {
            if (aux.carnet.equals(carnet)) { // si coincide
                return aux; // retorna el nodo
            }
            aux = aux.next; // avanza
        }
        return null; // no existe
    }

    public void imprimirLista() {
        NodoEstudiante aux = head; // recorre desde el inicio
        while (aux != null) {
            System.out.println(aux.carnet + " - " + aux.nombre + " - " + aux.nota); // muestra datos
            aux = aux.next; // avanza
        }
    }

    public double obtenerPromedio() {
        if (head == null) { // lista vacía
            return 0.0;
        }
        double suma = 0.0; // acumula notas
        int contador = 0; // cuenta nodos
        NodoEstudiante aux = head; // recorre lista
        while (aux != null) {
            suma += aux.nota; // suma nota
            contador++; // incrementa contador
            aux = aux.next; // avanza
        }
        return suma / contador; // calcula promedio
    }

    public NodoEstudiante obtenerMejorNota() {
        if (head == null) { // lista vacía
            return null;
        }
        NodoEstudiante mejor = head; // toma el primero
        NodoEstudiante aux = head.next; // empieza desde el segundo
        while (aux != null) {
            if (aux.nota > mejor.nota) { // compara notas
                mejor = aux; // actualiza mejor
            }
            aux = aux.next; // avanza
        }
        return mejor; // retorna mejor estudiante
    }

}
