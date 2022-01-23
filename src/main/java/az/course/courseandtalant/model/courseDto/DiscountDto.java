package az.course.courseandtalant.model.courseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountDto {
    private Long id;
    private Long lampSumPayDiscount;
    private Long companyDiscount;

}
