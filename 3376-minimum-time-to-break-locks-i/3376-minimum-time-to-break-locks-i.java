class Solution {
    int k;
    public int findMinimumTime(List<Integer> strength, int K) {
        Collections.sort(strength);
        this.k = K;

        return backtrack( strength, strength.get(0), strength.get(0), 1);
    }

    private int backtrack(List<Integer> strength, int time, int energy, int factor)
    {
        if (strength.size() == 0) return time;

        // largest lock breakable by now
        int lockId = -1;
        while (lockId + 1 < strength.size() && energy >= strength.get(lockId + 1))
        {
            lockId += 1;
        }

        // break lock
        final List<Integer> newStrength = new ArrayList<>(strength);
        newStrength.remove(lockId);
        if (newStrength.size() == 0) return time;
        int newFactor = factor + k;
        int newTime = time + (int) Math.ceil((double)newStrength.get(0) / newFactor);
        int newEnergy = newFactor * (newTime - time);

        int breakLock = backtrack(newStrength, newTime, newEnergy, newFactor);


        //wait
        int wait;
        if (lockId == strength.size() - 1)
        {
            wait = 1000_000_000;
        } else {
            newTime = time + (int) Math.ceil((double)(strength.get(lockId + 1) - energy) / factor);
            newEnergy = energy + (newTime - time) * factor;
            wait = backtrack(strength, newTime, newEnergy, factor);
        }

        return Math.min(wait, breakLock);
    }
}