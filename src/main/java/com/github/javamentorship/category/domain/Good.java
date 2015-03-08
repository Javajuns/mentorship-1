package com.github.javamentorship.category.domain;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    /*
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORY_NAME", referencedColumnName="CATEGORY_ID")
    private Category name;
    this must work here
    i will try it later
    */
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "rest")
    private Double rest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }

    public Good() {

    }
}
