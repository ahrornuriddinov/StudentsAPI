package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Students;

public interface BasicService<T> {
    ResMessage findAll();
    ResMessage save(T t);
    ResMessage deleteById(Integer id);
    ResMessage update(T t);

}
