package feedbackreport.demo.controller;

import feedbackreport.demo.dto.QuestionRequest;
import feedbackreport.demo.model.Question;
import feedbackreport.demo.repository.CourseInfoRepository;
import feedbackreport.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    private  QuestionRepository questionRepository;
    @Autowired
    private CourseInfoRepository courseInfoRepository;
    @PostMapping("/questions")
    public ResponseEntity<String> insertQuestion(@RequestBody QuestionRequest requestBody ) {
        String[] question = requestBody.getQuestion();
        long startTime = requestBody.getStartTime();
        long endTime = requestBody.getEndTime();
        int courseId = requestBody.getCourseInfo();

        boolean courseInfo = courseInfoRepository.findByCourseId(courseId); // Retrieve the CourseInfo entity
        System.out.println(courseId);
        if (!courseInfo ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid course ID");
        }

        for (String questionText : question) {
            Question newQuestion = new Question();
            newQuestion.setQuestion(questionText);
            newQuestion.setStart_time(startTime);
            newQuestion.setEnd_time(endTime);
            newQuestion.setCourseInfo(courseId);
             questionRepository.save(newQuestion);
        }
        return ResponseEntity.ok("Questions inserted successfully");
    }


}
