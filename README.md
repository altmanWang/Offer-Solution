# 剑指OFFER面试题编程练习

## 2.3数据结构
- 数组
- 字符串
- 链表
- 树
- 栈
### 2.3.1数组
数组，占据一块连续的内存并按照顺序存储数据。优于数组中的内存是连续的，于是可以根据下表在O(1)时间读写任何元素，因此它的时间效率很高。**可以利用数组与链表来组成哈希表（JDK1.8以前，HashMap采用数组+链表，JDK1.8采用了红黑树，当链表长度太长，链表转化为红黑树，利用红黑树快速增删查改的特点提高HashMap的性能）**。

#### 面试题3：数组中重复的数字
解题思路：
- 在可以改变原始数组的情况下，可以利用改变数组，使其按顺序排序，当发现num[i]==num[num[i]]时，则说明有重复数字。时间复杂度O(n),空间复杂度O(1)。(DuplicationInArray)
- 在不可以改变原始数组时，可以利用辅助数组。空间复杂度O(n),时间复杂度O(n)。
- 在不可以改变原始数组时，也可以利用二分查找的思想，将数值范围不断切分，并查找数值范围内数字出现的个数，当出现的个数大于数值范围时，则说明在该范围内存在重复数字。**但，这种方法无法保证找出所有重复的数字。例如在1~2范围内，2重复出现两次，1不出现，则计数等于2，并且不大于该范围，此时该算法不能确定每个数字出现的次数，所以不能保证找到所有重复的数字**。(DuplicationInArrayNoEdit)

#### 面试题4：二维数组中的查找
**题目**：在一个二维数组众，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


解题思路：**通过具体的例子找到其中的规律**。从一个具体的二维数组的右上角开始分析，就能找到查找的规律，从而解决问题的突破口。

### 2.3.2字符串


### 2.3.3链表
链表是一种动态数据结构，是因为在创建链表时，无须知道链表的长度。当插入一个节点时，我们只需要为新的节点分配内存，然后调整指针的指向来确保新节点被连接到链表中。内存分配不是在创建链表时一次性完成的，而是每添加一个节点分配一次内存。由于没有闲置的内存，链表的空间效率比数组高。




#### 面试题6：从尾到头打印链表
**题目**：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。

解题思路：利用栈，先进先出。先遍历整个链表，将链表值保存在栈中，再依次出栈打印即可。

### 2.3.4 树

在面试时，经常会问到二叉树。

树的遍历方式：
- 前序遍历：先访问根节点，再访问左子节点，最后访问右子节点。
- 中序遍历：先访问左子节点，再访问根节点，最后访问右子节点。
- 后续遍历：先访问左子节点，再访问右子节点，最后访问跟节点。

二叉树的两个特例：堆和红黑树。

- 堆分为最大堆和最小堆。在最大堆中根节点最大，在最小堆中根节点最小。有很多需要快速找到最大值和最小值的问题都可以用堆来解决。
- 红黑树是把树中的节点定义为红、黑两种颜色，并通过规则确保从根节点到叶子节点的最长路径的长度不超过最路径的两倍。

#### 面试题7：重建二叉树
**题目**：输入某二叉树的前序遍历和中序遍历的结果。请重建该二叉树。

解题思路：在二叉树的前序遍历中，第一数字总是树的根节点的值。但在中序遍历中，根节点的中再序列的中间。左子树位于其左边，右子树位于其右边。通过遍历前序，可以在中序中判断出哪一部分为左子树和右子树。从而通过递归，重建出二叉树。