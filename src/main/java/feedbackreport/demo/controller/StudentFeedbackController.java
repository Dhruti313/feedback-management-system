package feedbackreport.demo.controller;

import feedbackreport.demo.model.CourseInfo;
import feedbackreport.demo.model.StudentFeedback;
import feedbackreport.demo.repository.CourseInfoRepository;
import feedbackreport.demo.repository.StudentFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentFeedbackController {

    @Autowired
    private StudentFeedbackRepository studentFeedbackRepository;

    @Autowired
    private CourseInfoRepository courseInfoRepository;

    @PostMapping("/student_feedback")
    public ResponseEntity<String> studentFeedback(@RequestBody StudentFeedbackBody studentFeedbackBody) {
        int courseId = studentFeedbackBody.getCourse_id();
        FeedbackResponse[] responses = studentFeedbackBody.getResponse();



        // Process each response and create corresponding StudentFeedback entities
        for (FeedbackResponse response : responses) {
            StudentFeedback studentFeedback = new StudentFeedback();
            studentFeedback.setCourse_id(courseId);
            studentFeedback.setQuestion_id(response.getQuestion_id());
            studentFeedback.setStatus(response.getStatus());
            // Save the feedback
            studentFeedbackRepository.save(studentFeedback);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Feedback submitted successfully");
    }
}
