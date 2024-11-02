package com.microservices.student.response;
import com.microservices.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressResponse addressResponse;
    public StudentResponse(Student student) {
        this.id=student.getId();
        this.firstName=student.getFirstName();
        this.lastName=student.getLastName();
        this.email=student.getEmail();
    }
}
