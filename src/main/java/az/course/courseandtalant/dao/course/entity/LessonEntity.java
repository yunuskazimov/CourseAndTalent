package az.course.courseandtalant.dao.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson")
@Entity
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String lessonInfo;
    private double lessonDurationHours;
    @OneToOne(mappedBy = "lesson")
    private CourseEntity course;
}
