class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i=0; i<timePoints.size(); i++)
        {
            String[] hoursMinutes = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(hoursMinutes[0]) * 60 + Integer.parseInt(hoursMinutes[1]);
        }
        Arrays.sort(minutes);

        int diff = Integer.MAX_VALUE;
        for (int i=1; i<minutes.length; i++)
        {
            diff = Math.min(diff, minutes[i] - minutes[i-1]);
        }

        diff = Math.min(diff, 1440 + minutes[0] - minutes[minutes.length-1]);

        return diff;
    }
}