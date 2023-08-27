package feedbackreport.demo.repository;

import feedbackreport.demo.dto.QuestionDetails;
import feedbackreport.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM UserDetails u WHERE u.username = :username AND u.password = :password AND u.usertype = :usertype) THEN true ELSE false END")
    boolean countByUsernameAndPasswordAndUserType(String username, String password, String usertype);

    @Query("SELECT AVG(sf.status) FROM StudentFeedback sf " +
            "WHERE sf.course_id = :courseId " +
            "AND sf.created_at >= :startTime AND sf.created_at<=:endTime")
    Double findAverageStatusByCourseAndTimeRange(int courseId, long startTime, long endTime);

    @Query("SELECT q.question_id, q.question " +
            "FROM Question q " +
            "WHERE q.start_time <= :currentTimestamp " +
            "AND q.end_time >= :currentTimestamp " +
            "AND q.courseInfo = :courseId")
    List<Object[]> findQuestionsWithinCurrentTimestampAndCourseId(
            long currentTimestamp, int courseId);
}
