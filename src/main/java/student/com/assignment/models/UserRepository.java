package student.com.assignment.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<StudentData,Integer>{

    List<StudentData> findByGpa(float gpa);
    List<StudentData> findByFirstnameAndLastname(String firstname,String lastname);
    List<StudentData> findByUid(StudentData student);

    
}
