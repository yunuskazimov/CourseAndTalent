package az.course.courseandtalant.dao.course.repository;

import az.course.courseandtalant.dao.course.entity.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<CertificateEntity, Long> {

}
