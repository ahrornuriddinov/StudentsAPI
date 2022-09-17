package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Classes;
import uz.najot.studentcontroller.service.ClassService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public ResMessage findAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from class");
        return ResMessage.getSuccess(maps);
    }

    @Override
    public ResMessage save(Classes classes) {
        int update = jdbcTemplate.update("insert into class(name) values (?)", classes.getName());
        if (update>0){
            return ResMessage.getSuccess();
        }
        return new ResMessage(101,"not created",null);
    }

    @Override
    public ResMessage deleteById(Integer id) {

        int update = jdbcTemplate.update("delete from class where id=?", id);
        return update>0 ? ResMessage.getSuccess() : new ResMessage(102,"not deleted",null);
    }

    @Override
    public ResMessage update(Classes classes) {
        int update = jdbcTemplate.update("update class set name=? where id=?", classes.getName(), classes.getId());
        return update>0 ? ResMessage.getSuccess() : new ResMessage(103,"not updated",null);

    }
}
