package feedbackreport.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import feedbackreport.demo.dto.QuestionDetails;
import feedbackreport.demo.dto.QuestionRequest;
import feedbackreport.demo.model.Question;
import feedbackreport.demo.repository.CourseInfoRepository;
import feedbackreport.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CourseInfoRepository courseInfoRepository;

    @PostMapping("/questions")
    public ResponseEntity<ObjectNode> insertQuestion(@RequestBody QuestionRequest requestBody) {
        String[] question = requestBody.getQuestion();
        long startTime = requestBody.getStartTime();
        long endTime = requestBody.getEndTime();
        int courseId = requestBody.getCourseInfo();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();
        boolean courseInfo = courseInfoRepository.findByCourseId(courseId); // Retrieve the CourseInfo entity

        if (!courseInfo) {
            responseNode.put("status", "error");
            responseNode.put("message", "Invalid course ID");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseNode);
        }

        for (String questionText : question) {
            Question newQuestion = new Question();
            newQuestion.setQuestion(questionText);
            newQuestion.setStart_time(startTime);
            newQuestion.setEnd_time(endTime);
            newQuestion.setCourseInfo(courseId);
            questionRepository.save(newQuestion);
        }

        responseNode.put("status", "success");
        responseNode.put("message", "Questions inserted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(responseNode);
    }


    @GetMapping("/getquestions")
    public ResponseEntity<List<Map<String, Object>>> getQuestions(@RequestParam int course_id) {

        List<Object[]> questionExists = questionRepository.findQuestionsWithinCurrentTimestampAndCourseId(System.currentTimeMillis(), course_id);

        List<Map<String, Object>> responseList = new ArrayList<>();
        for (Object[] result : questionExists) {
            Map<String, Object> questionMap = new HashMap<>();
            questionMap.put("question_id", result[0]);
            questionMap.put("question", result[1]);
            responseList.add(questionMap);
        }

        return ResponseEntity.ok(responseList);
    }
}