package com.devmountain.hopesAndDreams.entities;


import com.devmountain.hopesAndDreams.dtos.DreamsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Dreams")
public class Dreams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;


    @ManyToOne
    @JsonBackReference
    private User user;

    public Dreams(DreamsDto dreamsDto) {
        if (dreamsDto.getBody() != null) {
            this.body = dreamsDto.getBody();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Dreams() {
    }

    public Dreams(Long id, String body, User user) {
        this.id = id;
        this.body = body;
        this.user = user;
    }

    //    public Dreams(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }

}


