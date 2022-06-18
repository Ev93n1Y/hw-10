import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
    public static String readFile(File file) {
        String string = "";
        try (FileReader reader = new FileReader(file)) {
            char[] buf = new char[256];
            while ((reader.read(buf)) > 0) {
                string = String.valueOf(buf);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return string;
    }
    public static void writeJsonFile(File file, ArrayList<User> arrayList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            // перевод строки в байты
            byte[] buffer = gson.toJson(arrayList).getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("File " + file + " successfully created.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
