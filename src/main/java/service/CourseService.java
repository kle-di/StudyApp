package service;

import model.Course;
import repository.CourseRepository;

import java.util.List;

/**
 * Course operations over the repository.
 */
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }
}
