package mga.edu.admissions;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mga.edu.admissions.model.Application;
import mga.edu.admissions.repository.ApplicationRepository;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
	private final ApplicationRepository applicationRepository;

	@Autowired
	ApplicationController(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	@GetMapping
	@RequestMapping("/{status}")
	Collection<Application> getApplicationsByStatus(@PathVariable String status) {
		return this.applicationRepository.findByStatus(status);
	}

//	@GetMapping
//	Collection<Application> getApplicationsById(@PathVariable Integer id) {
//		return this.applicationRepository.findById(id);
//	}

	@PostMapping
	ResponseEntity<?> add(@RequestBody Application application) {
		Application createdApplication = this.applicationRepository.save(application);
		if (createdApplication != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(createdApplication.getId()).toUri();
			return ResponseEntity.created(location).build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
