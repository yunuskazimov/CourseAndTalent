package az.course.courseandtalant.dao.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String country;
    private String city;
    private String district;
    private String street;
    private String line;
    @OneToOne(mappedBy = "address")
    private CourseEntity course;
    private boolean global;
}
