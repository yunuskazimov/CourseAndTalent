package az.course.courseandtalant.dao.courseSuggest.repository;

import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuggestCourseRepo extends JpaRepository<SuggestCourseEntity, Long> {
    Optional<List<SuggestCourseEntity>> findByNameContains(String name);
    Optional<List<SuggestCourseEntity>> findBySearchKeysContains(String searchKey);
    Optional<SuggestCourseEntity> findByName(String name);
}
