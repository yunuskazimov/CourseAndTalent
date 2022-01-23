package az.course.courseandtalant.model.suggestCourseDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuggestCourseDto {
    private Long id;
    private String name;
    private List<SuggestCourseStepDto> steps;
    @JsonIgnore
    private String searchKeys;



}
