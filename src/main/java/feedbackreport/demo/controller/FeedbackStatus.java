package feedbackreport.demo.controller;

import feedbackreport.demo.dto.AverageStatusResponse;
import feedbackreport.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackStatus {
    @Autowired
    private QuestionRepository questionRepository;
    @GetMapping("/feedback-status")
    public ResponseEntity<AverageStatusResponse> feedbackStatus(
            @RequestParam int courseId,
            @RequestParam long startTime,
            @RequestParam long endTime) {

        Double averageStatus = questionRepository.findAverageStatusByCourseAndTimeRange(courseId, startTime, endTime);

        AverageStatusResponse response = new AverageStatusResponse();
        response.setAverageStatus(averageStatus);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}