package az.course.courseandtalant.service;

import az.course.courseandtalant.model.courseDto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto editCourse(CourseDto courseDto);

    List<CourseDto> getCourse();

    CourseDto getByName(String courseName);

    List<CourseDto> getByNameContains(String courseName);

    List<CourseDto> getByCountryIsGlobal(boolean check);

    List<CourseDto> getByPrice(long minPrice, long maxPrice);

}
