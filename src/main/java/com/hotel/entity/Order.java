package com.hotel.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order extends Entity {

    private User user;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private ServiceLevel serviceLevel;
    private Room room;
    private LocalDateTime orderTime;
    private Integer numberOfPlaces;

    public Order(Builder builder) {
        super(builder.id);
        this.user = builder.user;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.serviceLevel = builder.serviceLevel;
        this.room = builder.room;
        this.orderTime = builder.orderTime;
        this.numberOfPlaces =builder.numberOfPlaces;
    }

    public Order() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public static class Builder {
        private Long id;
        private User user;
        private LocalDateTime checkIn;
        private LocalDateTime checkOut;
        private ServiceLevel serviceLevel;
        private Room room;
        private LocalDateTime orderTime;
        private Integer numberOfPlaces;

        public Builder() {
        }

        public Builder(Long id, User user, LocalDateTime checkIn, LocalDateTime checkOut,
                       ServiceLevel serviceLevel, Room room, LocalDateTime orderTime, Integer numberOfPlaces) {
            this.id = id;
            this.user = user;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.serviceLevel = serviceLevel;
            this.room = room;
            this.orderTime = orderTime;
            this.numberOfPlaces=numberOfPlaces;
        }

        public Order build() {
            return new Order(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withUser(User user) {
            this.user = user;
            return this;
        }

        public Builder withCheckIn(LocalDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public Builder withCheckOut(LocalDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Builder withServiceLevel(ServiceLevel serviceLevel) {
            this.serviceLevel = serviceLevel;
            return this;
        }

        public Builder withRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder withOrderTime(LocalDateTime orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        public Builder withNumberOfPlaces(Integer numberOfPlaces) {
            this.numberOfPlaces = numberOfPlaces;
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
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(user, order.user) &&
                Objects.equals(checkIn, order.checkIn) &&
                Objects.equals(checkOut, order.checkOut) &&
                Objects.equals(serviceLevel, order.serviceLevel) &&
                Objects.equals(room, order.room) &&
                Objects.equals(numberOfPlaces, order.numberOfPlaces) &&
                Objects.equals(orderTime, order.orderTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, checkIn, checkOut, serviceLevel, room, orderTime, numberOfPlaces);
    }
}


