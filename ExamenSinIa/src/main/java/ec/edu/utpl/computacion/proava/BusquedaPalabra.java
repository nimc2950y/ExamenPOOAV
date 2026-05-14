package ec.edu.utpl.computacion.proava;

public class BusquedaPalabra implements Runnable {
    public String[] fila;
    public String palabra;
    public int numeroFila;
    public int contador;

    public BusquedaPalabra(String[] fila, String palabra, int numeroFila) {
        this.fila = fila;
        this.palabra = palabra;
        this.numeroFila = numeroFila;
        this.contador = 0;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try {
            for (String texto : fila) {

                if (texto.equalsIgnoreCase(palabra)) {
                    contador++;
                }
            }
            System.out.println(
                    "Hilo fila " + numeroFila +
                            " terminó. Encontrados: " + contador
            );
        } catch (Exception e) {
            System.out.println(
                    "Error en la fila " + numeroFila
            );
        }
    }
}

