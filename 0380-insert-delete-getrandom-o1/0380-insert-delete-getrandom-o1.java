class RandomizedSet {
        HashMap<Integer, Integer> internalMap;
        ArrayList<Integer> internalArrayList;
        Random internalRandom;


        public RandomizedSet() {
            internalMap = new HashMap<>();
            internalArrayList = new ArrayList<>();
            internalRandom = new Random();
        }

        public boolean insert(int val) {
            if (internalMap.containsKey(val))
            {
                return false;
            }

            int currIndex = internalMap.size();
            internalMap.put(val, currIndex);
            internalArrayList.add(currIndex, val);

            return true;
        }

        public boolean remove(int val) {
            if (!internalMap.containsKey(val))
            {
                return false;
            }

            // swap value current <-> last, remove last
            int currIndex = internalMap.get(val);
            int lastIndex = internalMap.size()-1;
            
            if (lastIndex == currIndex) {
                //last element in the array - no need to swap
            } else {
                int lastValue = internalArrayList.get(lastIndex);
                internalArrayList.set(currIndex, lastValue);

                internalMap.put(lastValue, currIndex);
            }

            internalArrayList.remove(lastIndex);
            internalMap.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIndex = internalRandom.nextInt(internalMap.size());
            return internalArrayList.get(randomIndex);
        }
    }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */