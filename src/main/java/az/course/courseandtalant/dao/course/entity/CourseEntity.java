package az.course.courseandtalant.dao.course.entity;

import az.course.courseandtalant.model.courseDto.CourseTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String companyName;
    //private Long companyIconId;
    private String courseName;
    private String category;
    private double courseRating;
    private double discount;
    private String site;
    private LocalDate courseStartDate;
    private double courseDurationWeeks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson", referencedColumnName = "id")
    private LessonEntity lesson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price", referencedColumnName = "id")
    private PriceEntity price;

    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseTypeEnum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location", referencedColumnName = "id")
    private AddressEntity address;
    private boolean finalProject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate", referencedColumnName = "id")
    private CertificateEntity certificate;

    private boolean practice;
    private boolean babyZone;

    @Column(unique=true)
    private String searchKeys;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
