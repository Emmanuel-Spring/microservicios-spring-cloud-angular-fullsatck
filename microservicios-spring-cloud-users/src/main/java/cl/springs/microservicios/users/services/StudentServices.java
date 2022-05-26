package cl.springs.microservicios.users.services;

import cl.springs.microservicios.users.model.Student;

import java.util.Optional;

public interface StudentServices {

    Iterable<Student> findAll();

    Optional<Student> findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);
}
