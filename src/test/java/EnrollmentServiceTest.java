import model.Enrollment;
import org.junit.jupiter.api.Test;
import repository.EnrollmentRepository;
import service.EnrollmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnrollmentServiceTest {

    @Test
    void enrollsUserOncePerCourse() {
        EnrollmentService service = new EnrollmentService(new EnrollmentRepository());

        Enrollment first = service.enroll("user-1", 1);
        Enrollment second = service.enroll("user-1", 1);

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(first.getId(), second.getId());
        assertTrue(service.isEnrolled("user-1", 1));
        assertEquals(1, service.getEnrollmentsByUser("user-1").size());
    }
}
