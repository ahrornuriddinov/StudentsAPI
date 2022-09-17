package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.service.ReportService;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {


    private final ReportService reportService;
    @GetMapping
    public ResMessage getReport(@RequestParam String type, @RequestParam String args){
        return reportService.getReport(type,args);
    }
}
