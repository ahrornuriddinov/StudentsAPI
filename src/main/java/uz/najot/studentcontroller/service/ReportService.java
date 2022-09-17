package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;

public interface ReportService {
    ResMessage getReport(String type, String args);

}
