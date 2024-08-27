package School_class;

public class Control {

    public static void main(String[] args) {

        Student st1 = new Student();
        st1.setName("John");
        st1.setAge(18);
        st1.setStatus(false);

        Courses c1 = new Courses();

        st1.nextYear(st1, c1);

    }
}
