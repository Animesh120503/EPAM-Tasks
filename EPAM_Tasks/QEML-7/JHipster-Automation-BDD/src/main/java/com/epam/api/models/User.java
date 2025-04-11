package com.epam.api.models;

public class User {
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private Object id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private String imageUrl;
    private String resetDate;
    private Authorities[] authorities;

    private User(Builder builder) {
        this.createdBy = builder.createdBy;
        this.createdDate = builder.createdDate;
        this.lastModifiedBy = builder.lastModifiedBy;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.id = builder.id;
        this.login = builder.login;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.activated = builder.activated;
        this.langKey = builder.langKey;
        this.imageUrl = builder.imageUrl;
        this.resetDate = builder.resetDate;
        this.authorities = builder.authorities;
    }

    public String getCreatedBy() { return createdBy; }
    public String getCreatedDate() { return createdDate; }
    public String getLastModifiedBy() { return lastModifiedBy; }
    public String getLastModifiedDate() { return lastModifiedDate; }
    public Object getId() { return id; }
    public String getLogin() { return login; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public boolean isActivated() { return activated; }
    public String getLangKey() { return langKey; }
    public String getImageUrl() { return imageUrl; }
    public String getResetDate() { return resetDate; }
    public Authorities[] getAuthorities() { return authorities; }

    public static class Builder {
        private String createdBy;
        private String createdDate;
        private String lastModifiedBy;
        private String lastModifiedDate;
        private Object id;
        private String login;
        private String firstName = null;
        private String lastName = null;
        private String email = null;
        private boolean activated;
        private String langKey;
        private String imageUrl = null;
        private String resetDate;
        private Authorities[] authorities;

        public Builder setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }
        public Builder setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }
        public Builder setLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }
        public Builder setLastModifiedDate(String lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }
        public Builder setId(Object id) {
            this.id = id;
            return this;
        }
        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setActivated(boolean activated) {
            this.activated = activated;
            return this;
        }
        public Builder setLangKey(String langKey) {
            this.langKey = langKey;
            return this;
        }
        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }
        public Builder setResetDate(String resetDate) {
            this.resetDate = resetDate;
            return this;
        }
        public Builder setAuthorities(Authorities[] authorities){
            this.authorities = authorities;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}