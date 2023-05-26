package com.example.studentclonebaithay.service;

import com.example.studentclonebaithay.model.response.RegionResponse;
import com.example.studentclonebaithay.statics.Region;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    public List<RegionResponse> getAll() {
        List<RegionResponse> dtos = new ArrayList<>();
        dtos.add(new RegionResponse(Region.MIEN_BAC.toString(), Region.MIEN_BAC.name));
        dtos.add(new RegionResponse(Region.MIEN_TRUNG.toString(), Region.MIEN_TRUNG.name));
        dtos.add(new RegionResponse(Region.MIEN_NAM.toString(), Region.MIEN_NAM.name));

        return dtos;
    }
}
