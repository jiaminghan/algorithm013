# 位运算
## 算数移位、逻辑移位
	<< 左移一位
	>> 右移一位，空出来的最高位按照之前的最高位补全
	>>>右移一位，空出来的最高位补0
## 位运算
	& 按位与
	| 按位或
	~ 按位取反
	^ 按位异或
## 常用按位异或操作
	x^0 = x
	x^1s = ~x
	x^(~x) = 1s
	x^x = 0
	c = a ^ b => a ^ c = b, b ^ c = a 交换两个数
	a ^ b ^ c = a ^ (b ^ c)  = (a ^ b) ^ c  结合律
## 指定位置的位运算
	低n位置为0：x & (~0 << n)
	取第n位的值：(x >> n) & 1
	取第n位对应的幂值：x & (1 << n)
	第n位置为1：x | (1 << n)
	第n位置为0：x & (~(1 << n))
	最高位到第n位置为0：x & ((1 << n) - 1)
## 实战位运算要点
### 判断奇偶：
	x % 2 == 0 => (x & 1) == 0 偶
	x % 2 == 1 => (x & 1) == 1 奇
### 移位实现除法：
	x / 2 => x >> 2
### 清零最低位的1：
	& (x - 1)
### 得到最低位的1：
	x & (-x) 
		
# 布隆过滤器
## 布隆过滤器特点
	HashTable不仅能够查询元素是否存在，还能查询额外的信息，因为存储信息比较多。
	布隆过滤器只能判断元素是否一定不存在。
## 布隆过滤器实现方式：
	二进制向量 + 随机映射函数
	每个元素都通过随机映射函数对应到二进制向量的若干位中，添加元素时将其对应的若干二进制位置为1。
	所以在查询时，若相应的二进制位存在0，则该元素肯定不存在；若全为1，则可能存在。即相应的若干二进制位全为1，是元素存在的，必要不充分条件。
		
## 布隆过滤器优点：
	空间效率和查询时间远远超过一般的算法。
## 布隆过滤器缺点：
	有误识别的情况；
	删除元素十分困难
	
		
# LRU(Least recently used) Cache —— 最近最少使用缓存
## 两个要素
	大小
	换策略LRU, LFU(Least Frquently used)
## 实现方式一：
	Hash Table + Double LinkedList
## 时间复杂度：
	查询：O(1)
	修改、更新：O(1)
	
# 排序
## 排序算法分类
### 比较类排序
	通过比较大小来排序，时间复杂度最低为NlogN，因此也称为非线性比较排序
### 非比较类排序
	一般对于整形数据，可以达到线性时间复杂度，因此也成为线性时间非比较类排序
## 初级排序
### 选择排序：
	每次选择剩余元素中最小的一个，放到前面
### 冒泡排序
	两层循环，内层循环交换两个逆序对，每次循环可以使得最大（或最小）元素移到其最终位置
### 插入排序
	前部分为排序好的元素，后面的元素依次插入到其中（比该元素大的元素后移）
	
## 高级排序
### 快速排序：
	选中一个元素，将小于该元素的放到其左边，大于该元素的放到其右边
	对其左部分和右部分递归执行快速排序
	关键在于partion方法
### 归并排序：
	将待排序的序列分为两部分，分别排序，然后再合并到一起
	合并操作是关键
### 堆排序：
	将元素依次插入小顶堆（或者大顶堆）中
	然后再依次取出，放到最终位置

## 特殊排序
### 计数排序
#### 实现方式        
	遍历一次待排序的整数数组，将每个元素出现的个数放到指定数组角标的位置
	然后根据每个整数出现的次数，依次填充到原来的数组中
#### 优点
	时间复杂度为O(n)
#### 缺点
	只能对整数进行排序，并且整数所在的范围不能太大，否则会导致辅助数组过大。
### 桶排序
#### 实现方式
	将数据（假设符合均匀分布）据分散到多个桶里面（通过映射函数，该函数决定算法是否高效）
	对每个桶分别排序
	将所有桶中的元素合并到一起
### 基数排序
#### 实现方式
	按照所有位依次排序（从低位到高位），即先按照个位排序，然后按照十位排序，百位，千位。。。
	将各个桶的元素集合到一起
#### 缺点
	只能对整数进行排序
	
	
	
	
	
	