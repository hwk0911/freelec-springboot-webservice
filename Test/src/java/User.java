public class User {
    private String name;
    private int age;

    @Required
    public void setName (String name) {
        this.name = name;
    }

    public void setAge (int age) {
        this.age = age;
    }
}
