package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieIterationRunner {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String moviesTitles = movieStore.getMovies().entrySet().stream()
                .flatMap(list -> list.getValue().stream())
                .collect(Collectors.joining(","));

        System.out.println(moviesTitles);
    }
}
