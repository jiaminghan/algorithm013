第九课 深度优先和广度优先搜索
	搜索（暴力搜索、非智能搜索）和遍历所有的点（访问且只访问一次），深度优先、广度优先、优先级优先等等。
		1）	深度优先：递归或者辅助栈方法。
		2）	广度优先：层序遍历，使用队列实现
	实战：
		1）	二叉树层序遍历：最直观的就是广度优先搜索，另外就是深度优先搜索（执行过程中记录当前节点所在的层数）
		2）	最小基因变化：广度优先搜索。
		3）	括号生成：深度优先，广度优先应该也可以。
		4）	岛屿数量：深度优先搜索将为1的元素设置为0
第十课 贪心算法
	定义：每一步都选择当前最优解，以期望达到全局最优解。
	特点：
		1）	如果可以用贪心算法解决，那么一般是最好的办法。高效、所得结果接近最优结果，可以用于辅助计算或者直接解决一些要求不高的问题。
		2）	可以分解为子问题，并且子问题的最优解能递推到整个问题的最优解（这种子问题成为最优子结构）。
	应用场景：一些优化问题，图的最小生成树、霍夫曼编码等。
	实战题目：
		1）	分发饼干：排序后从前往后贪心，使得每个饼干利用率达到最大。
		2）	最佳买卖股票的时机：只要后一天价格比今天高，就可以得到价格差的利润。
		3）	跳跃游戏：从后往前贪心，也可以递归等方法。
	难点：如何证明可以引用贪心法，将问题转换后再进行贪心（例如从后往前贪心）。
第十一课 二分查找：
	三个前提：单调性、有上下界、能够通过索引访问元素（普通链表就不行）。
	原理：夹逼，每次减少1/2的元素。
	实战题目：
		1）	X的平方根：二分查找（单调递增、有上下界、索引及其对应的值相同）、牛顿迭代法。
		2）	搜索旋转排序数组：还原（可以达到logN的时间复杂度）后再二分查找；直接二分查找（不仅仅比较mid元素和target）。

