package com.burock.relations.onetomanytoone.bidirectional.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Band {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private Integer foundedYear;

    @JsonManagedReference
    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Musician> musicians = new ArrayList<>();

    public void addMusician(Musician musician) {
        if (musicians == null) {
            musicians = new ArrayList<>();
        }
        musicians.add(musician);
        musician.setBand(this);
    }
}
