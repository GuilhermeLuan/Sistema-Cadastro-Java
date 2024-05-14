package entities;

import java.util.ArrayList;

public class Client {
    private String name;
    private String email;
    private int age;
    private String height;
    private ArrayList<String> newQuestionResponses = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String email, int age, String height) {
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
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
        sb.append(getName()).append(" ");
        sb.append(getEmail()).append(" ");
        sb.append(getAge()).append(" ");
        sb.append(getHeight()).append(" ");

        if(!newQuestionResponses.isEmpty()){
            for (String item : newQuestionResponses) {
                sb.append(item).append(" ");
            }
        }

        for(String response: newQuestionResponses){
            System.out.println(response);
        }

        return sb.toString();
    }
}
