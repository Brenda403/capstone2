package com.devmountain.hopesAndDreams.repositories;

import com.devmountain.hopesAndDreams.entities.Hopes;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devmountain.hopesAndDreams.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HopesRepository extends JpaRepository<Hopes, Long> {

   List<Hopes> findAllByUserEquals(User user);

}
