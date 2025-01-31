import java.sql.*;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5433/School_Management_System";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1104";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");

            createTables(conn);
            insertData(conn);
            readData(conn);
            updateData(conn);
            deleteData(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        String schoolTable = "CREATE TABLE IF NOT EXISTS School (id SERIAL PRIMARY KEY, name VARCHAR(100), address VARCHAR(200));";
        String studentTable = "CREATE TABLE IF NOT EXISTS Student (id SERIAL PRIMARY KEY, name VARCHAR(100), age INT, school_id INT REFERENCES School(id));";
        String teacherTable = "CREATE TABLE IF NOT EXISTS Teacher (id SERIAL PRIMARY KEY, name VARCHAR(100), subject VARCHAR(100), school_id INT REFERENCES School(id));";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(schoolTable);
            stmt.executeUpdate(studentTable);
            stmt.executeUpdate(teacherTable);
            System.out.println("Tables created successfully!");
        }
    }

    private static void insertData(Connection conn) throws SQLException {
        String insertSchool = "INSERT INTO School (name, address) VALUES ('Нұр-Сұлтан №1 мектебі', 'Қабанбай батыр көшесі, 10');";
        String insertStudent = "INSERT INTO Student (name, age, school_id) VALUES ('Ерасыл Қайратұлы', 16, (SELECT id FROM School WHERE name='Нұр-Сұлтан №1 мектебі' LIMIT 1));";
        String insertTeacher = "INSERT INTO Teacher (name, subject, school_id) VALUES ('Санжар Бекмұратұлы', 'Математика', (SELECT id FROM School WHERE name='Нұр-Сұлтан №1 мектебі' LIMIT 1));";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(insertSchool);
            stmt.executeUpdate(insertStudent);
            stmt.executeUpdate(insertTeacher);
            System.out.println("Data inserted successfully!");
        }
    }

    private static void readData(Connection conn) throws SQLException {
        String query = "SELECT * FROM Student;";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Student: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", School ID: " + rs.getInt("school_id"));
            }
        }
    }

    private static void updateData(Connection conn) throws SQLException {
        String updateQuery = "UPDATE Student SET age = 17 WHERE name = 'Ерасыл Қайратұлы';";

        try (Statement stmt = conn.createStatement()) {
            int rowsUpdated = stmt.executeUpdate(updateQuery);
            System.out.println("Updated " + rowsUpdated + " records.");
        }
    }



    private static void deleteData(Connection conn) throws SQLException {
        String deleteStudents = "DELETE FROM Student;";
        String deleteTeachers = "DELETE FROM Teacher;";
        String deleteSchools = "DELETE FROM School;";

        try (Statement stmt = conn.createStatement()) {
            int studentsDeleted = stmt.executeUpdate(deleteStudents);
            int teachersDeleted = stmt.executeUpdate(deleteTeachers);
            int schoolsDeleted = stmt.executeUpdate(deleteSchools);
            System.out.println("Deleted " + studentsDeleted + " students, " + teachersDeleted + " teachers, and " + schoolsDeleted + " schools.");
        }

        System.out.println("All data removed successfully!");
    }
}
