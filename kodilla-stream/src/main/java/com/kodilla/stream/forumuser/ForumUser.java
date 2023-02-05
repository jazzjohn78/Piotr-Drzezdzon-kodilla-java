package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String username;
    private final Character sex;
    private final LocalDate birthDate;
    private final int postsQuantity;

    public ForumUser(final int id, final String username, final Character sex, final LocalDate birthDate, final int postsQuantity) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsQuantity = postsQuantity;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Character getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsQuantity=" + postsQuantity +
                '}';
    }
}
