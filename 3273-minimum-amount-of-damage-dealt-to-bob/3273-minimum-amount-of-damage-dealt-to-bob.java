class Solution {
        record Enemy (int damage, int health, double ratio) {}

        public long minDamage(int power, int[] damage, int[] health)
        {
            PriorityQueue<Enemy> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b.ratio, a.ratio));

            long dmgPerSec = 0L;
            for (int i=0; i< health.length; i++)
            {
                dmgPerSec += damage[i];

                int secToKill = health[i] / power + (health[i] % power == 0 ? 0 : 1);

                double ratio = (double) damage[i] / secToKill;

                maxHeap.offer(new Enemy(damage[i], health[i], ratio));
            }

            long answer = 0L;
            while (maxHeap.size() > 0)
            {
                final Enemy enemy = maxHeap.poll();
                int secToKill = enemy.health / power + (enemy.health % power == 0 ? 0 : 1);

                answer += secToKill * dmgPerSec;
                dmgPerSec -= enemy.damage;
            }

            return answer;
        }
}