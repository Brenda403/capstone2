package com.devmountain.hopesAndDreams.services;

import com.devmountain.hopesAndDreams.dtos.DreamsDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DreamsService {
    // Adding a Dream
    @Transactional
    void addDream(DreamsDto dreamsDto, Long userId);

    // Deleting a Dream
    @Transactional
    void deleteDreamById(Long dreamId);

    @Transactional
    void updateDreamById(DreamsDto dreamsDto);

    @Transactional
    Optional<DreamsDto> getDreamById(Long dreamId);

    List<DreamsDto> getAllDreamsByUserId(Long userId);
}
