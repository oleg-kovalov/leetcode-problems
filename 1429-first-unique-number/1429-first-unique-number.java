class FirstUnique {

    LinkedHashSet<Integer> unique = new LinkedHashSet<>();
    HashSet<Integer> nonUnique = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        if (unique.size() == 0)
        {
            return -1;
        } else {
            return unique.iterator().next();
        }
    }

    public void add(int value) {
        if (!nonUnique.contains(value)) {
            if (!unique.contains(value)) {
                unique.add(value);
            } else {
                unique.remove(value);
                nonUnique.add(value);
            }
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */