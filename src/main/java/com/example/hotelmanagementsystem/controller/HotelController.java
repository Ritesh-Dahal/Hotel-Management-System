package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.dto.request.HotelRequest;
import com.example.hotelmanagementsystem.dto.response.HotelResponse;
import com.example.hotelmanagementsystem.service.AuthService;
import com.example.hotelmanagementsystem.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController{

    private HotelService hotelService;
    private AuthService authService;

    public HotelController(HotelService hotelService,AuthService authService){
        this.hotelService = hotelService;
        this.authService = authService;
    }


    @PostMapping("/hotel")

    public ResponseEntity<?> addSingleHotel(@RequestHeader String authorization,@RequestBody HotelRequest hotelRequest){

        authService.ValidatingCustomer(authorization);
        hotelService.addSingleHotelToDb(hotelRequest);
        return BaseController.successResponse("Hotel Added SuccessFully","{ }");

    }

    @PostMapping("/hotels")
    public ResponseEntity<?> addListOfHotel(@RequestBody List<HotelRequest> hotelRequest){

        hotelService.addListOfHotel(hotelRequest);
        return BaseController.successResponse("Hotel Added SuccessFully","{ }");

    }

    @DeleteMapping("/delete/hotel/{id}")

    public ResponseEntity<?> deletingHotelById(@PathVariable Long id){

        hotelService.deleteHotelById(id);
        return BaseController.successResponse("User Deleted Successfully","{ }");

    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<?> getHotelDetailsById(@PathVariable Long id ){

        HotelResponse response = hotelService.getHotelById(id);
        return BaseController.successResponse("List Of Available Hotels",response);
    }


    @GetMapping("/hotels")
    public ResponseEntity<?> getallHotelDetails(){
        List< HotelResponse> responseList = hotelService.getAllHotelDetails();
        return BaseController.successResponse("List Of Available Hotels",responseList);
    }


}
