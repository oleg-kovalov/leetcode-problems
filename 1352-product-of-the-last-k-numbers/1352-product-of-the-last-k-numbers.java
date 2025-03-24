class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0)
        {
            for (int i=0; i<list.size(); i++)
            {
                list.set(i, 0);
            }
            list.add(num); 
            return;
        }

        if (list.size() > 0 && list.get(list.size() - 1) == 0)
        {
            list.add(num);
            return;
        }

        if (num == 1)
        {
            list.add(num);
            return;
        }

        for (int i=list.size()-1; i>=0; i--)
        {
            int oldValue = list.get(i);
            if (oldValue == 0) break;

            list.set(i, oldValue * num);
        }
        list.add(num);
    }
    
    public int getProduct(int k) {
        return list.get(list.size() - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */