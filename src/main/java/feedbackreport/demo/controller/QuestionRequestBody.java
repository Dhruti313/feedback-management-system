package feedbackreport.demo.controller;

import lombok.Data;

@Data
public class QuestionRequestBody {
    private String[] question;
    private long startTime;
    private long endTime;
}
