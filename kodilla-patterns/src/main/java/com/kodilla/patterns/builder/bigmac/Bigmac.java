package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    public static final String SESAME = "SEZAME";
    public static final String NON_SESAME = "NON_SESAME";
    public static final int MIN_BURGERS = 1;
    public static final int MAX_BURGERS = 3;
    public static final String STANDARD = "STANDARD";
    public static final String THOUSAND_ISLAND = "THOUSAND_ISLAND";
    public static final String BARBECUE = "BARBECUE";
    public static final String LETTUCE = "LETTUCE";
    public static final String ONION = "ONION";
    public static final String BACON = "BACON";
    public static final String CUCUMBER = "CUCUMBER";
    public static final String CHILI_PEPPERS = "CHILI_PEPPERS";
    public static final String CHAMPIGNONES = "CHAMPIGNONES";
    public static final String SHRIMPS = "SHRIMPS";
    public static final String CHEESE = "CHEESE";

    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients;

    public static class BigmacBuilder {
        private String bun = "";
        private int burgers = 0;
        private String sauce = "";
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (bun == SESAME || bun == NON_SESAME) {
                this.bun = bun;
            } else {
                throw new IllegalStateException("Bun can either be SESAME or NON_SESAME");
            }
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers >= MIN_BURGERS && burgers < MAX_BURGERS) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("The number of burgers has to be between " + MIN_BURGERS + " and " + MAX_BURGERS);
            }
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (sauce == STANDARD || sauce == THOUSAND_ISLAND || sauce == BARBECUE) {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("The sauce needs to be STANDARD, THOUSAND_ISLAND or BARBECUE");
            }
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (ingredient == LETTUCE || ingredient == ONION || ingredient == BACON || ingredient == CUCUMBER || ingredient == CHILI_PEPPERS
                    || ingredient == CHAMPIGNONES || ingredient == SHRIMPS || ingredient == CHEESE) {
                ingredients.add(ingredient);
            } else {
                throw new IllegalStateException("Ingredient " + ingredient + " is not available");
            }
            return this;
        }

        public Bigmac build() {
            if (bun.length() == 0) {
                throw new IllegalStateException("You have to select a bun");
            }
            if (burgers == 0) {
                throw new IllegalStateException("Please add burgers first");
            }
            if (sauce.length() == 0) {
                throw new IllegalStateException("No sauce selected");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }

    }

    private Bigmac(final String bun, final int burgers, final String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", number of burgers = " + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
