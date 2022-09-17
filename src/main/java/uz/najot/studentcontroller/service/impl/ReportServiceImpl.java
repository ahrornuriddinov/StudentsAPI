package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.service.ReportService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


        private final JdbcTemplate jdbcTemplate;
        @Override
        public ResMessage getReport(String type, String args) {
            String s = jdbcTemplate.queryForObject("select sql_text from  my_query where key = ?", String.class, type);
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(s, Integer.parseInt(args));

            return ResMessage.getSuccess(maps);
        }
}
