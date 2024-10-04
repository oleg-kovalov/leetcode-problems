class Solution {
    public long dividePlayers(int[] skill) {
        int teamSkill = 0;
        for (int player : skill)
        {
            teamSkill += player;
        }
        teamSkill = teamSkill / (skill.length / 2);

        long chemistry = 0; 
        HashMap<Integer, Integer> unmatched = new HashMap<>();

        for (int player: skill)
        {
            int teamMate = teamSkill - player;
            if (unmatched.containsKey(teamMate))
            {
                unmatched.put(teamMate, unmatched.get(teamMate) - 1);
                if (unmatched.get(teamMate) == 0)
                {
                    unmatched.remove(teamMate);
                }

                chemistry += player * (teamSkill - player);
            }
            else {
                unmatched.put(player, unmatched.getOrDefault(player, 0) + 1);
            }
        }

        if (unmatched.size() > 0) return -1;

        return chemistry; 
    }
}