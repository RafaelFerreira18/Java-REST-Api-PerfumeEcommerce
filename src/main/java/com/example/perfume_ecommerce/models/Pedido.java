package com.example.perfume_ecommerce.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tab_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Set<Perfume> perfumes = new HashSet<>();

    // Construtores
    public Pedido() {
    }

    public Pedido(User user, Set<Perfume> perfumes) {
        this.user = user;
        this.perfumes = perfumes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Perfume> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(Set<Perfume> perfumes) {
        this.perfumes = perfumes;
    }
}
