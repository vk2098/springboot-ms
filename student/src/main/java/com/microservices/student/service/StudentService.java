package com.microservices.student.service;
import com.microservices.student.Common.CommonService;
import com.microservices.student.entity.Student;
import com.microservices.student.feignclients.FeinClient;
import com.microservices.student.repository.StudentRepository;
import com.microservices.student.request.CreateStudentRequest;
import com.microservices.student.response.AddressResponse;
import com.microservices.student.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    WebClient webClient;

    @Autowired
    CommonService commonService;

    @Autowired
    FeinClient feinClient;
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);
        StudentResponse studentResponse=new StudentResponse(student);
//        studentResponse.setAddressResponse(getAddressResponse(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressResponse(student.getId()));
        return  studentResponse;

    }
//    private AddressResponse getAddressResponse(Long addressId) {
//       AddressResponse addressResponse= webClient.get().uri("/getById/"+addressId)
//               .retrieve().bodyToMono(AddressResponse.class).block();
//       return addressResponse;
//    }

//    private AddressResponse getAddressResponse(Long addressId) {
//        AddressResponse addressResponse= feinClient.getById(addressId);
//        return addressResponse;
//    }
    public StudentResponse getById (long id) {
        Student student= studentRepository.getById(id);
        StudentResponse studentResponse=new StudentResponse(student);
//        studentResponse.setAddressResponse(getAddressResponse(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressResponse(student.getId()));
        return  studentResponse;
    }
}