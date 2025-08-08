package com.burock.relations.onetomanytoone.bidirectional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String instrument;
    private Integer joinYear;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;
}