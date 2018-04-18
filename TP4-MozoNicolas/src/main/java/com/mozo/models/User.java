package com.mozo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="ip", nullable = false, unique = true)
    private String ip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Navigator browser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private OS os;
}

