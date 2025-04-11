package com.epam.api.models;

import java.util.List;

public class Registration {
    private Object id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private boolean activated;
    private String langKey;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private List<Authorities> authorities; // Assuming authorities is a list of strings
    private String password;

    // Private constructor for Builder
    private Registration(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.imageUrl = builder.imageUrl;
        this.activated = builder.activated;
        this.langKey = builder.langKey;
        this.createdBy = builder.createdBy;
        this.createdDate = builder.createdDate;
        this.lastModifiedBy = builder.lastModifiedBy;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.authorities = builder.authorities;
        this.password = builder.password;
    }

    public Object getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private Object id;
        private String login;
        private String firstName;
        private String lastName;
        private String email;
        private String imageUrl;
        private boolean activated;
        private String langKey;
        private String createdBy;
        private String createdDate;
        private String lastModifiedBy;
        private String lastModifiedDate;
        private List<Authorities> authorities;
        private String password;

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

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
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

        public Builder setAuthorities(List<Authorities> authorities) {
            this.authorities = authorities;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Registration build() {
            return new Registration(this);
        }
    }
}
