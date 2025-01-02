public class Teacher {
    private String name;
    private String subject;
    private int yearsExperience;

    public Teacher(String name, String subject, int yearsExperience) {
        this.name = name;
        this.subject = subject;
        this.yearsExperience = yearsExperience;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String toString() {
        return "Teacher(Name: " + name + ", Subject: " + subject + ", Years Experience: " + yearsExperience + ")";
    }
}
