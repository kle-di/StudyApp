package controller;

import model.Course;
import service.CourseService;

import java.util.List;

/**
 * Controller for course actions.
 */
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<Course> listCourses() {
        return courseService.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseService.getCourseById(id);
    }
}
