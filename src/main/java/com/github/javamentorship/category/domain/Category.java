package com.github.javamentorship.category.domain;

import javax.persistence.*;

@Entity
@Table(name="Category"
        , uniqueConstraints={@UniqueConstraint(columnNames={"id"})}
)
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=7)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="parent_id")
    private Integer parentId;

    public Category(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Category(String name, Integer parentId) {
        this(null, name, parentId);
    }

    public Category(Integer id) {
        this(id, null, null);
    }

    public Category() {

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
