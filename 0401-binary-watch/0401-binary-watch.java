class Solution {

    int[] hours = new int[] {1, 2, 4, 8};
    int[] minutes = new int[] {1, 2, 4, 8, 16, 32};
    Set<String> result = new HashSet<>();

    public List<String> readBinaryWatch(int turnedOn) {
        // if (turnedOn > 8) return new ArrayList<>();

        for (int i=0; i<turnedOn + 1; i++)
        {
            backtrack(0, i, 0, 0, turnedOn - i, 0);
        }
        return new ArrayList<>(result);
    }

    private void backtrack (int hoursIdx, int hoursLed, int hoursTotal, int minutesIdx, int minutesLed, int minutesTotal)
    {
        if (hoursTotal > 11) return;
        if (minutesTotal > 59) return;

        if (hoursLed == 0 && minutesLed == 0)
        {
            String hoursStr = String.valueOf(hoursTotal);
            String minutesStr = (minutesTotal < 10 ? "0" : "" ) + String.valueOf(minutesTotal);
            result.add(hoursStr + ":"+ minutesStr);
            return;
        }
        

        if (hoursIdx < hours.length)
        {
            // skip current hours led
            backtrack(hoursIdx + 1, hoursLed, hoursTotal, minutesIdx, minutesLed, minutesTotal);

            // take current hours led
            backtrack(hoursIdx + 1, hoursLed - 1, hoursTotal + hours[hoursIdx], minutesIdx, minutesLed, minutesTotal);
        }


        if (minutesIdx < minutes.length)
        {
            // skip current minutes led
            backtrack(hoursIdx, hoursLed, hoursTotal, minutesIdx + 1, minutesLed, minutesTotal);

            // take current minutes led
            backtrack(hoursIdx, hoursLed, hoursTotal, minutesIdx + 1, minutesLed - 1, minutesTotal + minutes[minutesIdx]);

        }


    }

}

//