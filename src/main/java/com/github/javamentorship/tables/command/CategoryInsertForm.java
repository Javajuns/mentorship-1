package com.github.javamentorship.tables.command;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public class CategoryInsertForm {

    @NotEmpty
    @Size(max = 64)
    private String name;
    private Integer parentId;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getParentId() {
        return parentId;
    }

}
