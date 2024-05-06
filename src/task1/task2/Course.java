package task1.task2;

import java.util.HashSet;
import java.util.Set;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.task2
 * @author: ZGY
 * @createTime: 2024-03-25  21:55
 * @version: 1.0
 */

public class Course {
    private int courseId;

    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    private Set<Student> students = new HashSet<>();
}