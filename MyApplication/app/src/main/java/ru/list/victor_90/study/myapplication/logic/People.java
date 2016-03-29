package ru.list.victor_90.study.myapplication.logic;


// Класс для объектов поля people
public class People {

    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean isDegree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setIsDegree(boolean isDegree) {
        this.isDegree = isDegree;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nsurname: " + surname + "\nage: " + age + "\nisDegree: " + isDegree + "\n";
    }
}
