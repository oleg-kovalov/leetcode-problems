class TimeMap {

    Map<String, List<Integer>> keyToTimestamps;
    Map<Integer, String> timestampToValue;


    public TimeMap() {
        keyToTimestamps = new HashMap<>();
        timestampToValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyToTimestamps.putIfAbsent(key, new ArrayList<>());
        keyToTimestamps.get(key).add(timestamp);

        timestampToValue.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> list = keyToTimestamps.get(key);
        if (list == null || list.size() == 0) return "";
        
        int resultTimestamp = -1;

        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi)
        {
            int mid = (hi + lo) / 2;

            if (list.get(mid) <= timestamp)
            {
                resultTimestamp = list.get(mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (resultTimestamp == -1) return "";

        return timestampToValue.get(resultTimestamp);

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */