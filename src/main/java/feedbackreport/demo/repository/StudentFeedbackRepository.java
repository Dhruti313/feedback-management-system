package feedbackreport.demo.repository;

import feedbackreport.demo.model.StudentFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeedbackRepository extends JpaRepository<StudentFeedback, Integer> {
    @Query(value = "SELECT course_id, course_name FROM course_info", nativeQuery = true)
    List<StudentFeedback> student_feedback_details();
}
