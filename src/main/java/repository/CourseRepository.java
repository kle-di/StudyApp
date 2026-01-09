package repository;

import model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for courses.
 */
public class CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1, "Java Fundamentals", "Syntax, control flow, and classes."));
        courses.add(new Course(2, "World History", "Major eras and key turning points."));
        courses.add(new Course(3, "Data Structures", "Lists, trees, graphs, and complexity."));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}
