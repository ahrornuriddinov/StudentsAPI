package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Subject;
import uz.najot.studentcontroller.service.SubjectService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public ResMessage findAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from subject");
        return ResMessage.getSuccess(maps);
    }

    @Override
    public ResMessage save(Subject subject) {
        int update = jdbcTemplate.update("insert into subject(name, tag, class_id) values (?,?,?)", subject.getName(), subject.getTag(), subject.getClassId());
        return update>0 ? ResMessage.getSuccess() : new ResMessage(101,"not saved",null);
    }

    @Override
    public ResMessage deleteById(Integer id) {
        int update = jdbcTemplate.update("delete from subject where id=?", id);
        return update>0 ? ResMessage.getSuccess() : new ResMessage(102,"not deleted",null);

    }

    @Override
    public ResMessage update(Subject subject) {
        int update = jdbcTemplate.update("update subject set name=?,tag=?,class_id=?,is_active=? where id=?", subject.getName(),
                subject.getTag(), subject.getClassId(), subject.isActive(), subject.getId());
        return update>0 ? ResMessage.getSuccess() : new ResMessage(103,"not updated",null);
    }

    @Override
    public ResMessage getByClassId(Integer id) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from subject where class_id=?", id);
        return ResMessage.getSuccess(maps);
    }
}
