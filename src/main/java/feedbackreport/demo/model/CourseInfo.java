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
@Table(name = "course_info")
public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    //    @ManyToOne
    // @JoinColumn(name = "user_id") // This establishes the foreign key relationship
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "course_name")
    private String course_name;
}

