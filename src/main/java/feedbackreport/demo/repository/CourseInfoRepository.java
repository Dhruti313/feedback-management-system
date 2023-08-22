package feedbackreport.demo.repository;

import feedbackreport.demo.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo , Integer> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CourseInfo c WHERE c.course_id = :courseId")
    boolean  findByCourseId(int courseId);
}
