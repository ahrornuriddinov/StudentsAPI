package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Subject;
import uz.najot.studentcontroller.service.SubjectService;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ResMessage getAll(){
        return subjectService.findAll();
    }
    @PostMapping
    public ResMessage saveSubject(@RequestBody Subject subject){
        return subjectService.save(subject);
    }
    @DeleteMapping("{subject_id}")
    public ResMessage deleteSubject(@PathVariable Integer subject_id){
        return subjectService.deleteById(subject_id);
    }
    @PostMapping("/update")
    public ResMessage updateSubject(@RequestBody Subject subject){
        return subjectService.update(subject);
    }
    @GetMapping("{class_id}")
    public ResMessage getByClassid(@PathVariable Integer class_id){
        return subjectService.getByClassId(class_id);
    }
}
