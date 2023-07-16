package com.devmountain.hopesAndDreams.controllers;

import com.devmountain.hopesAndDreams.dtos.HopesDto;
import com.devmountain.hopesAndDreams.services.HopesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hopes")
public class HopesController {

    @Autowired
    private HopesService hopesService;


    //adding a hope
    @PostMapping("/user/{userId}")
    public void addHope(@RequestBody HopesDto hopesDto, @PathVariable Long userId) {
        hopesService.addHope(hopesDto,userId);
    }

    // deleting a hope

    @DeleteMapping("/{hopeId}")
    public void deleteHopeById(@PathVariable Long hopeId) {
        hopesService.deleteHopeById(hopeId);
    }

    // update a hope
    @PutMapping
    public void updateHope(@RequestBody HopesDto hopesDto) {
        hopesService.updateHopeById(hopesDto);
    }

    // get a hope by id
    @GetMapping("/{hopeId}")
    public Optional<HopesDto> getHopeById(@PathVariable Long hopeId) {
        return hopesService.getHopeById(hopeId);
    }

    // get all dreams by user
    @GetMapping("/user/{userId}")
    public List<HopesDto> getHopesByUser(@PathVariable Long userId) {
        return hopesService.getAllHopesByUserId(userId);
    }



}
