package az.course.courseandtalant.dao.course.repository;

import az.course.courseandtalant.dao.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {
    Optional<List<CourseEntity>> findByAddress_Global(boolean check);

    Optional<List<CourseEntity>> findBySearchKeysContains(String searchKey);

    Optional<CourseEntity> findByCourseName(String name);
}
