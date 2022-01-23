package az.course.courseandtalant.model.suggestCourseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuggestCourseStepDto {
    private Long id;
    private String title;
    private String stepName;
    private String level;
}
