package feedbackreport.demo.controller;

import feedbackreport.demo.model.CourseInfo;
import lombok.Data;

@Data
public class QuestionRequestBody {
    private String[] question;
    private long startTime;
    private long endTime;
    private int courseInfo;
}
