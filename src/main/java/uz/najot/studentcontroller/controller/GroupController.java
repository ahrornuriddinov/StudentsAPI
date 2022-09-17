package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Groups;
import uz.najot.studentcontroller.service.GroupService;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResMessage getAll(){
        return groupService.findAll();
    }

    @PostMapping
    public ResMessage saveGroups(@Valid @RequestBody Groups groups){

        return groupService.save(groups);
    }
    @GetMapping("{class_id}")
    public ResMessage getGroupsByClassId(@PathVariable Integer class_id){
        return groupService.findByClassId(class_id);
    }
    @DeleteMapping("{group_id}")
    public ResMessage delete(@PathVariable Integer group_id){
        return groupService.deleteById(group_id);
    }


}
