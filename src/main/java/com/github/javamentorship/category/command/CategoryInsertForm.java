package com.github.javamentorship.category.command;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public class CategoryInsertForm {

    @NotEmpty
    @Size(max = 64)
    private String name;
    private int parentId; //TODO change primitive int to Integer


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

}
