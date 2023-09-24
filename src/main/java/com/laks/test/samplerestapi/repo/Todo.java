package com.laks.test.samplerestapi.repo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Todo")
@Data
public class Todo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "details")
    private String details;

    @Column(name = "done")
    private boolean done;

}
