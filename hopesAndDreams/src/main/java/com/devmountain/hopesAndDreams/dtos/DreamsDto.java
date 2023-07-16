package com.devmountain.hopesAndDreams.dtos;

import com.devmountain.hopesAndDreams.entities.Dreams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DreamsDto implements Serializable {

    private Long id;
    private String body;
    private UserDto userDto;

    public DreamsDto(Dreams dreams) {
        if (dreams.getId() != null) {
            this.id = dreams.getId();
        }
        if (dreams.getBody() != null) {
            this.body = dreams.getBody();
        }
    }



}
