package az.course.courseandtalant.dao.course.repository;

import az.course.courseandtalant.dao.course.entity.AddressEntity;
import az.course.courseandtalant.dao.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdressRepo extends JpaRepository<AddressEntity, Long> {


}
