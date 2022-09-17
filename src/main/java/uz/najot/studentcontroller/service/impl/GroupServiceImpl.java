package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Groups;
import uz.najot.studentcontroller.service.GroupService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public ResMessage findAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from groups");
        return ResMessage.getSuccess(maps);
    }

    @Override
    public ResMessage save(Groups groups) {
        int update = jdbcTemplate.update("insert into groups (name, class_id) VALUES (?,?)", groups.getName(), groups.getClassId());

        return update>0 ? ResMessage.getSuccess() : new ResMessage(101,"not created",null);
    }

    @Override
    public ResMessage deleteById(Integer id) {

        int update = jdbcTemplate.update("delete from groups where id=?", id);
        return update > 0 ? ResMessage.getSuccess() : new ResMessage(102,"not deleted",null);
    }

    @Override
    public ResMessage update(Groups groups) {
        int update = jdbcTemplate.update("update groups set name=? where id=?", groups.getName(), groups.getId());
        return update>0 ? ResMessage.getSuccess() : new ResMessage(103,"not updated",null);

    }

    @Override
    public ResMessage findByClassId(Integer classId) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select id,name, created_date from groups where class_id = ?", classId);
        return ResMessage.getSuccess(maps);
    }
}
