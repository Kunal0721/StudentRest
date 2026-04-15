package com.crud.CrudStudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudStudent.entity.Student;
import com.crud.CrudStudent.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository repo;

	public StudentController(StudentRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/")
	public List<Student> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
	}

	@PostMapping("/")
	public Student saveStudent(@RequestBody Student st) {
		return repo.save(st);
	}

	@PutMapping("/{id}")
	public Student editStudent(@PathVariable Long id, @RequestBody Student st) {
		return repo.findById(id).map(a -> {
			a.setName(st.getName());
			a.setAge(st.getAge());
			a.setRollno(st.getRollno());

			return repo.save(a);
		}).orElseThrow(() -> new IllegalArgumentException("Not found"));
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		repo.deleteById(id);
	}

}
