package seedu.address.model.student;

import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.Set;

public class Student extends Person {

    private StudentID studentID;

    public Student(Name name, StudentID studentID, Phone phone, Email email, Set<Tag> tags, Remark remark) {
        super(name, phone, email, tags, remark);
        this.studentID = studentID;
    }

    public StudentID getStudentID() {
        return studentID;
    }

    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getName().equals(getName())
                && otherStudent.getStudentID().equals(getStudentID())
                && (otherStudent.getPhone().equals(getPhone()) || otherStudent.getEmail().equals(getEmail()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getPhone().equals(getPhone())
                && otherStudent.getEmail().equals(getEmail())
                && otherStudent.getStudentID().equals(getStudentID());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Student ID: ")
                .append(getStudentID())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Tags: ")
                .append(" Remarks ")
                .append(getRemark());
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
