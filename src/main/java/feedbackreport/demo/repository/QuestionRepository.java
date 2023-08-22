package feedbackreport.demo.repository;

import feedbackreport.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM UserDetails u WHERE u.username = :username AND u.password = :password AND u.usertype = :usertype) THEN true ELSE false END")
    boolean countByUsernameAndPasswordAndUserType(String username, String password, String usertype);

    @Query("SELECT AVG(sf.status) FROM StudentFeedback sf " +
            "WHERE sf.course_id = :courseId " +
            "AND sf.created_at BETWEEN :startTime AND :endTime")
    Double findAverageStatusByCourseAndTimeRange(int courseId, long startTime, long endTime);


}