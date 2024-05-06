package task1.task2;

import java.util.HashSet;
import java.util.Set;

/**
 * .
 *
 * @belongsProject: myTak
 * @belongsPackage: task1.task2
 * @author: ZGY
 * @createTime: 2024-03-25  21:49
 * @version: 1.0
 */

public class Student {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

    private String name;

    private int Id;

    private Set<String> courses = new HashSet<>();




}