package com.devmountain.hopesAndDreams.services;

import com.devmountain.hopesAndDreams.dtos.DreamsDto;
import com.devmountain.hopesAndDreams.dtos.HopesDto;
import com.devmountain.hopesAndDreams.entities.Dreams;
import com.devmountain.hopesAndDreams.entities.Hopes;
import com.devmountain.hopesAndDreams.entities.User;
import com.devmountain.hopesAndDreams.repositories.DreamsRepository;
import com.devmountain.hopesAndDreams.repositories.HopesRepository;
import com.devmountain.hopesAndDreams.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DreamsServiceImpl implements DreamsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DreamsRepository dreamsRepository;

    // Adding a Dream
    @Override
    @Transactional
    public void addDream(DreamsDto dreamsDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Dreams dreams = new Dreams(dreamsDto);
        userOptional.ifPresent(dreams::setUser);
        dreamsRepository.saveAndFlush(dreams);

    }

    // Deleting a Dream
    @Override
    @Transactional
    public void deleteDreamById(Long dreamId) {
        Optional<Dreams> dreamsOptional = dreamsRepository.findById(dreamId);
        dreamsOptional.ifPresent(dreams -> dreamsRepository.delete(dreams));
    }

    //Update a Dream

    @Override
    @Transactional
    public void updateDreamById(DreamsDto dreamsDto) {
        Optional<Dreams> dreamsOptional = dreamsRepository.findById(dreamsDto.getId());
        dreamsOptional.ifPresent(dreams -> {
            dreams.setBody(dreamsDto.getBody());
            dreamsRepository.saveAndFlush(dreams);
        });
    }


    //Getting a Dream by Id

    @Override
    @Transactional
    public Optional<DreamsDto> getDreamById(Long dreamId) {
        Optional<Dreams> dreamsOptional = dreamsRepository.findById(dreamId);
        if (dreamsOptional.isPresent()) {
            return Optional.of(new DreamsDto(dreamsOptional.get()));
        }
        return Optional.empty();
    }

    // Getting all Dreams by User

    @Override
    public List<DreamsDto> getAllDreamsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Dreams> dreamsList= dreamsRepository.findAllByUserEquals(userOptional.get());
            return dreamsList.stream().map(dreams -> new DreamsDto(dreams)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }



    // random generated prompts for Dreams

//    private static final String[] PROMPTS = {
//            "What is your biggest dream?",
//            "Describe a place you've always wanted to visit.",
//            "What is your ideal future?",
//            "What is your biggest hope for next month?",
//            "What is a habit you hope to break?"
//    };


















}
