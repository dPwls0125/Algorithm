if __name__ == '__main__':
    weights = list(map(int, input().split()))
    values = list(map(int, input().split()))

    dp = [[0] * 101 for _ in range(8)]

    for i in range(1, 8):
        for w in range(1, 101):
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])

            else:
                dp[i][w] = dp[i - 1][w]

    print(dp[7][100])