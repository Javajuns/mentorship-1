package com.github.javamentorship.category.domain;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="parent_id")
    private Integer parentId;

    public Category() {
    }

    public Category(String name, Integer parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
