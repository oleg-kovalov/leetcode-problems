/**
 * @param {number[]} piles
 * @return {number}
 */
var stoneGameII = function(piles) {
    const n = piles.length;

    const suffix = new Array(n + 1);
    suffix[n] = 0;
    for (let i = n - 1; i >= 0; i--)
        suffix[i] = suffix[i + 1] + piles[i];

    let dp = new Array(n + 1);
    for (let i = 1; i <= n; i++)
        dp[i] = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++)
        dp[n][i] = suffix[i];

    for (let M = n - 1; M >= 1; M--) {
        for (let idx = n - 1; idx >= 0; idx--) {
            let sum = 0;
            let max = 0;
            for (let X = 1; X <= 2 * M && idx + X <= n; X++) {
                sum += piles[idx + X - 1];
                // max = Math.max(max, sum + suffix[idx + X] - dp[Math.min(Math.max(M, X), n)][idx + X]);
                max = Math.max(max, sum + suffix[idx + X] - dp[Math.max(M, X)][idx + X]);
            }
            dp[M][idx] = max;
        }
    }

    return dp[1][0];

    // T: O(n^3), S: O(n^2)
    // const n = piles.length;

    // const suffix = new Array(n + 1);
    // suffix[n] = 0;
    // for (let i = n - 1; i >= 0; i--)
    //     suffix[i] = suffix[i + 1] + piles[i];

    // const memo = new Array(n);
    // for (let i = 0; i < n; i++)
    //     memo[i] = {};

    // const dp = (idx, M) => {
    //     if (idx >= n) return 0;
    //     if (idx + M >= n) return suffix[idx];
    //     if (memo[idx][M] !== undefined)
    //         return memo[idx][M];
    //     let sum = 0;
    //     let max = 0;
    //     for (let X = 1; X <= 2 * M && idx + X <= n; X++) {
    //         sum += piles[idx + X - 1];
    //         max = Math.max(max, sum + suffix[idx + X] - dp(idx + X, Math.max(M, X)));
    //     }
    //     return memo[idx][M] = max;
    // };
    // return dp(0, 1);
};