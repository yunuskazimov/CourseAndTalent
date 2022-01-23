package az.course.courseandtalant.controller;

import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseDto;
import az.course.courseandtalant.service.SuggestCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggest")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class SuggestCourseController {
    private final SuggestCourseService suggestCourseService;

    @PostMapping
    public SuggestCourseDto createSuggestCourse(@RequestBody SuggestCourseDto suggestCourseDto) {
        log.info("createSuggestCourse controller start with course Name, {}", suggestCourseDto.getName());
        return suggestCourseService.createSuggestCourse(suggestCourseDto);
    }

    @GetMapping
    public List<SuggestCourseDto> getSuggestCourseList() {
        log.info("getCourseList controller start");
        return suggestCourseService.getSuggestCourse();
    }


    @GetMapping("/name/contains/{suggestName}")
    public List<SuggestCourseDto> getCourseListByNameContains(@PathVariable String suggestName) {
        log.info("getCourseListByNameContains controller start");
        return suggestCourseService.getSuggestCourseByNameContains(suggestName);
    }

    @GetMapping("/name/{courseName}")
    public SuggestCourseDto getCourseByName(@PathVariable String courseName) {
        log.info("getCourseByName controller start");
        return suggestCourseService.getSuggestCourseByName(courseName);
    }

    @GetMapping("/id/{id}")
    public SuggestCourseDto getCourseById(@PathVariable Long id) {
        log.info("getCourseById controller start");
        return suggestCourseService.getSuggestCourseById(id);
    }


}