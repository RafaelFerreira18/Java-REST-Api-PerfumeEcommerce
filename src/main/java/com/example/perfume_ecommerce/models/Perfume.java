package com.example.perfume_ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_perfume")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String perfumeName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    public Perfume(){}

    public Perfume(Long id, String perfumeName, String description, Double price){
        this.id = id;
        this.perfumeName = perfumeName;
        this.description = description;
        this.price = price;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the perfumeName
     */
    public String getPerfumeName() {
        return perfumeName;
    }

    /**
     * @param perfumeName the perfumeName to set
     */
    public void setPerfumeName(String perfumeName) {
        this.perfumeName = perfumeName;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Double return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
