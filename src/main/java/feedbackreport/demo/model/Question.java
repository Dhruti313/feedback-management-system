package feedbackreport.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long question_id;

    @Column(name = "question")
    private String question;
    @Column(name = "start_time")
    private long start_time;
    @Column(name = "end_time")
    private long end_time;
    @Column(name = "course_id")
    private int courseInfo;


}
