package com.example.courseadmin.controller;

import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.model.request.CreateSupporterRequest;
import com.example.courseadmin.model.request.TopicRequest;
import com.example.courseadmin.model.request.UpdateSupporterRequest;
import com.example.courseadmin.service.CourseService;
import com.example.courseadmin.service.SupporterService;
import com.example.courseadmin.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class SupporterController {
    SupporterService supporterService;

    // Topic
    @GetMapping("/admin/supporters")
    public String findAllCourses(Model model) {
        model.addAttribute("supporterList", supporterService.getAllSupporter());
        return "supporter-list";
    }

    @PostMapping("/admin/supporters")
    public ResponseEntity<?> createSupporter(@RequestBody @Valid CreateSupporterRequest newSupporter) {
        Supporter supporter = supporterService.saveSupporter(newSupporter);
        return ResponseEntity.ok(supporter);
    }

}
