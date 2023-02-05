package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "jazzjohn", 'M', LocalDate.of(1950, 1, 10), 15));
        theUserList.add(new ForumUser(2, "mike", 'M', LocalDate.of(2003, 2, 5), 1));
        theUserList.add(new ForumUser(3, "pi", 'M', LocalDate.of(1995, 4, 16), 0));
        theUserList.add(new ForumUser(4, "last", 'M', LocalDate.of(2013, 7, 23), 4));
        theUserList.add(new ForumUser(5, "daddy", 'M', LocalDate.of(2000, 1, 22), 35));
        theUserList.add(new ForumUser(6, "pinkie", 'F', LocalDate.of(1923, 12, 10), 7));
        theUserList.add(new ForumUser(7, "elsa", 'F', LocalDate.of(1977, 1, 1), 5));
        theUserList.add(new ForumUser(8, "cinderella", 'F', LocalDate.of(2011, 8, 8), 0));
        theUserList.add(new ForumUser(9, "barbie", 'F', LocalDate.of(2005, 7, 30), 10));
        theUserList.add(new ForumUser(10, "blondie", 'F', LocalDate.of(1999, 8, 4), 0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
