import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Задание 3#
Напишите метод, который будет подсчитывать частоту каждого слова в файле words.txt.
Предполагаем, что:
    words.txt содержит только слова в нижнем регистре, разделенные пробелом
    Каждое слово содержит только символы-буквы в нижнем регистре.
    Слова разделены одим или несколькими пробелами, либо переносом строки.
Пример:
Для файла words.txt со следующим содержанием:
        the day is sunny the the
        the sunny is is
Метод должен вернуть частоту:
        the 4
        is 3
        sunny 2
        day 1
Обратите внимание! Вывод на консоль должен быть отсортирован на частоте слов (от наибольшей к наименьшей)
*/
public class WordsCounter extends FileUtils {
    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter();
        File words = new File("./src/main/java/Task3/words.txt");
        System.out.println(words);
        System.out.println(readFile(words));
    }

    public void count(String text) {
        Matcher matcher = Pattern.compile("\\(?\\d{3}\\)?[-\\s]\\d{3}-\\d{4}").matcher(text);
        while (matcher.find()) {
            System.out.println("\n" + matcher.group());
        }
    }
}
