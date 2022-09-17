package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Students;

public interface StudentService extends BasicService<Students> {
    ResMessage findByGroupId(Integer group_id);
}
