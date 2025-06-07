class FoodRatings {

    private record FR (String food, int rating) {} ;

    HashMap<String, Integer> foodRating = new HashMap<>();
    HashMap<String, String> foodCuisine = new HashMap<>();
    HashMap<String, PriorityQueue<FR>> cuisineRated = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i=0; i<foods.length; i++)
        {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodCuisine.put(food, cuisine);
            foodRating.put(food, rating);
            
            cuisineRated.putIfAbsent(cuisine, new PriorityQueue<>((a,b) -> {
                return (a.rating != b.rating)  
                    ? Integer.compare(b.rating, a.rating)
                    : a.food.compareTo(b.food);
            }));

            cuisineRated.get(cuisine).add(new FR(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);
        cuisineRated.get(cuisine).offer(new FR(food, newRating));

    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<FR> maxHeap = cuisineRated.get(cuisine);
        while (maxHeap.size() > 0)
        {
            FR fr = maxHeap.peek();
            // check if rating is not stale
            if (fr.rating != foodRating.get(fr.food)) {
                maxHeap.poll();
            } else {
                return fr.food;
            }
        }

        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */



 //   cuisine -> [food,rating]
 //   food - cuisine
 //   food - rating