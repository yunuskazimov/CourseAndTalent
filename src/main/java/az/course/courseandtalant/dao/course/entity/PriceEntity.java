package az.course.courseandtalant.dao.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "price")
@Entity
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private double totalPrice;
    private double monthlyPrice;
    @OneToOne(mappedBy = "price")
    private CourseEntity course;
}
