package az.course.courseandtalant.util;

import az.course.courseandtalant.dao.course.entity.CourseEntity;
import az.course.courseandtalant.dao.course.repository.CourseRepo;
import az.course.courseandtalant.error.exception.CourseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static az.course.courseandtalant.error.exception.ErrorCodes.NOT_FOUND;

@Component
@RequiredArgsConstructor
public class CourseUtil {
    private final CourseRepo courseRepo;

    public CourseEntity findById(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() ->
                        new CourseNotFoundException(NOT_FOUND));
    }

    public CourseEntity findByCourseName(String companyName) {
        return courseRepo.findByCourseName(companyName)
                .orElseThrow(() ->
                        new CourseNotFoundException(NOT_FOUND));

    }

    public List<CourseEntity> findByCountry(boolean check) {
        List<CourseEntity> entityList = courseRepo.findByAddress_Global(check).get();
        if (entityList.isEmpty()) {
            throw new CourseNotFoundException(NOT_FOUND);
        } else {
            return entityList;
        }
    }

    public List<CourseEntity> findBySearchKeysContains(String searchKey) {
        List<CourseEntity> entityList = courseRepo.findBySearchKeysContains(searchKey).get();
        if (entityList.isEmpty()) {
            throw new CourseNotFoundException(NOT_FOUND);
        } else {
            return entityList;
        }
    }

}
