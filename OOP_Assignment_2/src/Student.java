class Student extends Person {
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        super(name);
        this.age = age;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Age: " + age + ", Grade: " + grade;
    }
}
