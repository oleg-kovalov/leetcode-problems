class TimeMap {

    Map<String, List<Integer>> timestamps = new HashMap<>();
    Map<String, String> values = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        timestamps.putIfAbsent(key, new ArrayList<>());
        timestamps.get(key).add(timestamp);

        values.put(key + "_" +timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) return "";

        List<Integer> list = timestamps.get(key);
        int lo = 0;
        int hi = list.size() - 1;

        int result = -1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) <= timestamp)
            {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (result == -1) return "";

        return values.get(key + "_" + list.get(result));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */