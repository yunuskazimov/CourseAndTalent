package az.course.courseandtalant.config;


import az.course.courseandtalant.mapper.CourseMapper;
import az.course.courseandtalant.mapper.SuggestCourseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CourseMapper courseMapper() {
        return CourseMapper.INSTANCE;
    }
    @Bean
    public SuggestCourseMapper suggestCourseMapper() {
        return SuggestCourseMapper.INSTANCE;
    }

}
