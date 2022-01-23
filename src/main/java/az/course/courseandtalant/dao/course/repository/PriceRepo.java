package az.course.courseandtalant.dao.course.repository;

import az.course.courseandtalant.dao.course.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<PriceEntity, Long> {

}
