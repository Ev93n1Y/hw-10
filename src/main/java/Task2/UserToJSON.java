package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Задание 2#
Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.
Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.
        Пример:
        Для файла file.txt со следующим содержанием:
        name age
        alice 21
        ryan 30
Новый файл должен иметь следующий вид:
        [
         {
            "name": "alice",
            "age":21
         },
         {
            "name": "ryan",
            "age":30
         }
        ]
*/
class UserToJSON {
    public static void main(String[] args) {
        UserToJSON userToJSON = new UserToJSON();
        ArrayList<User> users = new ArrayList<>();
        File file = new File("./src/main/java/Task2/file.txt");
        File userJson = new File("./src/main/java/Task2/user.json");
        ArrayList<String> usersInfo = userToJSON.findUsers(file);
        for (String s : usersInfo) {
            users.add(new User(s.split(" ")));
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String json = gson.toJson(users);
        try (FileOutputStream fos = new FileOutputStream(userJson)) {
            // перевод строки в байты
            byte[] buffer = gson.toJson(users).getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("File "+ userJson + " successfully created.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> findUsers(File file) {
        ArrayList<String> usersInfo = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            String string = "";
            char[] buf = new char[256];
            while ((reader.read(buf)) > 0) {
                string = String.valueOf(buf);
            }
            Matcher matcher = Pattern.compile(".{2,}\\s\\d{2}").matcher(string);
            while (matcher.find()) {
                usersInfo.add(matcher.group());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return usersInfo;
    }
}

class User {
    private String name;
    private Integer age;
    public User(String name, Integer age) {
    }

    public User(String[] str) {
        this(str[0], Integer.parseInt(str[1]));
    }
}