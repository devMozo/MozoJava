package com.mozo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="ip", nullable = false, unique = true)
    private String ip;

    @ManyToOne
    @Column(name="id_os", nullable = false)
    private String id_os;

    @ManyToOne
    @Column(name="id_browser", nullable = false)
    private String id_browser;
}

