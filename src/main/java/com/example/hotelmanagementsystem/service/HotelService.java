package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.dto.request.HotelRequest;
import com.example.hotelmanagementsystem.dto.response.HotelResponse;
import com.example.hotelmanagementsystem.entity.Hotel;
import com.example.hotelmanagementsystem.exception.AlreadyExistException;
import com.example.hotelmanagementsystem.exception.NotFoundException;
import com.example.hotelmanagementsystem.repository.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo){
        this.hotelRepo=hotelRepo;
    }



    public void addSingleHotelToDb(HotelRequest request){

        hotelRepo.findHotelByHotelNameAndIsDeletedFalse(request.getHotelName())
                .ifPresent(hotel-> {throw new AlreadyExistException("Hotel with name "+ hotel.getHotelName()+ " Already Exist");});


            Hotel hotel = new Hotel(request);
            hotel.setDeleted(false);
            hotelRepo.save(hotel);

    }

    public void addListOfHotel(List<HotelRequest> request){



        for(HotelRequest hotelRequest : request ){

            hotelRepo.findHotelByHotelNameAndIsDeletedFalse(hotelRequest.getHotelName())
                    .ifPresent(hotel-> {throw new AlreadyExistException("Hotel with name "+ hotel.getHotelName()+ " Already Exist");});
        }

        List<Hotel> hotelList = request.stream().map(Hotel::new).toList();
        hotelRepo.saveAll(hotelList);

    }

    public void deleteHotelById(Long id){

       Hotel hotel= hotelRepo.findById(id).orElseThrow(()-> new NotFoundException("Hotel Not Found"));

        hotel.setDeleted(true);
        hotelRepo.save(hotel);

    }

    public HotelResponse getHotelById(Long id){

        Optional<Hotel> optionalHotel = hotelRepo.findById(id);
        HotelResponse hotelResponse;
        if(optionalHotel.isPresent()){
            hotelResponse= new HotelResponse(optionalHotel.get());
        }else {
            throw new NotFoundException("Hotel Not Found");
        }

        return hotelResponse;

    }

    public List<HotelResponse> getAllHotelDetails(){


       List<HotelResponse> hotelResponses = hotelRepo.findAll().stream().map(HotelResponse::new).toList();
       return hotelResponses;

    }

}
