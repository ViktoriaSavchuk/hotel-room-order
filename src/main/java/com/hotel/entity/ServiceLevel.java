package com.hotel.entity;

import java.util.Objects;

public class ServiceLevel extends Entity {

    private String classLevel;

    public ServiceLevel(Long id, String classLevel) {
        super(id);
        this.classLevel = classLevel;
    }

    public String getClassLevel() {
        return classLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceLevel that = (ServiceLevel) o;
        return Objects.equals(classLevel, that.classLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classLevel);
    }
}
