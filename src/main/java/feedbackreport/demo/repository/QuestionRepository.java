package feedbackreport.demo.repository;

import feedbackreport.demo.model.Question;
import feedbackreport.demo.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository  extends JpaRepository<Question, Long> {

    @Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM UserDetails u WHERE u.username = :username AND u.password = :password AND u.usertype = :usertype) THEN true ELSE false END")
    boolean countByUsernameAndPasswordAndUserType(String username, String password, String usertype);


}