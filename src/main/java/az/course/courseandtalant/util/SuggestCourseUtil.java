package az.course.courseandtalant.util;

import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseEntity;
import az.course.courseandtalant.dao.courseSuggest.repository.SuggestCourseRepo;
import az.course.courseandtalant.error.exception.CourseNotFoundException;
import az.course.courseandtalant.error.exception.SuggestCourseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static az.course.courseandtalant.error.exception.ErrorCodes.NOT_FOUND;

@Component
@RequiredArgsConstructor
public class SuggestCourseUtil {
    private final SuggestCourseRepo suggestCourseRepo;

    public SuggestCourseEntity findById(Long id) {
        return suggestCourseRepo.findById(id)
                .orElseThrow(() ->
                        new SuggestCourseNotFoundException(NOT_FOUND));
    }

    public SuggestCourseEntity findByName(String companyName) {
        return suggestCourseRepo.findByName(companyName)
                .orElseThrow(() ->
                        new CourseNotFoundException(NOT_FOUND));

    }

    public List<SuggestCourseEntity> findBySearchKeysContains(String searchKey) {
        List<SuggestCourseEntity> entityList = suggestCourseRepo.findBySearchKeysContains(searchKey).get();
        if (entityList.isEmpty()) {
            throw new CourseNotFoundException(NOT_FOUND);
        } else {
            return entityList;
        }
    }

}
