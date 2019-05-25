package com.hotel.entity;

import java.util.Objects;

public class Role extends Entity {

    private String role;

    public Role(Long id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }

    @Override
    public String toString() {
        return "Role{" + role +' '+id +'}';
    }
}
