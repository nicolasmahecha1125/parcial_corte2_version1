import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivoCsv {
    public String[] buscadorArchivos(String fileName, String playId) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;


            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                if (row[0].equals(playId)) {
                    return row;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
