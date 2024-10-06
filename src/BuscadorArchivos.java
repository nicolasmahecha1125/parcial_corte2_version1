import java.io.IOException;

public class BuscadorArchivos implements Runnable{
    private final String fileName;
    private final String playId;

    public BuscadorArchivos(String fileName, String playId) {
        this.fileName = fileName;
        this.playId = playId;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String threadName = Thread.currentThread().getName();

        System.out.println("Hilo " + threadName + " está buscando en el archivo: " + fileName);

        try {
            LectorArchivoCsv csvarchivolector = new LectorArchivoCsv();
            String[] result = csvarchivolector.buscadorArchivos(fileName, playId);

            if (result != null) {
                System.out.println("Hilo " + threadName + ": Encontrado en archivo: " + fileName);
                System.out.println("Información completa: " + String.join(", ", result) + " hilo: " + threadName + " archivo: " + fileName);
            } else {
                System.out.println("Hilo " + threadName + ": play_id " + playId + " no encontrado en el archivo: " + fileName);
            }
        } catch (IOException e) {
            System.out.println("Hilo " + threadName + ": Error al leer el archivo " + fileName);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Hilo " + threadName + ": Tiempo de ejecución del hilo para el archivo " + fileName + ": " + duration + " ms");
    }
}
