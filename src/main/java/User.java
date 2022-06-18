public class User {
    private static String name;
    private static Integer age;

    public User(String name, Integer age) {
    }

    public User(String[] str) {
        this(str[0], Integer.parseInt(str[1]));
    }

    @Override
    public String toString() {
        return "" + name + " " + age;
    }
}