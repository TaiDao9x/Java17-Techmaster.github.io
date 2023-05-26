package com.example.studentclonebaithay.controller;

import com.example.studentclonebaithay.model.response.RegionResponse;
import com.example.studentclonebaithay.service.RegionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/regions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class RegionController {
    RegionService regionService;

    @GetMapping
    public List<RegionResponse> getAll() {
        return regionService.getAll();
    }

}
