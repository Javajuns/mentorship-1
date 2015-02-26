package com.github.javamentorship.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class CategoryUpdateForm {

    @NotEmpty
    @Size(max = 64)
    private String name;

    @NotEmpty
    private int id;

    @NotEmpty
    private int parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    //TODO add toString();
}
