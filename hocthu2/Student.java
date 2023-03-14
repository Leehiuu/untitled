package hocthu2;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double mark;

    public Student(int id, String name, int age, String gender, double mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

