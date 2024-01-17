package pkgProject;

import java.util.ArrayList;

public class Student {
    private int studentNumber;
    private String nameSurname;
    private ArrayList<String> phoneNumber = new ArrayList<>();

    public Student() {
        studentNumber = 0;
        nameSurname = null;
        phoneNumber = null;
    }

    /**
     *
     * @param studentNumber
     * @param nameSurname
     * @param phoneNumber
     */
    public Student(int studentNumber, String nameSurname, ArrayList<String> phoneNumber) {
        this.studentNumber = studentNumber;
        this.nameSurname = nameSurname;
        this.phoneNumber = new ArrayList<>(phoneNumber);
    }

    public Student(Student c) {
        this.studentNumber = c.studentNumber;
        this.nameSurname = c.nameSurname;
        this.phoneNumber = c.phoneNumber; // PrivacyLeak acisindan yanlis kullanim
    }

    /**
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return the nameSurname
     */
    public String getNameSurname() {
        return nameSurname;
    }

    /**
     * @param nameSurname the nameSurname to set
     */
    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    /**
     * @return the phoneNumber
     */
    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(ArrayList<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Name Surname: %s \nStudent Number: %d\nPhone Number: %s", nameSurname, studentNumber,
                phoneNumber);
    }
}
