public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Grade: " + student.getGrade());
    }
}