package feedbackreport.demo.controller;


import lombok.Data;

@Data
public class StudentFeedbackBody {

    private int course_id;
    private FeedbackResponse[] response;

}
