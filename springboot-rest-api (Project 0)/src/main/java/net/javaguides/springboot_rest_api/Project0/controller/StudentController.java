package net.javaguides.springboot_rest_api.Project0.controller;


import net.javaguides.springboot_rest_api.Project0.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Rafael",
                "Cervera"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "Rafael")
                .body(student);
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity <List<Student>>  getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Rafael","Cervera"));
        students.add(new Student(2, "Astro", "Coder"));
        students.add(new Student(3, "Adam", "Maxwell"));
        students.add(new Student(4, "Sara", "Lefevre"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/Rafael/Cervera
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName) {
        // The @PathVariableAnnotation is used to bind the value of URI template variable into method argument
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Rafael&lastName=Cervera
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);

    }

    // Spring Boot REST API that handles HTTP POST Request -creating new Resource
    // @PostMapping and @RequestBody
    @PostMapping("create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        /*
        The @RequestBody annotation is responsible for retrieving the
        HTTP request body and automatically converting it o the Java Object
         */
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    // Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted succesfully");

    }

}
