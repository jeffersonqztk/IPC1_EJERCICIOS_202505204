public class ListaDobleEstudiantes {
    
    NodoEstudianteDoble head; // referencia al primer nodo
    NodoEstudianteDoble tail; // referencia al último nodo

    public ListaDobleEstudiantes() {
        this.head = null; // lista inicia vacía
        this.tail = null; // lista inicia vacía
    }

    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota); // crea nodo
        if (head == null) { // si la lista está vacía
            head = nuevo; // nuevo es el primero
            tail = nuevo; // nuevo también es el último
        } else {
            nuevo.next = head; // enlaza con el primero actual
            head.prev = nuevo; // el primero actual apunta al nuevo
            head = nuevo; // actualiza el inicio
        }
    }

    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota); // crea nodo
        if (head == null) { // si la lista está vacía
            head = nuevo; // nuevo es el primero
            tail = nuevo; // nuevo también es el último
        } else {
            tail.next = nuevo; // el último apunta al nuevo
            nuevo.prev = tail; // el nuevo apunta al anterior
            tail = nuevo; // actualiza el final
        }
    }

    public void eliminarPorCarnet(String carnet) {
        if (head == null) { // lista vacía
            return;
        }

        NodoEstudianteDoble aux = head; // inicia búsqueda
        while (aux != null && !aux.carnet.equals(carnet)) {
            aux = aux.next; // avanza hasta encontrar el carnet
        }

        if (aux == null) { // no se encontró
            return;
        }

        if (aux == head) { // si elimina el primero
            head = aux.next; // mueve el inicio
            if (head != null) {
                head.prev = null; // el nuevo primero no tiene anterior
            } else {
                tail = null; // si quedó vacía también se limpia tail
            }
        } else if (aux == tail) { // si elimina el último
            tail = aux.prev; // mueve el final
            tail.next = null; // el nuevo último no tiene siguiente
        } else {
            aux.prev.next = aux.next; // conecta con el siguiente
            aux.next.prev = aux.prev; // conecta con el anterior
        }
    }

    public void imprimirAdelante() {
        NodoEstudianteDoble aux = head; // inicia desde el primero
        while (aux != null) {
            System.out.println(aux.carnet + " - " + aux.nombre + " - " + aux.nota); // muestra datos
            aux = aux.next; // avanza hacia adelante
        }
    }

    public void imprimirAtras() {
        NodoEstudianteDoble aux = tail; // inicia desde el último
        while (aux != null) {
            System.out.println(aux.carnet + " - " + aux.nombre + " - " + aux.nota); // muestra datos
            aux = aux.prev; // avanza hacia atrás
        }
    }

    public void insertarOrdenado(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota); // crea nodo

        if (head == null) { // si la lista está vacía
            head = nuevo;
            tail = nuevo;
            return;
        }

        if (nota <= head.nota) { // si va al inicio
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
            return;
        }

        NodoEstudianteDoble aux = head; // recorre la lista
        while (aux.next != null && aux.next.nota < nota) {
            aux = aux.next; // busca la posición correcta
        }

        if (aux.next == null) { // si va al final
            aux.next = nuevo;
            nuevo.prev = aux;
            tail = nuevo;
        } else {
            nuevo.next = aux.next; // enlaza con el siguiente
            nuevo.prev = aux; // enlaza con el anterior
            aux.next.prev = nuevo; // el siguiente apunta al nuevo
            aux.next = nuevo; // el anterior apunta al nuevo
        }
    }

}
