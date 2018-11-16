package mga.edu.admissions.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {
	@Id
	@GeneratedValue
	private Long id;
	
	private String studentFirstName;
	private String studentLastName;
	private Date stduentDateOfBirth;
	private String degree;
	private String semester;
	private String status;

	public Application() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public Date getStduentDateOfBirth() {
		return stduentDateOfBirth;
	}

	public void setStduentDateOfBirth(Date stduentDateOfBirth) {
		this.stduentDateOfBirth = stduentDateOfBirth;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
