package az.course.courseandtalant.service;

import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseDto;

import java.util.List;

public interface SuggestCourseService {

    SuggestCourseDto createSuggestCourse(SuggestCourseDto suggestCourseDto);

    SuggestCourseDto editSuggestCourse(SuggestCourseDto suggestCourseDto);

    List<SuggestCourseDto> getSuggestCourse();

    SuggestCourseDto getSuggestCourseByName(String courseName);

    SuggestCourseDto getSuggestCourseById(Long id);

    List<SuggestCourseDto> getSuggestCourseByNameContains(String searchKey);

}
