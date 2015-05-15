package com.epam.Vadym_Vlasenko.eShop.entity;

import java.util.Date;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public class User {
    private int id;
    private Image image;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private int age;
    private Role role;
    private Date lastLoginDate;
    private Date unblockedDate;
    private int loginFailAmount;

    public User() {
    }

    public User(String name, String surname, String login, String password, String email, int age, Role role, Image image) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.role = role;
        this.image = image;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getUnblockedDate() {
        return unblockedDate;
    }

    public void setUnblockedDate(Date unblockedDate) {
        this.unblockedDate = unblockedDate;
    }

    public int getLoginFailAmount() {
        return loginFailAmount;
    }

    public void setLoginFailAmount(int loginFailAmount) {
        this.loginFailAmount = loginFailAmount;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isBlocked() {
        System.out.println(unblockedDate.getTime() + " " + System.currentTimeMillis());
        return unblockedDate.getTime() > System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return !(role != null ? !role.equals(user.role) : user.role != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
