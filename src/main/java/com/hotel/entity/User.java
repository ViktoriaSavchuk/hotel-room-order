package com.hotel.entity;

import java.util.Objects;

public class User extends Entity {

    private Role role;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;

    public User(Builder builder) {
        super(builder.id);
        this.role = builder.role;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.phone = builder.phone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Role role;
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phone;

        public Builder(Long id, Role role, String name, String surname,
                       String email, String password, String phone) {
            this.id = id;
            this.role = role;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = password;
            this.phone = phone;
        }

        public Builder() {
        }

        public User build() {
            return new User(this);
        }


        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(role, user.role) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, name, surname, email, password, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\'' +
                ", role=" + role + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }
}
