package com.epam.api.models;

import java.util.List;

public class Operation {
    private Object id;
    private String date;
    private String description;
    private Double amount;
    private BankAccount bankAccount;
    private List<Label> labels;

    private Operation(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.description = builder.description;
        this.amount = builder.amount;
        this.bankAccount = builder.bankAccount;
        this.labels = builder.labels;
    }

    public Object getId() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public Double getAmount() {
        return amount;
    }
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public List<Label> getLabels() {
        return labels;
    }

    public static class Builder {
        private Object id;
//        private LocalDateTime date;
        private String date;
        private String description;
        private Double amount;
        private BankAccount bankAccount;
        private List<Label> labels;

        public Builder setId(Object id) {
            this.id = id;
            return this;
        }

        public Builder setDate(String localDateTime) {
            this.date = localDateTime;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setBankAccount(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder setLabels(List<Label> labels) {
            this.labels = labels;
            return this;
        }

        public Operation build() {
            return new Operation(this);
        }
    }
}
