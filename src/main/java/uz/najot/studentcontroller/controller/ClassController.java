package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Classes;
import uz.najot.studentcontroller.service.ClassService;

import javax.validation.Valid;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping
    public ResMessage getAll(){

        return classService.findAll();
    }


    @PostMapping
    public ResMessage saveClass(@Valid @RequestBody Classes classes){

        return classService.save(classes);
    }
    @DeleteMapping("{class_id}")
    public ResMessage delete(@PathVariable Integer class_id){
        return classService.deleteById(class_id);
    }

}
