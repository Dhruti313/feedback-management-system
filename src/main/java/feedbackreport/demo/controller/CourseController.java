package feedbackreport.demo.controller;

import feedbackreport.demo.repository.CourseDetails;
import feedbackreport.demo.repository.CourseInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CourseController {
    @Autowired
    private CourseInfoRepository courseInfoRepository;
    @GetMapping("/course-details")
    public List<CourseDetails> getAllCOurse(){
        return courseInfoRepository.findCourseDetail();
    }

}
