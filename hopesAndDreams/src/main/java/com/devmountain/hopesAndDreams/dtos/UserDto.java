package com.devmountain.hopesAndDreams.dtos;

import com.devmountain.hopesAndDreams.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Set<HopesDto> hopesDtoSet = new HashSet<>();
    private Set<DreamsDto> dreamsDtoSet = new HashSet<>();


    // don't include hash sets
    public UserDto (User user) {
        if (user.getId() != null) {
            this.id = user.getId();
        }
        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }
        if (user.getPassword() != null) {
            this.password = user.getPassword();
        }

    }

}
