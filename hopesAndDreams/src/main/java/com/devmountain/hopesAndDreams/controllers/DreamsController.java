package com.devmountain.hopesAndDreams.controllers;

import com.devmountain.hopesAndDreams.dtos.DreamsDto;
import com.devmountain.hopesAndDreams.services.DreamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dreams")
public class DreamsController {
    @Autowired
    private DreamsService dreamsService;

    // adding a dream
    @PostMapping("/user/{userId}")
    public void addDream(@RequestBody DreamsDto dreamsDto, @PathVariable Long userId) {
        dreamsService.addDream(dreamsDto, userId);
    }

    // deleting a dream

    @DeleteMapping("/{dreamId}")
    public void deleteDreamById(@PathVariable Long dreamId) {
        dreamsService.deleteDreamById(dreamId);
    }

    // update a dream

    @PutMapping
    public void updateDream(@RequestBody DreamsDto dreamsDto) {
        dreamsService.updateDreamById(dreamsDto);
    }


    // get dream by id
    @GetMapping("/{dreamId}")
    public Optional<DreamsDto> getDreamById(@PathVariable Long dreamId) {
        return dreamsService.getDreamById(dreamId);
    }

    // Getting all Dreams by User
    @GetMapping("/user/{userId}")
    public List<DreamsDto> getDreamsByUser(@PathVariable Long userId) {
        return dreamsService.getAllDreamsByUserId(userId);
    }

}
