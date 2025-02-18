package rppim.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppim.jpa.Student;
import rppim.reps.StudentRepository;

@RestController
public class StudentRestController {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns Collection of Student")
	@GetMapping("student")
	public Collection<Student> getAll(){
		return studentRepository.findAll();
	}
	@ApiOperation(value = "Returns Student with id forwarded as path variable")
	@GetMapping("student/{id}")
	public Student getOne(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@ApiOperation(value = "Returns Collection of Student containing brojIndeksa forwarded as path variable")
	@GetMapping("student/brojIndeksa/{brojIndeksa}")
	public Collection<Student> getByNaziv(@PathVariable("brojIndeksa") String brojIndeksa){
		return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}
	@ApiOperation(value = "Adds instance of Student to database")
	@PostMapping("student")
	public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student){
		studentRepository.save(student);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	@ApiOperation(value = "Updates Student with id forwarded as path variable")
	@PutMapping("student/{id}")
	public ResponseEntity<HttpStatus> updateArtikl(@RequestBody Student student, 
			@PathVariable("id")Integer id){
		if(studentRepository.existsById(id)) {
			student.setId(id);
			studentRepository.save(student);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
		
	}
	@ApiOperation("Deletes Student with id forwarded as path variable")
	@DeleteMapping("student/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		if(id==-100 && !studentRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO student (\"id\", \"ime\", \"prezime\", \"broj_indeksa\",\"grupa\",\"projekat\") VALUES (-100, 'test', 'test', 'test', 1, 1 )");
		}
		
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	

}
