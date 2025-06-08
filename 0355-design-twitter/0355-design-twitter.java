class Twitter {
    int timestamp = 0;

    HashMap<Integer, Integer> tweetTimestamps = new HashMap<>();
    HashMap<Integer, Set<Integer>> followers = new HashMap<>();
    HashMap<Integer, PriorityQueue<Integer>> tweets = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        registerUserIfNeeded(userId);
        
        tweetTimestamps.put(tweetId, timestamp);
        timestamp += 1;
        
        PriorityQueue<Integer> minHeap = tweets.get(userId);
        minHeap.offer(tweetId);
        if (minHeap.size() > 10) 
            minHeap.poll();
    }
    
    public List<Integer> getNewsFeed(int userId) {
        registerUserIfNeeded(userId);

        Set<Integer> merged = new TreeSet<>((a,b) -> Integer.compare(tweetTimestamps.get(b),tweetTimestamps.get(a)));
        for (int followee: followers.get(userId))
        {
            PriorityQueue<Integer> feed = tweets.get(followee);
            merged.addAll(Arrays.asList(feed.toArray(new Integer[feed.size()])));    
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = merged.iterator();
        while (result.size() < 10 && iterator.hasNext())
        {
            result.add(iterator.next());
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        registerUserIfNeeded(followerId);
        registerUserIfNeeded(followeeId);
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }

    private void registerUserIfNeeded(int userId)
    {
        tweets.putIfAbsent(userId, new PriorityQueue<>((a,b) -> 
            Integer.compare(tweetTimestamps.get(a), tweetTimestamps.get(b))));

        followers.putIfAbsent(userId, new HashSet<>());
        followers.get(userId).add(userId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */