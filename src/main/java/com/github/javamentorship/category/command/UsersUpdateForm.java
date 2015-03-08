package com.github.javamentorship.category.command;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Date;

@Validated
public class UsersUpdateForm {

    @NotEmpty
    @Size(max = 254)
    private String login;
    private Integer id;
    @NotEmpty
    @Size(max = 35)
    private String firstName;
    @NotEmpty
    @Size(max = 35)
    private String secondName;
    @NotEmpty
    @Size(max = 254)
    private String email;
    private Date dateCreated;
    private boolean isAdmin;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

}
