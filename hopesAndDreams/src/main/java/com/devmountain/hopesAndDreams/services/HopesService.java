package com.devmountain.hopesAndDreams.services;

import com.devmountain.hopesAndDreams.dtos.HopesDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface HopesService {
    @Transactional
    void addHope(HopesDto hopesDto, Long userId);

    // Deleting a Hope
    @Transactional
    void deleteHopeById(Long hopeId);

    @Transactional
    void updateHopeById(HopesDto hopesDto);

    Optional<HopesDto> getHopeById(Long hopeId);

    List<HopesDto> getAllHopesByUserId(Long userId);
}
