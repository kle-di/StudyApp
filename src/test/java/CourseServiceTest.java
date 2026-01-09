import model.Course;
import org.junit.jupiter.api.Test;
import repository.CourseRepository;
import service.CourseService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServiceTest {

    @Test
    void returnsCoursesAndLookupById() {
        CourseService service = new CourseService(new CourseRepository());

        List<Course> courses = service.getAllCourses();

        assertEquals(3, courses.size());
        assertEquals("Java Fundamentals", service.getCourseById(1).getTitle());
        assertNull(service.getCourseById(999));
    }
}
