package School_class;

public class Courses {

    private String nameCourse;
    private int hours;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void nextSubject(Student st1){
        if (st1.getStatus())
        {
            if (st1.getAge() >= 6 && st1.getAge() <= 15)
            {
                System.out.println("Welcome to Math course, " + st1.getName());
            } else if (st1.getAge() >= 16 && st1.getAge() <= 21)
            {
                System.out.println("Welcome to Calculus course, " + st1.getName());
            } else
            {
                System.out.println("You are not allowed to take any course, " + st1.getName());
            }
        }
        else {
            System.out.println("You need to check your status first, " + st1.getName());
        }
    }

}
