package School_class;

public class Student {

    private String name;
    private int age;
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void nextYear(Student st1, Courses c1){
        c1.nextSubject(st1);
    }

}
