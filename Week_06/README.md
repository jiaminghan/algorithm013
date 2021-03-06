# 递归、分治、回溯、动态规划之间的异同：
## 四者之间没有明确的界限，共性在于寻找重复子问题。
## 动态规划相较于前三者的区别在于，动态规划存在最优子问题，所以不用遍历所有的情况，只用处理最优子问题，相当于解空间缩小了，所以时间复杂度优于前三者。


# 动态规划思想：
## 1）查找重复性
## 2）状态数组定义
## 3）DP方程（递推方程）


# 对于初级问题，难点在于“状态数组”,“状态数组”确定后，问题基本就解决了
## 斐波那契数列：状态数组就是数值组成的序列
## 不同路径 & 不同路径II ：状态数组为二维数组，dp[i][j]为i，j位置到达右下角的路径总数
## 最大子序和：状态数组就是一维数组(DP方程：dp[i] = max(dp[i - 1], 0) + nums[i])
## 乘积最大子数组：与“最大自序和”类似，不同的是该问题需要保存最大值和最小值（因为对于乘运算有“负负得正”的性质）

# 对于高级别的问题，难点在于“DP方程”
## 最长公共子序列：需要将其转换为二维数组dp[i][j] = dp[i-1][j-1] + 1或者dp[i][j] = max(dp[i-1][j],dp[i][j-1]
## 零钱兑换：状态数组为一维数组，分别为兑换1,2...amount元的最少兑换硬币个数 dp[i] = min(dp[i-coin] for all coin in coins) + 1