package com.devmountain.hopesAndDreams.entities;


import com.devmountain.hopesAndDreams.dtos.HopesDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Hopes")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Hopes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;


    //adding to resolve error in HopesServiceImpl for setUser(Cannot resolve method 'setUser')

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hopes(HopesDto hopesDto) {
        if (hopesDto.getBody() != null) {
            this.body = hopesDto.getBody();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Hopes() {
    }

    public Hopes(Long id, String body, User user) {
        this.id = id;
        this.body = body;
        this.user = user;
    }

//    public Hopes(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }
}
