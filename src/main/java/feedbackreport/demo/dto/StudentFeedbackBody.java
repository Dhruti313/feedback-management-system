package feedbackreport.demo.dto;


import lombok.Data;

@Data
public class StudentFeedbackBody {

    private int course_id;
    private FeedbackResponse[] response;

}
