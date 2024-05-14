package entities;

import java.util.ArrayList;

public class Client {
    private String name;
    private String email;
    private int age;
    private float height;
    private ArrayList<String> newQuestionResponses = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String email, int age, float height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }


    public String  getName() {
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

    public void addResponse(String response){
        newQuestionResponses.add(response);
    }

    public static ArrayList<Client> searchClient(ArrayList<Client> clients, String search){
        ArrayList<Client> resultList = new ArrayList<>();

        for (Client c: clients) {
            if(c.getName().contains(search) || c.getEmail().contains(search)){
                resultList.add(c);
            }
        }

        return resultList;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        sb.append(email).append(" ");
        sb.append(age).append(" ");
        sb.append(height).append(" ");

        if(!newQuestionResponses.isEmpty()){
            for (String item : newQuestionResponses) {
                sb.append(item).append(" ");
            }
        }


        return sb.toString();
    }
}
