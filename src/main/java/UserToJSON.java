import java.io.File;
import java.util.ArrayList;

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
class UserToJSON extends FileUtils {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        File file = new File("./src/main/java/Task2/file.txt");
        File userJson = new File("./src/main/java/Task2/user.json");
        ArrayList<String> usersInfo = User.findUsers(readFile(file));
        for (String s : usersInfo) {
            users.add(new User(s.split(" ")));
        }
        writeJsonFile(userJson, users);
    }
}

