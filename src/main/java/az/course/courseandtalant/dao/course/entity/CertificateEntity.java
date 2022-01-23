package az.course.courseandtalant.dao.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "certificate")
@Entity
public class CertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private boolean certificate;
    private boolean global;
    @OneToOne(mappedBy = "certificate")
    private CourseEntity course;
}
