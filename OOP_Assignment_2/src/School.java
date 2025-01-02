import java.util.ArrayList;
import java.util.Comparator;

public class School {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    // Constructor
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public ArrayList<Teacher> listTeachers() {
        return teachers;
    }

    public ArrayList<Student> filterStudentsByGrade(String grade) {
        ArrayList<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade().equals(grade)) {
                filtered.add(student);
            }
        }
        return filtered;
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "School(Name: " + name + ", Students: " + students.size() + ", Teachers: " + teachers.size() + ")";
    }
}
