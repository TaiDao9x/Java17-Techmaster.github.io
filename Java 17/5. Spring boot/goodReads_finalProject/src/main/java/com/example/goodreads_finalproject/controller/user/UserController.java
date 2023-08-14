package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.entity.District;
import com.example.goodreads_finalproject.exception.BadRequestException;
import com.example.goodreads_finalproject.exception.NotFoundException;
import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.model.request.ResetPasswordRequest;
import com.example.goodreads_finalproject.model.request.EmailRequest;
import com.example.goodreads_finalproject.model.request.WardRequest;
import com.example.goodreads_finalproject.model.response.LocationResponse;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping("/api/v1/users/districts/{provinceCode}")
    public ResponseEntity<?> getDistricts(@PathVariable String provinceCode) {
        try {
            List<LocationResponse> districts = userService.getDistricts(provinceCode);
            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/v1/users/wards/{districtCode}")
    public ResponseEntity<?> getWards(@PathVariable String districtCode) {
        try {
            List<LocationResponse> wards = userService.getWards(districtCode);
            return new ResponseEntity<>(wards, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/v1/users/address")
    public ResponseEntity<?> updateAddress(@RequestBody WardRequest wardRequest) {
        userService.updateAddress(wardRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
