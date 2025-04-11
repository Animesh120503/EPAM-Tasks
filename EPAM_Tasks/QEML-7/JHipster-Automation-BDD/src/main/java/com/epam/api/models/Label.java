package com.epam.api.models;

public class Label {
    private Object id;
    private String label;

    private Label(Builder builder){
        this.id = builder.id;
        this.label = builder.label;
    }

    public Object getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static class Builder{
        private Object id;
        private String label;

        public Builder setId(Object id) {
            this.id = id;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Label build(){
            return new Label(this);
        }
    }
}
