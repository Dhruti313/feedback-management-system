package feedbackreport.demo.controller;

import feedbackreport.demo.model.Question;
import feedbackreport.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private  QuestionRepository questionRepository;

    @PostMapping("/questions")
    public ResponseEntity<String> insertQuestion(@RequestBody QuestionRequestBody requestBody ) {
        String[] question = requestBody.getQuestion();
        long startTime = requestBody.getStartTime();
        long endTime = requestBody.getEndTime();

        Question newQuestion = new Question();
        newQuestion.setQuestion(question);
        newQuestion.setStart_time(startTime);
        newQuestion.setEnd_time(endTime);
        Question insertQuestion=questionRepository.save(newQuestion);
        if (insertQuestion != null) {
            return ResponseEntity.ok("Question inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert question");
        }
    }
}
