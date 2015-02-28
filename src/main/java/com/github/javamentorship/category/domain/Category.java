package com.github.javamentorship.category.domain;

public class Category {

    private int id;
    private String name;
    private int parentId;

    public Category(CategoryBuilder builder) {
        id = builder.id;
        name = builder.name;
        parentId = builder.parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public static class CategoryBuilder {
        private int id;
        private String name;
        private int parentId;

        public CategoryBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder setParentId(int parentId) {
            this.parentId = parentId;
            return this;
        }

        public Category build() {
            return new Category(this);
        }

    }

}
