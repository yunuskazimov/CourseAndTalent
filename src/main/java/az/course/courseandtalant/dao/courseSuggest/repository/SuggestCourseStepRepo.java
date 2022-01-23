package az.course.courseandtalant.dao.courseSuggest.repository;

import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestCourseStepRepo extends JpaRepository<SuggestCourseStepEntity, Long> {

}
