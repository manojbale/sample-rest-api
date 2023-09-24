package com.laks.test.samplerestapi.repo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Todo")
@Data
public class Todo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "details")
    private String details;

    @Column(name = "done")
    private String done;

}
