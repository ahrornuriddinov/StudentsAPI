package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Groups;

public interface GroupService extends BasicService<Groups> {
    ResMessage findByClassId(Integer classId);

}
