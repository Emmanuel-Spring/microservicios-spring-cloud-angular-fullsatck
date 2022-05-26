package cl.springs.microservicios.users.repository;

import cl.springs.microservicios.users.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
