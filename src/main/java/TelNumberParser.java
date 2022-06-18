import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Задание 1#
Дан текстовый файл file.txt, который содержит список номеров телефоном (один на линии).
Необъодимо написать метод, который будет считывать файл и выводить в консоль все валидные номера телефонов.
Предполагаем, что "валидный" номер телефона - это строка в одном из двух форматов:
(xxx) xxx-xxxx или xxx-xxx-xxxx (х обозначает цифру).
Для файла file.txt со следующим содержанием:
    987-123-4567
    123 456 7890
    (123) 456-7890
Метод должен вывести на экран
    987-123-4567
    (123) 456-7890
*/

public class TelNumberParser extends FileUtils{
    public static void main(String[] args) {
        TelNumberParser telNumberParser = new TelNumberParser();
        File file = new File("./src/main/java/Task1/file.txt");
        telNumberParser.printMatchNumbers(readFile(file));
    }
    public void printMatchNumbers(String tetx){
        Matcher matcher = Pattern.compile("\\(?\\d{3}\\)?[-\\s]\\d{3}-\\d{4}").matcher(tetx);
        while (matcher.find()) {
            System.out.println("\n" + matcher.group());
        }
    }
}