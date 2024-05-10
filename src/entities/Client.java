package entities;

public class Client {
    private String name;
    private String email;
    private int age;
    private float height;

    public Client() {
    }

    public Client(String name, String email, int age, float height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getHeight();
    }
}
