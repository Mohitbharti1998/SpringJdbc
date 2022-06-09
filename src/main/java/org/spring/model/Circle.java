package org.spring.model;

public class Circle {

    private int id;
    private String name;

    public Circle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circle(int circleId, String name){
        setId(circleId);
        setName(name);
    }
}