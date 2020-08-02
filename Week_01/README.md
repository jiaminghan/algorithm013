本周学习了第三课和第四课，分别总结如下：
第三课：
	除了之前已经掌握的数组和链表的时间复杂度外，了解了新的数据结构——跳表，该数据结构用于有序数据，是对链表查找功能的优化使得查找时间复杂度从O(N)将为O(log2N)，但是维护多级索引也增加了插入元素的时间复杂度
	双指针法：
		1）快慢指针：可以用于判断链表是否有环、链表倒数第K个元素、排序数组去重复、数组中0元素后移等
		2）左右指针：用于排序数组夹逼，以降低时间复杂度，例如3Sum题目、盛水最多的容器
	找最近重复子问题：
		一般问题都有重复性，可以通过循环、递归、动态规划、分治、回溯等方式解题
	链表问题：
		主要是移动next、pre的指针，需要多练习。
第四课：
	栈：
		用来解决最近相关行问题，入“有效的括号”、“柱状图中最大矩形”等问题
	队列：
		用于解决先进先出的问题
	一般不直接使用栈或者队列，而是使用更强大的双端队列。
刷题方法论：
	五毒神掌：
		1)5~10min读题，
		2)有思路的话开始解题，无思路的话直接看题解
		3)理解、记忆、掌握优质题解
		4)闭卷情况下实现优质题解
		5)解完并不是结束，还需要多次重复解题，阅读优质题解
	空间换时间：
		提高空间复杂度可以增加信息维度，从而降低时间复杂度