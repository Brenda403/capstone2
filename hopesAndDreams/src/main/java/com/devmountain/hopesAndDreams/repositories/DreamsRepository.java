package com.devmountain.hopesAndDreams.repositories;

import com.devmountain.hopesAndDreams.entities.Dreams;
import com.devmountain.hopesAndDreams.entities.Hopes;
import com.devmountain.hopesAndDreams.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DreamsRepository extends JpaRepository<Dreams, Long> {

    List<Dreams> findAllByUserEquals(User user);

}
