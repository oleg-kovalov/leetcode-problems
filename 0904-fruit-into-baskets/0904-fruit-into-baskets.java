class Solution {
    public int totalFruit(int[] fruits) {  // 0 1 2 2
        Map<Integer, Integer> picked = new HashMap<>(); // 1->1 2->2
        
        int left = 0; // 1
        int size = 1; // 4

        int result = 1; // 3


        while (left + size - 1 < fruits.length)
        {
            int fruit = fruits[left + size - 1];
            picked.put(fruit, picked.getOrDefault(fruit, 0) + 1);
            
            if (picked.size() > 2)
            {
                int fruitToRemove = fruits[left];
                if (picked.get(fruitToRemove) == 1) {
                    picked.remove(fruitToRemove);
                } else {
                    picked.put(fruitToRemove, picked.get(fruitToRemove) - 1);
                }

                left += 1;
            } else {
                result = size;
                size += 1;
            }

        }

        return result;
    }
}