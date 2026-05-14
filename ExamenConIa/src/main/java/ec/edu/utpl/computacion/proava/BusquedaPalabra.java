package ec.edu.utpl.computacion.proava;

public class BusquedaPalabra implements Runnable {

    private String[] fila;
    private String palabra;
    private int contador;

    // Constructor
    public BusquedaPalabra(
            String[] fila,
            String palabra
    ) {

        this.fila = fila;
        this.palabra = palabra;
        this.contador = 0;
    }

    // Getter para obtener el conteo parcial
    public int getContador() {
        return contador;
    }

    @Override
    public void run() {

        try {

            // Recorrer la fila
            for (String elemento : fila) {

                if (elemento.equalsIgnoreCase(palabra)) {
                    contador++;
                }
            }

            // Mostrar resultado del hilo
            System.out.println(
                    Thread.currentThread().getName()
                            + " finalizado. Encontrados: "
                            + contador
            );

        } catch (Exception e) {

            System.out.println(
                    "Error en "
                            + Thread.currentThread().getName()
                            + ": "
                            + e.getMessage()
            );
        }
    }
}