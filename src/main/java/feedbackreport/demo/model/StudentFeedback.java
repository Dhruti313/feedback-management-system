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
@Table(name = "student_feedback")
public class StudentFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;
    @Column(name = "status")
    private int status;
    //@OneToOne
    //@JoinColumn(name = "course_id")
    @Column(name = "course_id")
    private int course_id;
    // @ManyToOne
    //@JoinColumn(name = "question_id")
    @Column(name = "question_id")
    private long question_id;

    @Column(name = "created_at")
    private long created_at;

}
