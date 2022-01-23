package az.course.courseandtalant.controller;

import az.course.courseandtalant.model.courseDto.CourseDto;
import az.course.courseandtalant.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        log.info("createCourse controller start with course Name, {}", courseDto.getCourseName());
        return courseService.createCourse(courseDto);
    }

    @GetMapping
    public List<CourseDto> getCourseList() {
        log.info("getCourseList controller start");
        return courseService.getCourse();
    }

    @GetMapping("/name/{courseName}")
    public CourseDto getCourseByName(@PathVariable String courseName) {
        log.info("getCourseByName controller start");
        return courseService.getByName(courseName);
    }

    @GetMapping("/name/contains/{searchKey}")
    public List<CourseDto> getCourseListByNameContains(@PathVariable String searchKey) {
        log.info("getCourseByName controller start");
        return courseService.getByNameContains(searchKey);
    }

    @GetMapping("/price")
    public List<CourseDto> getCourseListByPrice(@RequestParam("min") long min, @RequestParam("max") long max) {
        log.info("getCourseByName controller start");
        return courseService.getByPrice(min, max);
    }

    @GetMapping("/global")
    public List<CourseDto> getCourseListByCountry(@RequestParam("check") boolean check) {
        log.info("getCourseListByCountry controller start");
        return courseService.getByCountryIsGlobal(check);
    }

}