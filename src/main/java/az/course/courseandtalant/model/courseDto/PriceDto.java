package az.course.courseandtalant.model.courseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {
    private Long id;
    private double totalPrice;
    private double monthlyPrice;

}
