package az.course.courseandtalant.dao.course.repository;

import az.course.courseandtalant.dao.course.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<LessonEntity, Long> {

}
