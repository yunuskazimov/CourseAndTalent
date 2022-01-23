package az.course.courseandtalant.model.courseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private Long id;
    private String country;
    private String city;
    private String district;
    private String street;
    private String line;
    private boolean global;

}
