package com.hotel.entity;

import java.util.Objects;

public class Room extends Entity {

    private Integer numberOfPlaces;
    private ServiceLevel serviceLevel;
    private Long price;

    public Room(Builder builder) {
        super(builder.id);
        this.numberOfPlaces = builder.numberOfPlaces;
        this.serviceLevel = builder.serviceLevel;
        this.price = builder.price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public Long getPrice() {
        return price;
    }


    public static class Builder {
        private Long id;
        private Integer numberOfPlaces;
        private ServiceLevel serviceLevel;
        private Long price;

        public Builder(Long id, Integer numberOfPlaces, ServiceLevel serviceLevel, Long price) {
            this.id = id;
            this.numberOfPlaces = numberOfPlaces;
            this.serviceLevel = serviceLevel;
            this.price = price;
        }

        public Builder() {
        }

        public Room build() {
            return new Room(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withNumberOfPlaces(Integer numberOfPlaces) {
            this.numberOfPlaces = numberOfPlaces;
            return this;
        }

        public Builder withServiceLevel(ServiceLevel serviceLevel) {
            this.serviceLevel = serviceLevel;
            return this;
        }

        public Builder withPrice(Long price) {
            this.price = price;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(numberOfPlaces, room.numberOfPlaces) &&
                Objects.equals(serviceLevel, room.serviceLevel) &&
                Objects.equals(price, room.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPlaces, serviceLevel, price);
    }
}
