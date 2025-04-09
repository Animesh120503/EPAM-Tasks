package com.epam.api.models;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private Object id;
    private String name;
    private Double balance;
    private User user;

    BankAccount(){}

    private BankAccount(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.balance = builder.balance;
        this.user = builder.user;
    }

    // Getters
    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    // Builder Class
    public static class Builder {
        private Object id;
        private String name;
        private double balance;
        private User user;

        public Builder setId(Object id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }
}
