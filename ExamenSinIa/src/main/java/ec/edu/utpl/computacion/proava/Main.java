package ec.edu.utpl.computacion.proava;

public class Main {

    public static void main(String[] args) {

        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        String palabraBuscada = "Java";

        System.out.println("Buscando la palabra: " + palabraBuscada);

        Thread[] hilos = new Thread[matriz.length];
        BusquedaPalabra[] tareas = new BusquedaPalabra[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            tareas[i] = new BusquedaPalabra(matriz[i], palabraBuscada, i);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar un hilo");
            }
        }

        int total = 0;
        for (BusquedaPalabra tarea : tareas) {
            total += tarea.getContador();
        }
        System.out.println("--------------------------------");
        System.out.println("Total encontrado: " + total);
    }
}