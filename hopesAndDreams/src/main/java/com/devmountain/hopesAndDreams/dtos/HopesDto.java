package com.devmountain.hopesAndDreams.dtos;

import com.devmountain.hopesAndDreams.entities.Hopes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopesDto implements Serializable {

    private Long id;
    private String body;
    private UserDto userDto;

    public HopesDto(Hopes hopes) {
        if (hopes.getId() != null) {
            this.id = hopes.getId();
        }
        if (hopes.getBody() != null) {
            this.body = hopes.getBody();
        }
    }


}
