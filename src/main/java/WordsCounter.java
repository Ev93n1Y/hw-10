
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
Обратите внимание!
Вывод на консоль должен быть отсортирован на частоте слов (от наибольшей к наименьшей)
*/
public class WordsCounter{
    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter();
        wordsCounter.count("./src/main/java/Task3/words.txt");
    }

    public void count(String path) {
        Map<String, Long> cntMap;
        try {
            cntMap = Files.lines(Paths.get(path))
                    .flatMap(l -> Stream.of(l.split("\\W+")))
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            //cntMap.forEach((k, v) -> System.out.println(k + " " + v));
            // сортированный вывод по возрастанию
            cntMap.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
