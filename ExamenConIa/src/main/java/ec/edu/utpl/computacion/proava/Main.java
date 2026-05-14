package ec.edu.utpl.computacion.proava;

public class Main {

    public static void main(String[] args) {

        try {

            // Matriz de prueba
            String[][] matriz = {
                    {"Java", "Python", "Java"},
                    {"C++", "Java", "Go"},
                    {"Java", "Rust", "Java"}
            };

            // Palabra a buscar
            String palabraBuscada = "Java";

            // Mensaje inicial
            System.out.println(
                    "Iniciando búsqueda concurrente del término: \""
                            + palabraBuscada + "\""
            );

            // Arreglos para hilos y tareas
            Thread[] hilos = new Thread[matriz.length];
            BusquedaPalabra[] tareas = new BusquedaPalabra[matriz.length];

            // Crear y ejecutar hilos
            for (int i = 0; i < matriz.length; i++) {

                tareas[i] = new BusquedaPalabra(
                        matriz[i],
                        palabraBuscada
                );

                hilos[i] = new Thread(
                        tareas[i],
                        "Hilo-" + i
                );

                hilos[i].start();
            }

            // Esperar a que todos los hilos terminen
            for (Thread hilo : hilos) {
                hilo.join();
            }

            // Sumar resultados parciales
            int total = 0;

            for (BusquedaPalabra tarea : tareas) {
                total += tarea.getContador();
            }

            // Resultado final
            System.out.println("----------------------------------------------");

            System.out.println(
                    "Resultado Total: La palabra \""
                            + palabraBuscada
                            + "\" aparece "
                            + total
                            + " veces."
            );

        } catch (InterruptedException e) {

            System.out.println(
                    "Error de sincronización: "
                            + e.getMessage()
            );
        }
    }
}