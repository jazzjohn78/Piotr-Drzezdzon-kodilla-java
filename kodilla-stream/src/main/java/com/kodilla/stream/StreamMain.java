package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {
        Forum theForum = new Forum();

        Map<Integer, ForumUser> resultMap = theForum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthDate().isBefore(LocalDate.of(LocalDate.now().getYear() - 20, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth() + 1)))
                .filter(user -> user.getPostsQuantity() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        System.out.println("# of results: " + resultMap.size());
        resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
