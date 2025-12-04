package student;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Student {
    private String studentId;
    private String fullName;
    private List<Double> grades;
	
    public Student(String fullName, String studentId, List<Double> grades) {
	    this.studentId = studentId.trim();
	    this.fullName = fullName.trim();
	    this.grades = grades;

	}
    
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public int getSubjectCount() {
        return grades.size();
    }

    public double computeAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    public boolean isPassed(double passingMark) {
        return computeAverage() >= passingMark && !grades.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name : ").append(fullName).append("\n");
        sb.append("Student ID   : ").append(studentId).append("\n");
        if (grades.isEmpty()) {
            sb.append("Grades       : (no grades entered)\n");
            sb.append("Average      : N/A\n");
            sb.append("Status       : N/A\n");
        } 
        return sb.toString();
    }

}
