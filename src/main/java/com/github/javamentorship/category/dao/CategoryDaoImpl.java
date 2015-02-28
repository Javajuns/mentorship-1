package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("DELETE FROM category WHERE id = ?");
        updateStmt.setInt(1, category.getId());
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public Category getById(Category category) throws SQLException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category WHERE id = ?");
        selectStatement.setInt(1, category.getId());
        ResultSet result = selectStatement.executeQuery();
        result.next();
        Category categoryResult = hydrateCategory(result);
        selectStatement.close();
        return categoryResult;
    }

    @Override
    public synchronized void update(Category category) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("UPDATE category SET name = ?, parent_id = ? WHERE id = ?");
        updateStmt.setString(1, category.getName());
        updateStmt.setInt(2, category.getParentId());
        updateStmt.setInt(3, category.getId());
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public synchronized void addCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
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
        Category category = new Category();
        category.setId(result.getInt("id"));
        category.setName(result.getString("name"));
        category.setParentId(result.getInt("parent_id"));
        return category;
    }
}
