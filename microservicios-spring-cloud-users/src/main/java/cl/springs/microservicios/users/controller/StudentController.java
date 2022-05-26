package cl.springs.microservicios.users.controller;

import cl.springs.microservicios.users.model.Student;
import cl.springs.microservicios.users.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("")
    public ResponseEntity<?> listStudent() {
        return ResponseEntity.ok().body(studentServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewStudent(@PathVariable(name = "id") Integer id) {
        Optional<Student> student = studentServices.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(student.get());
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        Student student1 = studentServices.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable(name = "id") Integer id) {
        Optional<Student> optionalStudent = studentServices.findById(id);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student studentSave = optionalStudent.get();
        studentSave.setFirstName(student.getFirstName());
        studentSave.setLastName(student.getLastName());
        studentSave.setEmail(student.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(studentServices.save(studentSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Integer id) {
        studentServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}