package mga.edu.admissions.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import mga.edu.admissions.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	Collection<Application> findByStatus(String status);

	Collection<Application> findById(Integer Id);
}
