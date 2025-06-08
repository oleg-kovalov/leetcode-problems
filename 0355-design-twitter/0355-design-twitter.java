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

        PriorityQueue<Integer> mergedMinHeap = new PriorityQueue<>((a,b) -> 
            Integer.compare(tweetTimestamps.get(a),tweetTimestamps.get(b)));
        
        for (int followee: followers.get(userId))
        {
            PriorityQueue<Integer> feed = tweets.get(followee);
            for (Object tweet: tweets.get(followee).toArray())
            {
                mergedMinHeap.offer((int) tweet);
                if (mergedMinHeap.size() > 10) mergedMinHeap.poll();
            }
        }

        List<Integer> result = Arrays.asList(mergedMinHeap.toArray(new Integer[mergedMinHeap.size()]));
        Collections.sort(result, (a,b) -> Integer.compare(tweetTimestamps.get(b),tweetTimestamps.get(a)));

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