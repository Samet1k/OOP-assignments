

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Ali", 14, "8th Grade");
        Student student2 = new Student("Murat", 15, "9th Grade");

        Teacher teacher1 = new Teacher("Aigul", "Math", 10);
        Teacher teacher2 = new Teacher("Marat", "English", 5);

        School school = new School("Daryn");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);

        System.out.println(school);
        System.out.println("\nStudents:");
        for (Student student : school.listStudents()) {
            System.out.println(student);
        }

        System.out.println("\nTeachers:");
        for (Teacher teacher : school.listTeachers()) {
            System.out.println(teacher);
        }

        System.out.println("\nFiltered Students (8th Grade):");
        for (Student student : school.filterStudentsByGrade("8th Grade")) {
            System.out.println(student);
        }

        school.sortStudentsByName();
        System.out.println("\nSorted Students:");
        for (Student student : school.listStudents()) {
            System.out.println(student);
        }

        Student searchResult = school.searchStudentByName("Murat");
        System.out.println("\nSearch Result:");
        System.out.println(searchResult != null ? searchResult : "Student not found.");

        System.out.println("\nComparison:");
        System.out.println("Is " + student1.getName() + " older than " + student2.getName() + "? " + (student1.getAge() > student2.getAge()));
    }
}
