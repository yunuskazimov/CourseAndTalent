package az.course.courseandtalant.model.courseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificateDto {
    private Long id;
    private boolean certificate;
    private boolean global;

}
