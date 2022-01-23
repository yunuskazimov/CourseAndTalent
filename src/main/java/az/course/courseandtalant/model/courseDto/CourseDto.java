package az.course.courseandtalant.model.courseDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String companyName;
    //  private Long companyIconId;
    private String courseName;
    private String category;
    private double courseRating;
    private double discount;
    private String site;
    private String courseStartDate;
    private double courseDurationWeeks;
    private LessonDto lesson;
    private PriceDto price;
    private CourseTypeEnum courseTypeEnum;
    private AddressDto address;
    private boolean finalProject;
    private CertificateDto certificate;
    private boolean practice;
    private boolean babyZone;
    @JsonIgnore
    private String searchKeys;

}
