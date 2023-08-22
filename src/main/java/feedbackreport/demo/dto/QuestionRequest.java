package feedbackreport.demo.dto;

import lombok.Data;

@Data
public class QuestionRequest {
    private String[] question;
    private long startTime;
    private long endTime;
    private int courseInfo;
}
