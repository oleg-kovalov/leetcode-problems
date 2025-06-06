class FoodRatings {

        record FR (String food, int rating) {}

        private HashMap<String, TreeSet<FR>> cuisinesMap = new HashMap<>();
        private HashMap<String, String> foodToCuisine = new HashMap<>();
        private HashMap<String, FR> foodToFrMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i=0; i< foods.length; i++)
            {
                FR fr = new FR(foods[i], ratings[i]);
                foodToFrMap.put(fr.food(), fr);

                TreeSet<FR> cuisineSet = cuisinesMap.getOrDefault(cuisines[i],
                    new TreeSet<>(Comparator.comparing(FR::rating).reversed().thenComparing(FR::food)));
                cuisineSet.add(fr);
                cuisinesMap.put(cuisines[i], cuisineSet);

                foodToCuisine.put(foods[i], cuisines[i]);
            }

        }

        public void changeRating(String food, int newRating) {
            final FR fr = foodToFrMap.get(food);

            TreeSet<FR> frs = cuisinesMap.get(foodToCuisine.get(food));
            frs.remove(fr);

            FR newFR = new FR(food, newRating);
            frs.add(newFR);
            foodToFrMap.put(food, newFR);
        }

        public String highestRated(String cuisine) {
            return cuisinesMap.get(cuisine).first().food();
        }
    
    
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */