package com.github.javamentorship.tables.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "login", nullable = false, length = 254)
    private String login;
    @Column(name = "first_name", nullable = false, length = 35)
    private String firstName;
    @Column(name = "second_name", nullable = false, length = 35)
    private String secondName;
    @Column(name = "email", nullable = false, length = 254)
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", nullable = false)
    private Date dateCreated = new Date();
    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin = false;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address; //TODO на странице пользователей выводить их адресс. Ну добавить их редактирования

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

