package com.devmountain.hopesAndDreams.services;

import com.devmountain.hopesAndDreams.dtos.HopesDto;
import com.devmountain.hopesAndDreams.dtos.UserDto;
import com.devmountain.hopesAndDreams.entities.Hopes;
import com.devmountain.hopesAndDreams.entities.User;
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
public class HopesServiceImpl implements HopesService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HopesRepository hopesRepository;

    // Adding a Hope

    @Override
    @Transactional
    public void addHope(HopesDto hopesDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Hopes hopes = new Hopes(hopesDto);
        userOptional.ifPresent(hopes::setUser);
        hopesRepository.saveAndFlush(hopes);

    }

    // Deleting a Hope
    @Override
    @Transactional
    public void deleteHopeById(Long hopeId) {
      Optional<Hopes> hopesOptional = hopesRepository.findById(hopeId);
      hopesOptional.ifPresent(hopes -> hopesRepository.delete(hopes));
    }


    //Update a Hope

    @Override
    @Transactional
    public void updateHopeById(HopesDto hopesDto) {
        Optional<Hopes> hopesOptional = hopesRepository.findById(hopesDto.getId());
        hopesOptional.ifPresent(hopes -> {
           hopes.setBody(hopesDto.getBody());
           hopesRepository.saveAndFlush(hopes);
        });
    }


    //Getting a Hope by Id

    @Override
    public Optional<HopesDto> getHopeById(Long hopeId) {
        Optional<Hopes> hopesOptional = hopesRepository.findById(hopeId);
        if (hopesOptional.isPresent()) {
            return Optional.of(new HopesDto(hopesOptional.get()));
        }
        return Optional.empty();
    }

    //Getting all Hopes by User

    @Override
    public List<HopesDto> getAllHopesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Hopes> hopesList = hopesRepository.findAllByUserEquals(userOptional.get());
            return hopesList.stream().map(hopes -> new HopesDto(hopes)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }




























}
