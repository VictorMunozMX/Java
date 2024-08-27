package CourseJava02;

public class Main {

    public static void main(String[] args) {

        GradingSystem gradingSystem = new GradingSystem();
        int percentage = 35;

        System.out.println("Percentage: " + percentage);
        System.out.println("Pass: " + gradingSystem.isPass(percentage));
        System.out.println("Grade: " + gradingSystem.getGrade(percentage));
        System.out.println(gradingSystem.retakeMessage(percentage, true));
    }
}
