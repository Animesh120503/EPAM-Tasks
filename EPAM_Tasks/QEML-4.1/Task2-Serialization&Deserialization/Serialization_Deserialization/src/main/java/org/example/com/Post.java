package org.example.com;

public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;

    public Post(){}

    private Post(Builder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.title = builder.title;
        this.body = builder.body;
    }

    public int getId(){
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        private int id;
        private int userId;
        private String title;
        private String body;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Post build(){
            return new Post(this);
        }
    }
}
