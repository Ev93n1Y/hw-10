import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String[] str) {
        this(str[0], Integer.parseInt(str[1]));
    }

    public static ArrayList<String> findUsers(String text) {
        ArrayList<String> usersInfo = new ArrayList<>();
        Matcher matcher = Pattern.compile(".{2,}\\s\\d{2}").matcher(text);
        while (matcher.find()) {
            usersInfo.add(matcher.group());
        }
        return usersInfo;
    }
}