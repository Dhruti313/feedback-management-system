package feedbackreport.demo.dto;

import lombok.Data;

@Data
public class QuestionDetails {
    private long question_id;
    private String question;

    public QuestionDetails(long question_id, String question) {
        this.question_id = question_id;
        this.question = question;
    }
}
