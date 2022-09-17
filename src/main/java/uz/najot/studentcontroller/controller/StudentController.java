package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Students;
import uz.najot.studentcontroller.service.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResMessage studentSave(@Valid @RequestBody Students students){

        return studentService.save(students);
    }
    @GetMapping
    public  ResMessage getAll(){

        return studentService.findAll();
    }
    @GetMapping("{group_id}")
    public ResMessage getByGroupId(@PathVariable Integer group_id){

        return studentService.findByGroupId(group_id);
    }
    @DeleteMapping("{student_id}")
    public ResMessage delete(@PathVariable Integer student_id){
        return studentService.deleteById(student_id);
    }
}
