package com.github.javamentorship.category.command;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class CategoryInsertForm {

    @NotEmpty
    @Size(max = 64)
    private String name;
    private int parentId;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getParentId() {
        return parentId;
    }



    //TODO add toString();

}
