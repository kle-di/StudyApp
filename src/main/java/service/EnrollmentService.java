package service;

import model.Enrollment;
import repository.EnrollmentRepository;

import java.util.List;

/**
 * Enrollment operations over the repository.
 */
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enroll(String userId, int courseId) {
        return enrollmentRepository.enroll(userId, courseId);
    }

    public boolean isEnrolled(String userId, int courseId) {
        return enrollmentRepository.isEnrolled(userId, courseId);
    }

    public List<Enrollment> getEnrollmentsByUser(String userId) {
        return enrollmentRepository.findByUserId(userId);
    }
}
