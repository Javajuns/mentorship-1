package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("DELETE FROM category WHERE id = ?");
        updateStmt.setInt(1, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public Category getById(int id) throws SQLException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category WHERE id = ?");
        selectStatement.setInt(1, id);
        ResultSet result = selectStatement.executeQuery();
        result.next();
        selectStatement.close();
        return hydrateCategory(result);
    }

    @Override
    public synchronized void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("UPDATE category SET name = ?, parent_id = ? WHERE id = ?");
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public synchronized void addCategory(String name, int parentId) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("INSERT INTO category (name, parent_id) VALUES (?, ?)");
        updateStmt.setString(1, name);
        if (parentId==0){
            updateStmt.setNull(2,java.sql.Types.INTEGER);
        }else {
            updateStmt.setInt(2, parentId);
        }
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category");
        ResultSet result = selectStatement.executeQuery();
        List<Category> categories = new ArrayList<Category>();
        while (result.next()) {
            categories.add(hydrateCategory(result));
        }
        selectStatement.close();
        return categories;
    }

    private Category hydrateCategory(ResultSet result) throws SQLException {
        return new Category.CategoryBuilder().setId(result.getInt("id"))
                .setName(result.getString("name"))
                .setParentId(result.getInt("parent_id"))
                .build();
    }
}
