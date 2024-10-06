import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdministradorBuscadorArchivos {
    private final String[] files = {
            "src/Archivos_csv/game.csv",
            "src/Archivos_csv/game2.csv",
            "src/Archivos_csv/game3.csv",
            "src/Archivos_csv/game4.csv",
            "src/Archivos_csv/game5.csv"
    };

    public void iniciadorBusqueda() {
        Scanner scanner = new Scanner(System.in);
        String playId;
        
        System.out.print("Ingrese el valor de play_id a buscar: ");
        playId = "\"" + scanner.nextLine() + "\"";

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String file : files) {
            BuscadorArchivos fileSearcher = new BuscadorArchivos(file, playId);
            executor.execute(fileSearcher);
        }

        executor.shutdown();
    }
}
