package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Subject;

public interface SubjectService extends BasicService<Subject> {

    ResMessage getByClassId(Integer id);
}
