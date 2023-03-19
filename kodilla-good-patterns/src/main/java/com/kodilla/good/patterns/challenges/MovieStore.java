package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MovieStore {
    private final List<String> ironManTranslations;
    private final List<String> avengersTranslations;
    private final List<String> flashTranslations;
    private final Map<String, List<String>> booksTitlesWithTranslations;

    public MovieStore() {
        ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);
    }

    public Map<String, List<String>> getMovies() {
        return booksTitlesWithTranslations;
    }
}
