# 剑指OFFER与Leetcode编程练习
前半部分为剑指offer练习题，后半部分为leetcode编程联系。
## 2.3数据结构
- 数组
- 字符串
- 链表
- 树
- 栈
### 2.3.1数组
数组，占据一块连续的内存并按照顺序存储数据。优于数组中的内存是连续的，于是可以根据下表在O(1)时间读写任何元素，因此它的时间效率很高。**可以利用数组与链表来组成哈希表（JDK1.8以前，HashMap采用数组+链表，JDK1.8采用了红黑树，当链表长度太长，链表转化为红黑树，利用红黑树快速增删查改的特点提高HashMap的性能）**。

##### 面试题3：数组中重复的数字
解题思路：
- 在可以改变原始数组的情况下，可以利用改变数组，使其按顺序排序，当发现num[i]==num[num[i]]时，则说明有重复数字。时间复杂度O(n),空间复杂度O(1)。(DuplicationInArray)
- 在不可以改变原始数组时，可以利用辅助数组。空间复杂度O(n),时间复杂度O(n)。
- 在不可以改变原始数组时，也可以利用二分查找的思想，将数值范围不断切分，并查找数值范围内数字出现的个数，当出现的个数大于数值范围时，则说明在该范围内存在重复数字。**但，这种方法无法保证找出所有重复的数字。例如在1~2范围内，2重复出现两次，1不出现，则计数等于2，并且不大于该范围，此时该算法不能确定每个数字出现的次数，所以不能保证找到所有重复的数字**。(DuplicationInArrayNoEdit)
- 

##### 448. Find All Numbers Disappeared in an Array
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

解题思路：这道题与剑指offer中的面试3类似。这道题需要找不存在的数字。那么我可以让已有的数字在其应在的位置。即nums[i]==nums[nums[i]-1]，如果不存在则一直交换。
```python
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lists = new LinkedList<Integer>();
        if(nums == null || nums.length == 0)
            return lists;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i]-1]){
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp-1] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i+1 != nums[i])
                lists.add(i+1);
        }
        return lists;
    }
}
```

##### 442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

解题思路：与leetcode 448类似。首先将数字放到其下标对应的位置，即nums[i]==nums[nums[i]-1]，如果不存在则一直交换。
```python
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lists = new LinkedList<Integer>();
        if(nums == null || nums.length == 0)
            return lists;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i]-1]){
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp-1] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i+1 != nums[i])
                lists.add(nums[i]);
        }
        return lists;
    }
}
```



##### 面试题4：二维数组中的查找
**题目**：在一个二维数组众，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


解题思路：**通过具体的例子找到其中的规律**。从一个具体的二维数组的右上角开始分析，就能找到查找的规律，从而解决问题的突破口。

### 2.3.2字符串


### 2.3.3链表
链表是一种动态数据结构，是因为在创建链表时，无须知道链表的长度。当插入一个节点时，我们只需要为新的节点分配内存，然后调整指针的指向来确保新节点被连接到链表中。内存分配不是在创建链表时一次性完成的，而是每添加一个节点分配一次内存。由于没有闲置的内存，链表的空间效率比数组高。




##### 面试题6：从尾到头打印链表
**题目**：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。

解题思路：利用栈，先进先出。先遍历整个链表，将链表值保存在栈中，再依次出栈打印即可。

### 2.3.4 树(主要用递归的方式解决问题)

在面试时，经常会问到二叉树。

树的遍历方式：
- 前序遍历：先访问根节点，再访问左子节点，最后访问右子节点。
```python
def preOrder(root):
    if root is None:
        return
    //operation on root
    preOrder(root.left)
    preOrder(root.right)
    
 ```

- 中序遍历：先访问左子节点，再访问根节点，最后访问右子节点。
```python
def inOrder(root):
    if root is None:
        return
    inOrder(root.left)
    //operation on root
    inOrder(root.right)
    
 ``` 

- 后序遍历：先访问左子节点，再访问右子节点，最后访问跟节点。
```python
def postOrder(root):
    if root is None:
        return
    postOrder(root.left)
    postOrder(root.right)
    //operation on root
    
 ``` 

二叉树的两个特例：堆和红黑树。

- 堆分为最大堆和最小堆。在最大堆中根节点最大，在最小堆中根节点最小。有很多需要快速找到最大值和最小值的问题都可以用堆来解决。
- 红黑树是把树中的节点定义为红、黑两种颜色，并通过规则确保从根节点到叶子节点的最长路径的长度不超过最路径的两倍。

##### 面试题7：重建二叉树 （105. Construct Binary Tree from Preorder and Inorder Traversal）
**题目**：输入某二叉树的前序遍历和中序遍历的结果。请重建该二叉树。

解题思路：在二叉树的前序遍历中，第一数字总是树的根节点的值。但在中序遍历中，根节点的在中序遍历中的中间。左子树位于其左边，右子树位于其右边。通过遍历前序，可以在中序遍历中判断出哪一部分为左子树和右子树。计算左子树与右子树的个数，通过个数设置前序遍历与中序遍历的上下界。从而通过递归，重建出二叉树。


```python
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        int length = preorder.length;
        return buildTree(preorder, 0, length-1, inorder, 0, length-1);
    }
    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart > pEnd || iStart > iEnd)
            return null;
        int val = preorder[pStart];
        int index;
        for(index = iStart; index <= iEnd; index++){
            if(inorder[index] == val)
                break;
        }
        TreeNode node = new TreeNode(val);
        int nums = index - iStart;
        
        node.left = buildTree(preorder, pStart+1, pStart+nums, inorder, iStart, iStart+nums-1);
        node.right = buildTree(preorder, pStart+nums+1, pEnd, inorder, iStart+nums+1, iEnd);
        
        return node;
    }
}
 ``` 

#### 面试题8：二叉树的下一个节点
**题目**：给定一棵二叉树和其中的节点，如何找出中序遍历的下一个节点？树中的节点除了两个分别指向左和右子节点的指针，还有一个指向父节点的指针。

解题思路：注重前序遍历、中序遍历和后序遍历！！！从中找规律，即可解题。


### 2.3.5 栈和队列

- 栈：先进后出
- 队列：先进先出

#### 面试题9：用两个栈实现队列
**题目**：用两个栈实现一个队列。即实现，在队尾添加元素和删除队列第一个元素。

解题思路：给定两个stack，分别是stack1和stack2. 用stack1来存储输入元素，当要删除第一个元素时，先判断stack2是否为空，为空则将stack1的元素按顺序pop出来并压如stack2（c->b->a变成了a->b->c），然后将stack2的最后一个元素删除；若不为空，则直接将stack2的最后一个元素删除即可。

## 2.4算法和数据操作

重点：
- 排序和查找：二分查找、归并排序和快速排序。
- 二维数组，可以尝试回溯法（用递归实现）。
- 求某个问题的最优解，可以尝试使用动态规划。（进一步提问，可能需要用贪婪算法求最优解）
- 位运算

### 2.4.1 递归与循环

- 递归是一个函数的内部调用这个函数自身。
- 循环则是通过设置计算的初始值及终止条件，在一个范围内重复计算。

递归缺点：调用函数是有时间和空间的消耗（每一次函数调用，要在内存栈中分配空间以保存参数、返回变量及临时变量）

#### 面试题10：斐波那契数列
**题目一**：求斐波那切数列的第n项。

解题思路：这道题用递归效率低。因为在计算数列时，有很多重复的数据。
采用循环，每一次循环保存中间项，方便下一次计算。f(n)=f(n-1)+f(n-2)

**题目二**：青蛙跳台阶问题，一只青蛙可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法。
解题思路：类似。当n>2时，第一跳有两种选择：第一种是跳1级台阶，此时跳法数目等于后面剩下的n-1级台阶的跳法数目；第二种是跳2级台阶，此时跳法数目等于后面剩下的n-2级台阶的跳法数目。f(n)=f(n-1)+f(n-2)

**746. Min Cost Climbing Stairs** （动态规划）

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

解题思路：f(t) = min(f(t-1)+cost[t],f(t-2)+cost[t])

```python
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)
            return 0;
        if(cost.length == 1)
            return cost[0];
        if(cost.length == 2)
            return cost[0] > cost[1] ? cost[1] : cost[0];
        int n = cost.length;
        int[] total_cost = new int[n];
        total_cost[0] = cost[0];
        total_cost[1] = cost[1];
        for(int i = 2; i < n; i++){
            total_cost[i] = cost[i] + (total_cost[i-1] > total_cost[i-2] ? total_cost[i-2] : total_cost[i-1]);
        }
        return total_cost[n-1] > total_cost[n-2] ? total_cost[n-2] : total_cost[n-1];
    }
}
 ```



**题目三**：覆盖矩阵，我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
当第一次覆盖2*1的小矩阵（竖着放），则后面的覆盖方法为f(n-1);
当第一次覆盖2*2的小矩阵（两个横着放），对应下方的2*(n-2)的小矩阵摆放必然是确定的，所以后面的覆盖方法为f(n-2)。
所以总的覆盖方法为：f(n) = f(n-1) + f(n-2); 依旧是斐波那契数列的算法。


### 2.4.2 查找和排序
查找：顺序查找、二分查找（数组必须是按顺序的）、哈希表查找（它能够在O(1)时间内查找某一元素，但是需要额外的空间来实现哈希表）和二叉排序查找。

排序：插入排序、冒泡排序、归并排序、*快速排序**。

#### 面试题11：旋转数组的最小数字
**题目**：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组{3,4,5,1,2}位{1,2,3,4,5}的一个旋转，该数组最小值为1.

解题思路：可以注意到旋转数组是由两个顺序的子数组组成的，左子数组和右子数组。最小的数字应该是右子数组的第一个数。我们可以利用二分查找的思路来做。

指针left指向第一个元素，指针right指向最后一元素，在每一次循环的过程中，选择中间元素num[middle]进行比较。

a.)如果num[middle]>=num[left],说明middle在左子数组中，所以应该令left等于middle；

b.)如果num[middle]<=num[right],则说明middle在右子数组中，所以应该令right等于middle。

当right-left等于1时，则最小数就是num[right]。因为，此时left是左子数组最后一个数字，right是右子数组第一个数字，右子数组第一个数即最小数。

如果num[left]==num[right] 并且 num[left]==num[middle]，则说明在left到right区间内，无法通过上述规则找出最小数，例如{1,1,1,1,1,0,1}。应该通过线性搜索，找到最小数字。

### 2.4.3 回朔法

回朔法适合有多个步骤组成的问题，并且每一个步骤都有多个选项需要尝试。如果下一次尝试不满足约束条件，那么只好回溯到上一个问题，如果上一个节点所有可能的选项都已经试过了，并不能达到满足约束条件的终结状态，则再次回溯到上一个节点。
回溯法经常采用递归的方式实现。


#### 面试题 12： 矩阵中的路径
**题目**：设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串的所有字符的路径。路劲可以从矩阵的任意一格开始，每一步可以在矩阵中向上，左，右和下移动。如果一条路径经过了矩阵的某一格子，则不能再次进入。


解题思路：在每一步中，都访问节点附近的邻近4个节点，查找下一个字符是否等于字符串中的字符。
若匹配上，则继续查找，若四个节点都没有匹配上，则回退到上一层。

```python
def hashPath(matrix, str):
    chars = str.tochar()
    visited = boolean[matrix.shape[0]][matrix.shape[1]]
    for(i in range(matrix.shape[0])):
        for(j in range(matrix.shape[1]))):
	    if(hashPathCore(matrix, i, j, chars, 0, visited))
	        return true
    return false
   
def hashPathCore(matrix, i, j, chars, index, visited):
    if index == chars.length:
        return true
    if i>=0 and i< matrix.shape[1] and j>=0 and j < matrix.shape[1] and chars[index] == matrix[i][j] and ~visited[i][j]:
        visited[i][j] = true
        result = hashPathCore(matrix, i+1, j , chars, index+1, visited) or
		hashPathCore(matrix, i-1, j , chars, index+1, visited) or
		hashPathCore(matrix, i, j+1 , chars, index+1, visited) or
		hashPathCore(matrix, i, j-1 , chars, index+1, visited)
        if result == false:
            visited[i][j] = false
        return result
    return false
 ```


#### 62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

解题思路：用一个矩阵counts[m][n]来存储到达i，j时存在不同路径的个数。
counts[0][0] = 1

counts[i][j] = counts[i-1][j] + counts[i][j-1]

如果用递归的方法，会存在超时问题。

```python
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int[][] count = new int[m][n];
        for(int i =0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    count[i][j] = 1;
                if(j > 0)
                    count[i][j] += count[i][j-1];
                if(i > 0)
                    count[i][j] += count[i-1][j];
            }
        }
        return count[m-1][n-1];
    }

}
 ```
#### 面试题 13： 机器人的运动范围
**题目**：地上有一个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，他每次可以向左，右，上和下移动一格，但不能进入坐标和列坐标的数位之和大于k的格子。例如，给定k=18时，机器人可以进入（35,37），因为3+5+3+7=18；
但是不能进入(35,38),因为3+5+3+8=19。

解题思路：从坐标(0,0)开始回溯计算可以移动范围。在每一步骤中，包含四个选项需要尝试，向上、向下，向左和向右。如果递归中不满足约束条件，则回退。

### 2.4.4 动态规划与贪婪算法

动态规划：
- 求解一个问题的最优解；
- 整体问题的最优解依赖各个子问题的最优解；
- 小问题之间有相互重叠的更小子问题；
- 从上往下分析问题，从下往上求解问题。（**在应用动态规划解决问题的时候，我们总是从解决最小问题开始，并把已经解决的子问题的最优解存储下来，并把子问题的最优解组合起来来逐步解决大的问题。**）

#### 面试题 14：剪绳子(利用额外的数组保存子问题的最优解)
**题目**：给定一根长度为n的绳子，请把绳子剪成m段(m和n都是整数)，每段绳子的长度为k[0],k[1],...,k[m]。请问各个绳子长度连乘最大是多少。

解题思路：利用动态规划来求解。用一个数组来存储计算过程中的子问题的最优解。
设计目标函数f(n)=max(f(i)*f(n-i)),我们求该目标函数的最大值即可。
在计算过程中，我们会不断的计算重复的子问题。因此，我们从下往上计算，我们先得到小问题的答案，并保存起来，再逐步解决大问题的答案。

```python
def maxProductAfterCutting(int length):
    if(length<2):
	return 0
    if(length==2):
        return 1
    if(length==3):
        return 2
    products = [0 for _ in range(length+1)]
    prodcuts[0] = 0
    prodcuts[1] = 1
    prodcuts[2] = 2
    prodcuts[3] = 3
    for i in range(4,length+1):
        max = -1
	for j in range(1,i/2+1):
	    score = prodcuts[j]*prodcuts[i-j]
	    if score > max:
	        max = score
	    prodcuts[i] = max
    return prodcuts[length]
 ```

#### 附加面试题：连续子数组的最大和（利用额外的数组保存子问题的最优解）
**题目**：输入一个整型数组nums，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。

解题思路：
可以用动态规划的思想来分析这个问题。如果用函数 f(n)表示以第 n 个数字结尾的子数组的最大和，那么我们需要求出 max[f(n)].

若f(n-1)<=0，则f(n) = nums[n];否则,f(n) = f(n-1) + nums[n].

```python
def findGreatestSumOfSubArray(nums):
    if nums == None or len(nums) == 0:
        return 0;
    curSum = [0 for i in range(len(nums))]
    curSum[0] = nums[0]
    for i in range(1,len(nums)):
        if(curSum[i-1]<=0):
	        curSum[i] = nums[i]
	    else:
	        curSum[i] = curSum[i-1] + nums[i]
    return max(curSum)
 ```


### 2.4.5 位运算
- 与： &
- 或： |
- 异或： ^
- 左移：<<
- 右移：>>
#### 面试题：15 二进制中1的个数
**题目**:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

解题思路：把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变为0.

```python
def NumberOf1(int n):
    int count = 0
    while(n!=0){
        count += 1
        n = n & (n-1)
    }
    return count
 ```

# 高质量的代码

## 3.1面试官谈代码质量
## 3.2 代码的规范性
- 代码书写清晰
- 代码布局清洗
- 代码明明合理
## 3.3 代码的完整性
- 功能测试（完成基本功能）
- 边界测试（代码中右循环和迭代，结束条件是否正确）
- 负面测试（错误输入）


#### 面试题：16
#### 面试题：17
#### 面试题：18

##### 题目一：

##### 题目二：删除链表中重复的节点

解题思路: 遇到重复的节点，跳过，直到遇见空节点或者不相等节点.
```python
def DeleteDuplication(ListNode pHead):
    if pHead == null or pHead.next == null:
        return pHead
    ListNode curNode = pHead
    ListNode preNode = null
    while(curNode == None or curNode.next == None):
        if(curNode.val != curNode.next.val):
            preNode = curNode
	    curNode = curNode.next
	else:
	    val = curNode.val
	    curNode = curNode.next
	    while(curNode != None and curNode.val == val):
                curNode = curNode.next
	    if preNode == null:
	        pHead = curNode
	    else:
	        preNode.next = curNode
    
    return pHead
 ```

#### 面试题：19 正则表达式匹配
**题目**:请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配.

解题思路：
- 如果模式中的字符ch是“.”，那么可以匹配字符串中任意字符。
- 如果模式中的字符ch不是“.”，而且字符串中的字符也是ch，那么他们互相匹配。
- 如果模式中的下一个字符ch是“*”，则需要考虑下列情况：（1）匹配0次，则字符不动，模式向后移动两位；（2）匹配1次，则字符串向后移动一位，模式向后移动两位；（3）匹配m次，则字符串向后移动一位，模式保持不变。

## 3.4 代码的鲁棒性
提高代码的鲁棒性的有效途径是进行防御性编程。防御性编程指预见在什么地方可能会出现问题，并为这些可能出现的问题制定处理方式。在面试时，最简单也最实用的防御性编程就是在函数入口添加代码以验证用户输入是否符号要求。

#### 面试题：23 链表中环的入口节点（快慢指针）
**题目**:如果一个链表中包含环，如何找出环的入口节点？

解题思路：
- 判断是否有环（快指针的速度是慢指针的2倍）
- 计算环长m
- 快指针先走m步；然后快慢指针一起走，相遇时的节点即为入口节点。设总长度为n。（n-m=l，第l个节点即为入口节点）


#### 面试题：24 反转列表（多指针，3个指针，206. Reverse Linked List）
**题目**:定义一个函数，输入一链表的头节点，反转该链表并输出反转后链表的头节点。

解题思路：定义三个指针，即前指针（preNode）指向前一个节点，当前指针（curNode）指向当前节点和后指针（nexNode）指向后一个节点。
反转的过程如下（收敛依据，curNodex！=null）：
- 首先用nextNode保存index.next；
- 然后断开连接，index.next = preNode;
- 其次反转连接，用preNode保存index，preNode=index；
- 最后替换curNode，curNode = nextNode.
- 返回preNode；
- 

```python
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode index = head;
        ListNode preNode = null;
        ListNode nextNode = null;
        while(index != null){
            nextNode = index.next;
            
            index.next = preNode;
            preNode = index;
            index = nextNode;
        }
        return preNode;
    }
}
'''

#### 面试题：25 合并两个排序的链表
**题目**:输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序。

例子：
```python
def Merge(head1, head2):
    if(head1 == null)
        return head2
    elif(head2 == null)
        return head1
    mergeNode = None
    if(head1.val <= head2.val)
        mergeNode = head1
	mergeNode.next = Merge(head1.next, head2)
    else
        mergeNode = head2
	mergeNode.next = Merge(head1, head2.next)
    return mergeNode
 ```
#### 面试题：26 树的子结构
**题目**:输入两颗二叉树A和B，判断B是不是A的子结构。

解题思路：DFS+BFS。
- 首先利用DFS寻找A和B相等的节点；
- 在找到相等的节点后，利用BFS同时匹配left和right子节点是否相等；

```python
def HasSubtree(head1, head2):
    if head1 == None or head2 == None:
        return false;
    result = False
    if(head1.val == head2.val):
        result = IsSubtree(head1, head2)
    #DFS分别搜索left和right
    if(!result):
        result = HasSubtree(head1.left, head2)
    if(!result):
        result = HasSubtree(head1.right, head2)
    return result

def IsSubtree(head1, head2):
    if(head2 == null)
        return True
    if(head1 == null)
        return False
    if(head1.val == head2.val)
        #BFS同时搜索left和right
	return IsSubtree(head1.left, head2.left) and IsSubtree(head1.right, head2.right)
    return False
 ```
# 解决面试思路
在编程前解释思路。应聘者如果没有想清楚就动手，则本身就不是太好。
## 4.2 画图让抽象问题形象化
有不少与数据结构相关的问题，比如二叉树、二维数组、链表等问题都可以采用画图的方式来分析。

#### 面试题：27 二叉树镜像 （101. Symmetric Tree）
**题目**:请完成一个函数，输入一颗二叉树，该函数的输出它的镜像。

解题思路：递归地交换左子树和右子树。

```python
def Mirror(root):
    if root == None:
        return
    left = root.left
    right = root.right

    root.left = right
    root.right = left

    if(root.left!=None)
        return Mirror(root.left)
    if(root.right!=None)
        retrun Mirror(root.right)
 ```
 
#### 面试题：28 对称二叉树
**题目**:请实现一个函数，用来判断一颗二叉树是不是对称的。
解题思路：
- 前序遍历：先根节点，左节点和右节点；
- 自定义前序遍历：先根节点，右节点和左节点。
通过比较上述两种遍历的节点是否相同，即可判断该二叉树是否为对称二叉树。
```python
def isSymmetrical(root):
    if root == None:
        return True
    return isSymmetricalCore(root1, root2):
def isSymmetricalCore(root1, root2):
    if(root1 == null && root2 == null):
        return True
    if(root1 == null || root2 == null):
        return False
    if(root1.val != root2.val)
        return False
    return isSymmetricalCore(root1.left, root2.right) &&
           isSymmetricalCore(root1.right, root2.left)
 ```
 
#### 面试题：29 顺时针打印矩阵
**题目**:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

解题思路：注意边界条件。

## 4.3 举例让抽象问题具体化
#### 面试题：29 顺时针打印矩阵
**题目**:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

解题思路：注意边界条件。
 
#### 面试题：30 包含min函数的栈
**题目**:定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
解题思路：利用辅助stack保存min值。

#### 面试题：31 栈的压入、弹出序列
**题目**:输入两个整数序列，第一个序列标识栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。

解题思路：利用辅助stack来模拟压入与弹出。如果下一个弹出数字刚好是栈顶则继续，如果不是则将压入序列中的数字依次压入直到满足栈顶数字与弹出序列相等为止。如果所有数字都压入辅助stack中仍然没有满足条件，则该序列不可能是一个弹出序列。

#### 面试题：32 从上到下打印二叉树
**题目**:从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

解题思路：BFS（利用queue先进先出）


#### 面试题:33 二叉搜索树的后序遍历序列
**题目**：输入一个正数组，判断该数组是不是某二叉搜索树的后序遍历的结果。

解题思路：在后序遍历中，最后一个节点总是root节点。将整个数组可以划分为两组，一组为root的左子树，在该子树中，所有的节点都是小于root；另一组为root的右子树，在该子树中所有的节点都大于root。用递归的方法可以解决该问题，不断的取数组的最后一位为root，并且不断分割对比。

Trick：如果右子树中存在小于root的节点则直接返回false。


#### 面试题:34 二叉树中和为某一值的路径
**题目**：输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

解题思路：可以利用先序遍历，先跟，后左，再右。创建一个辅助stack用以保存路径，当所走路径满足要求后遍历打印stack中节点的值。记得在利用完节点后，在stack中删除该节点。

#### 面试题35:复杂链表的复制
**题目**：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

解题思路：另原始链表的节点为src，复制链表的节点为clone。下一个指针为next，随即指针为random。有三种方法如下：
- 第一次遍历next，第二次遍历random，第二次遍历需要寻找复制表中的random指向的节点，所以总体时间复杂度为O（n*n）；
- 第一次遍历next的同时将src和clone的节点同时放入HashMap(src，clone)中保存；在第二次遍历random时，只需要从HashMap根据src取出节点即可。这种方法的时间复杂度为O（n），空间复杂度O（n）。
- 第一次遍历next时，将src的next指向clone；第二次遍历时，将clone.random指向src.random.nex；最后一次将整个链表分割开，另奇数节点为原始链表，另偶数节点组成复制链表。

#### 面试题36:二叉搜索树与双向链表
**题目**：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

解题思路：利用中序遍历。通过中序遍历可以得到按顺序排列的链表。在遍历根节点的左子树时，左子树形成的链表最后一位是最大的，将根节点left指向该节点并且该节点的right指向根节点。根节点的右子树构成的链表第一位是最小的，将根节点的left指向该节点并且该节点的right指向根节点。

#### 面试题：38 字符串的排列 （求全排列）
**题目**：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

解题思路：
1. 把字符串分成两部分，一部分是第一个字符，另一个部分是后面其余的字符串.
2. 拿第一个字符和后面的字符串依次交换，再递归后，需要将两个交换的字符交换回来。
3. 注意：在递归里第一次交换是自身和自身的交换，保证不缺少字符串


# 优化时间和空间效率
## 5.1 面试官谈效率
在内存充足的情况下，时间复杂度比较重要，多是采取空间换时间。而对于内存不足，例如嵌入式设备，很多时候空间换时间就不现实了，因为存储空间太少了。

## 5.2 时间效率
- 编程习惯。例如不要多次使用String的+运算来拼接字符串，因为这样会产生很多String的临时变量。
- 使用一个算法采用递归和循环的时间效率个不一样。例如，递归本质是将一个大的复杂度问题分解成两个或者多个小问题，如果小问题直接有重叠部分，那么直接使用递归方法虽然代码简洁，但时间效率会很差。我们可以用递归的思路来分析问题，在代码中添加数组来保存中间结果。
- 数据结构和算法的功底。我们只有对常见的数据结构和算法都十分了解，才能在需要的时候选择合适的数据结构和算法来解决问题。


#### 面试题 39：数组中出现次数超过一半的数字
**题目**：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

解题思路：
1. 利用空间换时间。创建一个额外的Map来存储数组中各个数字出现的个数。遍历完数组后，遍历Map查看是否有超过一半的数字。
2. 书中推荐的方法，在不使用额外空间的情况下时间复杂度为O(n)。若数组中存在一个出现次数超过一半的数字，那么它出现的次数比其他所有数字出现的和都多。因此，我们可以在遍历的过程中保存两个值：一直是数组中的数字和出现次数（times）。当下一次遍历的数字和之前保存的数字相同时，则times++；否则times--；如果times等于0,我们需要保存下一个数字，并且另times等于1。遍历之后，重新检查保存的数字是否超过一半。
3. 

#### 面试题 40:数组中最小的k个数
**题目**：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

解题思路：nlog(k)。用一个PriorityQueue额外空间存储k个最小的数集合。我们需要自定义一个PriorityQueue用的Compotor。遍历数组时，如果队列的大小小于k，则直接将该数存入队列中；如果队列大小等于k，则比较队列的第一个数字是否比该数大，如果大于则删除队列第一个数，并将数组中的数字加入到队列中。


#### 面试题：45 把数组排成最小的数
**题目**：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

解题思路：参考面试题38. 需要注意的是，拼接数字时有可能溢出，所以我们将拼接后的数字转化为字符串，直接比较字符串即可。

#### 面试题：47 礼物最大价值（动态规划，数组+循环）
**题目**：在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（大于0）。你可以从棋盘上的左上角开始拿格子里的礼物，并每一次可以向下或者向右移动一格，直到到达棋盘的右下角。给定一个棋盘及上面的礼物，请计算你最多拿多少价值的礼物？

解题思路：目标函数 f(i,j) = max(f(i,j)+f(i-1,j), f(i,j)+f(i,j-1)).
利用二位数组存储中间变量，再利用循环遍历整个棋盘获得每个位置上的最大值。最后返回二维数组的右下角的值即可。
```python
def getMaxValue(values):
    if values == None:
        return 0
    maxValues = copy.deepcopy(values)
    for i in range(len(values)):
        for j in range(len(values[0])):
            if(i > 0):
                up = values[i-1][j]
            if(j > 0):
                left = values[i][j-1]
            maxValues[i][j] = max(maxValues[i][j] + up, maxValues[i][j]+left)
    return maxValues[-1][-1]
 ```     
#### 面试题：48 最长不含重复字符的子字符串（动态规划）
**题目**：请从字符串中找出一个最长的不包含重复字符的子字符串。

解题思路：目标函数，
- f(i) = f(i-1)+1， 如果第i个字符从未出现或者两次出现距离d大于f(i-1)；
- f(i) = d, 如果第i个字符两次出现距离d小于f(i-1)。

关于d的计算，利用辅助数组position计算，该数组的长度为26，记录每个字符上一次出现的位置，如果从未出现过默认为-1.
```python
def longestSubstringWithoutDuplication(str):
    if str == None:
        return 0
    maxLength = -1
    curLength = 0
    position = [-1 for i i range(len(26))]
    for i in range(len(str)):
        if position[str[i]-'a'] < 0 or i - position[str[i]-'a'] > curLength:
            curLength += 1
        else
            maxLength = max(maxLength, curLength)
            curLength = i - position[str[i]-'a']
        position[str[i]-'a'] = i
        maxLength = max(maxLength, curLength)
    return maxLength
 ```  

### 5.3 时间效率与空间效率的平衡
空间换时间、时间换空间。

#### 面试题：49 丑数
**题目**：把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

解题思路：我们可以利用辅助数组保存中间变量（即，丑数）。一个丑数，一定是由前面已经得到的丑数计算的得到的，即N=Min(tmp2\*2,tmp3\*3,tmp5\*5)。将丑数中最大的值记作M，通过N更新M。若tmp2\*2 >= M,则更新tmp2，tmp2++，tmp3与tmp5类似。

#### 面试题：50 第一个只出现一次的字符
**题目**：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。

解题思路：我们可以利用辅助HashMap保存每个字符出现的次数，Key为字符串中的字符，Value为各个字符出现的次数。在保存完所有字符后，再次遍历字符串，找出第一个只出现一次的字符，返回其位置即可。

#### 面试题：51 数组中的逆序对（归并排序）
**题目**：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

解题思路：归并排序。先把数组分割成子数组，统计出子数组内部的逆序对的数目，然后再统计两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中还需要对数组进行排序。

归并排序是能够保证任意长度为N的数组排序所要时间和NlogN成正比；它的主要缺点是需要额外的空间O(N)。

```python
def InversePair(nums):
    if nums == None:
        return 0
    aux = None
    count = InversePair(nums, aux, 0, len(nums)-1)
    return count
def InversePair(nums, aux, start, end):
    if start >= end:
        return 0
    length = (end-start)/2
    left = InversePair(nums, aux, start, start+length)
    right = InversePair(nums, aux, start+length+1, end)
    count = Merge()
    return count + left + right
def Merge(nums, aux, start, mid, end):
    for i in range(start, end+1):
        aux = nums[i]
    i = mid
    j = end
    count = 0
    for k in range(start, end+1):
        if i < start:
            nums[k] = aux[i--]
        elif j < mid+1:
            nums[k] = aux[j--]
        elif aux[i] > aux[j]:
            nums[k] = aux[i--]
            count += (j - mid)
        else:
            nums[k] = aux[j--]
    return count
 ```
 
 
#### 面试题：52 两个链表的第一个公共节点（快慢指针）
**题目**：输入两个链表，找出它们的第一个公共结点。

解题思路：若两个链表存在公共节点，则一定m>=n或者m<=n。所以依次遍历两个链表，分别记录链表长度m和n。通过m和n可知两个链表的长短，让快指针指向长链表的头并且先走abs(m-n)步，再令慢指针指向短链表。最后快慢指针同时遍历两个链表，检测是否含有公共节点。时间复杂度O(m+n)。


# 面试中的各项技能
## 6.3 知识迁移能力

#### 面试题：53 在排序数组中查找数字（二分查找）
**题目**：统计一个数字在排序数组中出现的次数。
解题思路：利用二分查找，找到目标数字出现的第一个位置和目标数字出现的最后一个位置。

**题目**：数组中数值和下标相等的元素。（二分查找）

**题目**：0~n-1中缺失的数字。（二分查找，第一个下标与数字不同）

#### 面试题：54 二叉搜索树的第k大节点（中序搜索）
**题目**：给定一颗二叉搜索树，请找出其中的第k大的结点。

解题思路：用中序遍历的书序遍历一颗二叉树，则遍历序列的数值是递增排序的。从而可以获得第k大节点。

#### 面试题：55 二叉树的深度 （104. Maximum Depth of Binary Tree）
**题目**:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

解题思路：分别递归地计算左子树与右子树深度，并且比较两个子树的深度，选择深度较大的为返回值。

```python
def TreeDepth(root):
    if root == None:
        return 0
    leftHigh = TreeDepth(root.left)
    rightHigh = TreeDepth(root.right)
    return leftHigh >= rightHigh : leftHigh + 1 : rightHigh + 1
 ```
 
**题目**:输入一棵二叉树，判断该二叉树是否是平衡二叉树。如果二叉树中任意节点的左、右子树的深度相差不超过1，那么它就是二叉树。

解题思路：后续遍历，在遍历的过程中返回各个子树的深度，进行比较。
```python
def IsBalanced_Solution(root):
    if root == None:
        return True
    return IsBalanced_SolutionCore(root)!=-1
def IsBalanced_SolutionCore(root):
    if root == None:
        return 0
    left = IsBalanced_SolutionCore(root.left)
    right = IsBalanced_SolutionCore(root.right)
    
    if left!=-1 and right!=-1:
        diff = abs(left-right)
        if(diff <= 1):
            return 1 + (left>right?left:right)
    return -1
 ```

 
 
#### 面试题：56 数组中数字出现的次数
**题目**:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

解题思路：如果数组中只有一个出现一次，其他均出现两次。则遍历地异或整个数组的结果，即为出现一次的数。这是因为，其他数都是成对出现通过异或为0，只有出现一次的数被保留下来。所以我们先将数组分为两个子数组，每个子数组只有一个出现一次的数其余均出现两次。我们根据从头到尾异或数组的结果中的第一个为1的位置m，将数组分位两组，第一组中的数的第m位为1，第二组中的数第m位为2.然后再依次遍历两个数组并且进行异或，两次结果即为在数组中出现一次的数。

**题目**:一个整型数组里除了一个数字之外，其他的数字都出现了三次。请写程序找出这只出现一次的数字。时间复杂度O(n)，空间复杂度O(1)


解题思路：利用辅助数组长度为32，空间复杂度O(1)。遍历给定数组中的每一个数字，计算其二进制表达式中哪些位置为1，将其在辅助数组中的位置加一。遍历整个数组后，如果一个数字出现三次，则它的二级制表达式的每一位也出现了三次。如果把所有出现三次的数字的二进制表示的每一位都分别加起来，那么每一位的和都能被3整除。只出现一次的数字，其对应的二进制表达式每一位对3取余数肯定不为0。通过对辅助数组的每一位对3取余数，即可得到在数组中只出现一次的数字。



#### 面试题：57 和为S的数字
**题目一**:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。（双指针）

解题思路：双指针。第一个index1指针指向数组第一位，第二个指针指向数组第二位index2。因为是排序的数组，所以num[index1]+num[index2]若小于给定数，则index1加1；若大于给定数，则index2减1；若想等，则找到数组中两个数之和为给定数。

**题目二**:和为s的连续正数序列。输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个）。例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列。

解题思路：big和small两个数。固定small，big=small+1.采用递归的方式获得连续序列，利用ArrayList保存递归计算中的连续正数序列。tmp=samll+big,若tmp==s，则找到序列;若tmp<s，则small=tmp,big+1，递归调用该方法；若tmp>s则停止递归调用，找不到该连续正数序列。

#### 面试题：58 翻转字符串
**题目一**：输入一个英文句子，翻转句子中的单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如，输入字符串"I am a student.",输出应该是"student. a am I"。

解题思路：第一次翻整个字符串，第二次翻字符串中的单词。

**题目二**：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。

解题思路：首先将前n个字符翻转；再将剩余字符串翻转；最后将整个字符串翻转。

#### 面试题：59队列的最大值
**题目一**：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。

解题思路：用一个两端开口的队列（LinkedList）来存储。队头存储滑窗中最大的值，队尾存储滑窗中可能的最大值。即队头存储最大值，队尾存储次大值。注意，队列存储的是数组的下标，因为要比较下标，来判断队列中的数字是否已经超出滑窗大小。

# 附加：
#### 1.BitMap算法
所谓的Bit-map就是用一个bit位来标记某个元素对应的Value， 而Key即是该元素。由于采用了Bit为单位来存储数据，因此在存储空间方面，可以大大节省。

我们先来看一个具体的例子，假设我们要对0-7内的5个元素(4,7,2,5,3)排序（这里假设这些元素没有重复）。那么我们就可以采用Bit-map的方法来达到排序的目的。要表示8个数，我们就只需要8个Bit（1Bytes），首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0，如下图：

![image](http://my.csdn.net/uploads/201208/13/1344854370_5847.jpg)

然后遍历这5个元素，首先第一个元素是4，那么就把4对应的位置为1，所以要把第五位置为一（如下图）：

![image](http://my.csdn.net/uploads/201208/13/1344854388_8094.jpg)

然后再处理第二个元素7，将第八位置为1,，接着再处理第三个元素，一直到最后处理完所有的元素，将相应的位置为1，这时候的内存的Bit位的状态如下： 

![image](http://my.csdn.net/uploads/201208/13/1344854408_4675.jpg)

然后我们现在遍历一遍Bit区域，将该位是一的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。

优点：
- 运算效率高，不许进行比较和移位；
- 占用内存少，比如N=10000000；只需占用内存为N/8=1250000Byte=1.25M。 

缺点：
- 所有的数据不能重复。即不可对重复的数据进行排序和查找。   

如果应对海量数据，我们可以利用数组来实现bitmap。

开辟空间int[32] map;
在Java中整形是32bite，所以我们可以利用map存储32*32个数。
申请一个int一维数组，那么可以当作为列为32位的二维数组，



int a[0]    |0000000000000000000000000000000000000|

int a[1]    |0000000000000000000000000000000000000|

...

int a[N]    |0000000000000000000000000000000000000|

计算步骤如下：
1. 求十进制0-N对应在数组a中的下标，记作i：十进制0-31，对应在a[0]中，先由十进制数n转换为与32的余可转化为对应在数组a中的下标。比如n=24,那么 n/32=0，则24对应在数组a中的下标为0。又比如n=60,那么n/32=1，则60对应在数组a中的下标为1，同理可以计算0-N在数组a中的下标。 
2. 求0-N对应0-31中的数：十进制0-31就对应0-31，而32-63则对应也是0-31，即给定一个数n可以通过模32求得对应0-31中的数，记作j。
3. 利用移位0-31使得对应32bit位为1. a[i]左移j位。

位操作：
- 将int型变量a[i]的第j位清0，即a[i]=a[i]&~(1<<j)；
- 将int型变量a[i]的第j位置1，即a[i]=a[i]|(1<<j)。

[参考:海量数据处理算法—Bit-Map](http://blog.csdn.net/hguisu/article/details/7880288)

#### 2.各个排序比较
##### 冒泡排序
数组中两两邻近的数字比较，如果前面的数字大于后面的数字，则二者交换。
```python
def bubleSort(nums):
    for i in range(len(nums)):
        for j in range(len(nums)-i):
            if nums[j] > nums[j+1]:
                tmp = nums[j]
                nums[j] = nums[j+1]
                nums[j+1] = tmp
 ```
##### 选择排序
首先找到数组中最小的元素，其次，将它和数组的第一个元素交换。再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到整个数组排序。
```python
def selectSort(nums):
    for i in range(len(nums)):
        minIndex = i
        for j in range(i,len(nums)):
            if num[minIndex] > nums[j]:
                minIndex = j
        tmp = nums[minIndex]
        nums[minIndex] = nums[i]
        nums[i] = tmp
 ```
 
##### 插入排序
始终确保左子数组(num[0]~-num[i-1])是有序的，将新的数字(num[i])插入到有序的左子数组中。
```python
def insertSort(nums):
    for i in range(1,len(nums)):
        j = i
        while j > 0 and nums[j] < nums[j-1]:
            tmp = nums[j]
            nums[j] = nums[j-1]
            nums[j-1] = tmp
 ```
##### 归并排序
可以递归地将数组分成两半分别排序，然后将结果归并起来。归并排序能够保证将任意长度为N的数组排序所需时间和NlogN成正比。它主要的缺点是需要一个辅助数组，导致需要O(N)的空间复杂度。

归并排序是一种从下往上的算法。递归调用发生在整理数组之前。先逐步分开，再逐步整理数组。
```python
def mergeSort(nums):
    backup = [0 for _ in range(len(nums))]
    mergeSort(nums, backup, 0, len(nums)-1)
def mergeSort(nums, backup, start, end):
    if start >= end:
        return;
    length = (end - start)/2
    mergeSort(nums, backup, start,start+length)
    mergeSort(nums, backup, start+length+1, end)
    merge(nums, backup, strat, start+length, end)
def merge(nums, backup, start, mid, end):
    for i in range(start,end+1):
        backup[i] = nums[i]
    i = mid
    j = end
    for k in range(end,start-1,-1):
        if i < start:
            j -=1
            nums[k] = backup[j]
        elif j < mid+1:
            i -=1 
            nums[k] = backup[i]
        elif backup[i] > backup[j]:
            i -=1
            nums[k] = backup[i]
        else:
            j -=1
            nums[k] = backup[j]
 ```
 
##### 快速排序
快速排序是一种分治的排序算法。它将一个数组分成两个子数组，将两部分独立地排序。这是一种从上往下的递归排序方法。在大数组中先局部有序，再切分子数组，依次保证子数组内局部有序，从而达到全局有序。递归调用发生在处理整个数组之后。在快速排序中，切分的位置取决于数组的内容。

在子数组中，以第一个数字为比较对象。从左到右扫描直到找到一个大于等于它的元素，再从右到左开始向左扫描直到找到一个小于等于他元素，将这两个元素交换位置。直到左指针遇到右指针，则提停止扫描。随后将第一个元素与右指针指向的元素交换位置。最后返回右指针作为切分点。依据该切分点，递归地调用切分数组。


```python
def quickSort(nums):
    quickSort(nums,0,len(nums)-1)
def quickSort(nums,start,end):
    if start >= end:
        return;
    j = partition(nums, start, end)
    quickSort(nums, start, j-1)
    quickSort(nums, j+1, end)
def partition(nums, start, end):
    i = start
    j = end+1
    v = nums[i]
    while true:
        while(nums[++i] < v) if(i==end) break;
        while(nums[--j] > v) if(j==start) break;
        if(i>=j)
            break;
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = nums[i]
    
    tmp = nums[j]
    nums[j] = v
    nums[start] = tmp
    return j
 ```
 
#####  计数排序
类似bit-map排序方法。只不过在这里需要一个辅助数组，用来存储各个数出现的次数。在遍历后，即可知道每个数子出现的次数，依次遍历该辅助数组，依次输出辅助数组中位置上不为0的下标，出现m次，则该下标输出m次。

#### 桶排序
用hash的方式，将整个数组中的元素映射到各个桶中，再在各个桶依次利用快速排序，最后依次输出各个桶中的有序数组即可。

n个数据，m个桶，则每个桶平均n/m，在每个桶上用快速排序时间复杂度(n/m)log(n/m)。所以总的是件复杂度是，
O(n+m*(n/m)log(n/m))

算法 | 平均时间复杂度 | 空间复杂度
---|---|---
冒泡排序 | O(n*n) | O(1)
选择排序 | O(n*n) | O(1)
插入排序 | O(n*n) | O(1)
递归排序 | O(nlogn) | O(n)
快排排序 | O(nlogn) | O(1)
计数排序 | O(n) | O(n)
桶排序   | O(n+m*(n/m)log(n/m)) | O(m+n)
堆排序 | O(nlogn) | O(nlogn)

#### 3.Trie树
Trie树，又称单词查找树或键树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

**Trie的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。**

每个节点都要保存各个子树的指针（26个）。可以沿着树查找、添加或者删除给定字符串。

```python
class TreeNode：
    def __init__():
        this.TreeNode = [TreeNode() for _ in range(26)]
        this.count = 0
        thic.char = None
```
Trie树的基本性质可以归纳为： 
1. 根节点不包含字符，除根节点意外每个节点只包含一个字符。
2. 从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。 
3. 每个节点的所有子节点包含的字符串不相同。

基本思想（以字母树为例）：
1. 插入过程
对于一个单词，从根开始，沿着单词的各个字母所对应的树中的节点分支向下走，直到单词遍历完，将词频变量加1，表示该单词已插入Trie树。
2. 查询过程
同样的，从根开始按照单词的字母顺序向下遍历trie树，一旦发现某个节点标记不存在或者单词遍历完成而最后的节点册词频变量等于0，则表示该单词不存在，若最后的节点的词频变量大于0，表示该单词存在。

![image](https://pic002.cnblogs.com/images/2012/214741/2012112521092438.png)

因为当查询如字符串abc是否为某个字符串的前缀时，显然以b、c、d....等不是以a开头的字符串就不用查找了，这样迅速缩小查找的范围和提高查找的针对性。所以建立Trie的复杂度为O(n\*len)，而建立+查询在trie中是可以同时执行的，建立的过程也就可以成为查询的过程，hash就不能实现这个功能。所以总的复杂度为O(n*len)，实际查询的复杂度只是O(len)。
和你的字符集大小N以及单词的最大长度M有关，不超过O(N^M)。


[Trie树参考](http://www.cnblogs.com/huangxincheng/archive/2012/11/25/2788268.html)

# leetcode高频题编程练习
#### 1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

利用HashMap存储键值对，key存储当前数字，value存储下标。通过判断HashMap中是否存在（target-maps[nums[i]]），即可判断出是否有满足要求的解。
```python
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return null;
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int[] results = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(!maps.containsKey(nums[i]))
                maps.put(nums[i],i);
            if(maps.containsKey(target-nums[i]) && maps.get(target-nums[i])!=i){
                results[0] = maps.get(target-nums[i]);
                results[1] = i;
                return results;
            }
        }
        return results;
    }
}
```

#### 2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

分别遍历两个链表，用flag作为标志位，代表是否进位。
```python
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return null;
        ListNode head = new ListNode(-1);
        ListNode index = head;
        int flag = 0;
        while(l1!=null || l2!=null){
            int x = l1!=null ? l1.val : 0;
            int y = l2!=null ? l2.val : 0;
            int tmp = x + y + flag;
            index.next = new ListNode(tmp%10);
            if(tmp >= 10)
                flag =1;
            else
                flag =0;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            index = index.next;
        }
        if(flag == 1)
            index.next = new ListNode(1);
        return head.next;
    }
}
```

#### 445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 8 -> 0 -> 7

```python
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        ListNode head = new ListNode(-1);
        ListNode index = head;
        while(l1!=null){
            list1.addLast(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            list2.addLast(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        while(!list2.isEmpty() || !list1.isEmpty()){
            int a = list1.isEmpty() ? 0 : list1.removeLast();
            int b = list2.isEmpty() ? 0 : list2.removeLast();
            index.next = new ListNode((a+b+flag)%10);
            if(a + b + flag >= 10){
                flag = 1;
            }else{
                flag = 0;
            }
            index = index.next;
        }     
        if(flag == 1)
            index.next = new ListNode(1);
        head = reverse(head.next);
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
```



#### 3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

利用256整形数组，存储字符出现的下标。一个指针指（left）向子字符串起始的位置，当前下标i-left+1即当前子字符串的长度。
分别遍历两个链表，用flag作为标志位，代表是否进位。
```python
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)
            return 0;
        int[] chars = new int[256];
        char[] str = s.toCharArray();
        int max_length = 0;
        int length = 0;
        int left = 0;
        for(int i = 0 ; i < str.length; i++){
            if(chars[str[i]] == 0 ||  chars[str[i]] < left){
                max_length = max_length > i - left + 1 ? max_length : i - left +1;
            }else{
                left = chars[str[i]];
            }
            chars[str[i]] = i+1;
        }
        return max_length;
    }
}
```
其中，chars[str[i]] < left，当left的下标已经大于该字符串第一次出现的位置时，也应该重新计算最大长度。例如“abbca”，当left指向第一个b，i指向最后一个a，chars[str[i]]指向第一个a，由于chars[str[i]] < left，说明第一个a已经不在子字符串中，应该重新计算最大长度。

#### 4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).



等效于在两个排序的数组中找到第k小的数字。首先先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。反之亦然。当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数。

记得在比较数组中的值时，下标记得加偏置，即start+k/2-1。


```python
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total%2==1)
            return findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2+1);
        else{
            int a = findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2);
            int b = findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2+1);
            return (findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2) +
                    findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2 + 1)) / 2.0;
        }
    }
    public int findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        if(end1 - start1 > end2 - start2)
            return findMedianSortedArrays(nums2, start2, end2, nums1, start1, end1, k);
        if(end1- start1 == 0)
            return nums2[k - 1];
        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int ma = Math.min(k/2, end1-start1);
        int mb = k - ma;

        if(nums1[start1 +  ma - 1] < nums2[start2 + mb - 1]){
            return findMedianSortedArrays(nums1, start1 + ma, end1, nums2, start2, end2, k-ma);
        }else if(nums1[start1 + ma - 1] > nums2[start2 + mb - 1]){
            return findMedianSortedArrays(nums1, start1, end1, nums2, start2 + mb, end2, k-mb);
        }else{
            return nums1[start1 + ma -1];
        }
    }
}
```

#### 55. Jump Game （数组）

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

解题思路：遍历数组时，每一步保存能跳的最大步数。1）如果max_length小于等于nums[i]，则更新下；2）否则max_length-1。当i+max_length大于数组长度时，则可以到达数组最后一位。如果max_length等于0，代表已经不能再往前走了，所以返回false。


```python
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if (index <= nums[i])
                index = nums[i];
            else
                index -=1;
            if(i + index >= nums.length -1)
                return true;
            if(index == 0)
                return false;
        }
        return false;
    }
}
```

#### 54. Spiral Matrix（数组）
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

解题思路:设定上边界、下边界、左边界、右边界。每一次遍历，在上边界，从左到右；在右边界，从上到下；在下边界，从左到右；在左边界，从下到上。在遍历依次四周后，缩小各个边界值。

```python
import java.util.List;
import java.util.LinkedList;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lists = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return lists;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(lists.size() < (matrix.length*matrix[0].length)){
            spiralOrder(matrix, top, bottom, left,right,lists);
            top +=1;
            bottom -=1;
            left +=1;
            right -=1;
        }

        return lists;
    }
    public void spiralOrder(int[][] matrix, int top, int bottom, int left, int right, List<Integer> lists){
        for(int i = left; i <= right; i++)
            lists.add(matrix[top][i]);
        for(int i = top+1; i < bottom; i++)
            lists.add(matrix[i][right]);
        if(top < bottom){
            for(int i = right; i >= left; i--)
                lists.add(matrix[bottom][i]);
        }
        if(left < right){
            for(int i = bottom-1; i > top; i--)
                lists.add(matrix[i][left]);
        }

    }
}
```

#### 56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

解题思路：先排序，再排序。

合并：如果合并集合为空或者选择合并集中最后一区间的end与当前区间的start比较，如果小于，则直接将当前区间放入合并集合中；如果大于，则更新当前区间end的值。

```python
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.LinkedList;
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> lists = new LinkedList<Interval>();
        if(intervals == null)
            return lists;
        Collections.sort(intervals, new IntervalComparator());
        for(Interval interval : intervals){
            if(lists.isEmpty() || lists.get(lists.size() - 1).end < interval.start){
                lists.add(interval);
            }else{
                lists.get(lists.size() - 1).end = Math.max(lists.get(lists.size() - 1).end, interval.end);
            }

        }
        return lists;
    }
}
```

#### 198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

解题思路：f(i)=max(f(i-1),f(i-2)+c)
```python
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = Math.max(values[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            values[i] = Math.max(values[i-1],values[i-2]+nums[i]);
        }
        return values[values.length-1];
    }
}
```

#### 5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.


解题思路：
这道题是比较常考的题目，求回文子串，一般有两种方法。 第一种方法比较直接，实现起来比较容易理解。基本思路是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙）往两边同时进行扫描，直到不是回文串为止。假设字符串的长度为n,那么中心的个数为2\*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)，代码如下：
```python
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        String max_str = "";
        for(int i = 0; i < s.length()*2; i++){
            int left = i/2;
            int right = i/2;
            if(i%2==1){
                right +=1; 
            }
            String tmp = longestPalindrome(s, left, right);
            if(tmp.length() > max_str.length()){
                max_str = tmp;
            }
        }
        return max_str;
    }
    public String longestPalindrome(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left -=1;
            right += 1;
        }
        return s.substring(left+1,right);  
    }
}
```
解题思路：动态规划

假定字符串s为回文字符串，则在s头部和尾部分别添加相同字符串[x]，所得结果s'=[x]s[x]也为回文字符串（论述1）。可使用动态规划方法解决此问题，递推公式便基于此特性。
创建一个布尔二维数组plain，plain[i][j]为true表示原字符串从索引i到索引j这一段子串为回文。而plain[i][j]为true的前提是s.charAt(i)与s.charAt(j)相同，且以下两个条件满足其一：
1. j-i<=2, j=i时必然成立，j-i=1则表示i与j相邻，"aa"、"bb"满足条件
2. j-i>2, 此时须plain[i+1][j-1]为true，即论述1所述
核心算法分析完毕，写一双重循环，索引i由字符串尾部向前遍历，索引j由i向后遍历，每次发现回文字符串时设置二维数组相应的值，并比较其长度是否大于当前的maxLen。若大于，则更新用于记录当前最长回文子串起始和终止位置的start和end

```python
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        int max_len = 0;
        int start=0, end=0; 
        boolean[][] plain = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i >=0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || plain[i+1][j-1])){
                    plain[i][j] = true;
                    if(max_len < (j-i+1)){
                        start = i;
                        end = j;
                        max_len = j-i + 1;
                    }
                }
            }
        }
        return s.substring(start, end+1);  
    }
}
```
#### 516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

注意：这个是子序列，不是子字符串。

解题思路：动态规划 + 递归。

当已知一个序列是回文时，添加首尾元素后的序列存在两种情况，一种是首尾元素相等，则最长回文的长度加2，当首尾元素不相等，则最长回文序列为仅添加首元素时的最长回文与仅添加尾元素时的最长回文之间的最大值。

我们可以用dp[i][j]表示s[i…j]中的最长回文序列，而状态转移方程则是 

```python
1. i > j，dp[i][j] = 0； 
2. i == j，dp[i][j] = 1； 
3. i < j且s[i] == s[j]，dp[i][j] = dp[i + 1][j - 1] + 2； 
4. i < j且s[i]！= s[j]，dp[i][j] = max(dp[i + 1][j]，dp[i][j - 1])；
```

```python
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[][] dp = new int[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length()-1,dp);
    }
    public int longestPalindromeSubseq(String s, int left, int right, int[][] dp){
        if(left > right)
            return 0;
        if(dp[left][right] != 0)
            return dp[left][right];
        if(left == right){
            dp[left][right] = 1;
        }else{
            if(s.charAt(left) == s.charAt(right)){
                dp[left][right] += longestPalindromeSubseq(s,left+1, right-1,dp)+2;
            }else{
                dp[left][right] = Math.max(longestPalindromeSubseq(s,left+1, right,dp),longestPalindromeSubseq(s,left, right-1,dp));
            }
        }
        return dp[left][right];
    }
}
```
#### 46. Permutations

Given a collection of distinct numbers, return all possible permutations.

解题思路：全排列

```python
import java.util.LinkedList;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return lists;
        permute(nums, 0, lists);
        return lists;
    }
    public void permute(int[] nums, int start, List<List<Integer>> lists){
        if(start >= nums.length){
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < nums.length; i++)
                list.add(nums[i]);
            lists.add(list);
            return;
            
        }
        for(int i = start; i < nums.length; i++){
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            
            permute(nums, start+1, lists);
            
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
        }
    }
}
```


#### 47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

解题思路：保证唯一性。
方法就是对与重复的元素循环时跳过递归的调用只对第一个未被使用的进行递归，那么这一次的结果将会唯一出现在结果集中，而后重复的元素将会被略过。如果第一个重复元素还没在当前结果中，那么我们就不需要进行递归。

```python
import java.util.LinkedList;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return lists;
        Arrays.sort(nums);
        dfs(lists, new ArrayList<Integer>(), nums, new boolean[nums.length]);  
        return lists;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {  
        if(temp.size() == nums.length) {  
            res.add(new ArrayList<>(temp));  
            return;  
        }  
        for(int i = 0; i < nums.length; i++) {  
            if(used[i] || i > 0  && nums[i] == nums[i-1] && used[i-1]==false) continue;  
            /* 
            上面这一连串判断条件，重点在于要能理解!used(i-1) 
            要理解这个，首先要明白i作为数组内序号，i是唯一的 
            给出一个排好序的数组，[1,2,2] 
            第一层递归            第二层递归            第三层递归 
            [1]                    [1,2]                [1,2,2] 
            序号:[0]                 [0,1]            [0,1,2] 
            这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了 
            [1]                    [1,2]                [1,2,2]             
            序号:[0]                [0,2]                [0,2,1] 
            所以这边判断的时候!used(1)就变成了true，不会再继续递归下去，跳出循环 
            步主要就是为了去除连续重复存在的，很神奇反正 = =|| 
        */  
            used[i] = true;  
            temp.add(nums[i]);  
            dfs(res, temp, nums, used);  
            temp.remove(temp.size() - 1);  
            used[i] = false;  
        }  
    } 
}
```
#### 78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

解题思路：用一个路径path保存子集。（整体代码结构类似全排列）



```python
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return lists;
        subsets(nums, 0, lists, new LinkedList<Integer>());
        return lists;
    }
    public void subsets(int[] nums, int start, List<List<Integer>> lists, LinkedList<Integer> path){
        lists.add(new LinkedList<Integer>(path));
        for(int i = start; i < nums.length; i++){
            path.addLast(nums[i]);
            subsets(nums,i+1,lists,path);
            path.removeLast();
        }
    }
}
```

#### 424. Longest Repeating Character Replacement
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

解题思路：本质滑窗问题。
用一个滑动窗口，查找最长的subarray，使得其最多包含k个与majority不相同的字符，majority指的是窗口中最多的字符。

length = majority_counts + k

滑动窗口的长度计算如上所示。length是滑动窗口大小，majority_counts是滑窗中出现最多的字符的个数。

length = i - left + 1

令滑窗左侧起始指针为left，当前索引为i。
如果length - majority_counts > k，则需要缩小滑窗并且left对应的索引字符的出现次数减一因为其已经出了滑窗，counts[s.charAt[left]]，left++。

```python
class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int max_count = 0, max_length = 0, left = 0;
        for(int i = 0; i < s.length(); i++){
            max_count = Math.max(max_count, ++counts[s.charAt(i) - 'A']);
            if(i - left + 1 - max_count > k){
                counts[s.charAt(left) - 'A'] -= 1;
                left +=1;
            }
            max_length = Math.max(max_length, i - left + 1);
        }
        return max_length;
    }
}
```

#### 79. Word Search （矩阵中的路径，剑指offer题12）

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

解题思路：用一个visited数组来保存是否采用该元素。

遍历矩阵，查看矩阵元素是否与字符串首字母相等。

若想等则，则直接以该元素对应的位置作为起始点在矩阵中搜索给定字符串。在搜索过程中，应该同时搜索位置的上、下、左、右，查看是否匹配。如果匹配，则继续递归地查找。如果不匹配，则停止该方向上的搜索。

```python
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(exist(board, visited, word, 0, i, j, m, n))
                        return true;
                }
            }
        }
        return false;
        
    }
    public boolean exist(char[][] board, boolean[][] visited, String word, int start, int i, int j, int m, int n){
        if(start >= word.length())
            return true;
        if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && board[i][j] == word.charAt(start)){
            visited[i][j] = true;
            boolean flag =  exist(board, visited, word, start+1, i+1, j, m, n) ||
                            exist(board, visited, word, start+1, i-1, j, m, n) ||
                            exist(board, visited, word, start+1, i, j+1, m, n) ||
                            exist(board, visited, word, start+1, i, j-1, m, n);
            visited[i][j] = false;
            return flag;
        }
        return false;
    }
}
```

#### 416. Partition Equal Subset Sum

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

解题思路：背包问题。

如果数组总和是偶数，则转换成背包问题。背包的总和是数组和的一半，背包物品价值与重量相等。背包问题求解后，最后总价值等于数组的一半，则该数组可以划分成两个子数组其和相等。

```python
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int sum_value = 0;
        for(int i = 0; i < nums.length; i++){
            sum_value += nums[i];
        }
        if(sum_value % 2 == 1)
            return false;
        return canPartition(sum_value / 2, nums);
    }
    public boolean canPartition(int target, int[] nums){
        int[][] values = new int[nums.length+1][target+1];
        for(int i = 1; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                if(j < nums[i-1])
                    continue;
                values[i][j] = Math.max(values[i-1][j], values[i-1][j-nums[i-1]] + nums[i-1]);
            }
        }
        if(values[nums.length][target] == target)
            return true;
        return false;
    }
}
```

#### 102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

题目：给定一个二叉树，用List<List<Integer>> lists保存二叉树中的节点值。lists中每一个元素代表二叉树中某一层中所有节点的值。

解题思路：（BFS）用一个LinkedList<TreeNode> path 保存当前层节点。用递归的方式遍历二叉树中所有的节点。在递归时，首先计算path的大小m，首先将path前m个元素逐个弹出并将其左右节点压入path的队尾，用一个LinkList<Integer> values保存前m个元素的值。当前m个元素弹出后，将values压入lists并继续递归。当path大小为0时，则停止递归。

```python
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(root == null)
            return lists;
        LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        path.add(root);
        levelOrder(path, lists);
        return lists;
    }
    public void levelOrder(LinkedList<TreeNode> path, List<List<Integer>> lists){
        if(path.isEmpty())
            return;
        LinkedList<Integer> values = new LinkedList<Integer>();
        int size = path.size();
        for(int i = 0; i < size; i++){
            TreeNode node = path.removeFirst();
            values.addLast(node.val);
            if(node.left != null)
                path.addLast(node.left);
            if(node.right != null)
                path.addLast(node.right);
        }
        lists.add(values);
        levelOrder(path, lists);
    }
}
```

#### 148. Sort List （链表归并排序）
Sort a linked list in O(n log n) time using constant space complexity.

解题思路：归并排序。==需要注意返回每次归并和合并的头节点！！！==

```python
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int length = 0;
        ListNode index = head;
        while(index != null){
            index = index.next;
            length +=1;
        }
        head = sortList(head, 0, length-1);
        return head;
    }
    public ListNode sortList(ListNode node, int start, int end){
        if(start >= end)
            return node;
        int mid = (end - start) / 2;
        ListNode index = node;
        for(int i = 0; i < mid; i++){
            index = index.next;
        }
        ListNode next = index.next;
        index.next = null;

        node = sortList(node, start, start + mid);
        next = sortList(next, start + mid + 1, end);

        node = merge(node, next);

        return node;

    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode pLeft = left;
        ListNode pRight = right;

        ListNode head = new ListNode(-1);
        ListNode cur = null;
        ListNode index = head;
        while (pLeft != null && pRight != null){
            if(pLeft.val < pRight.val){
                cur = pLeft;
                pLeft = pLeft.next;
            }else{
                cur = pRight;
                pRight = pRight.next;
            }
            index.next = cur;
            index = index.next;
        }
        if(pLeft != null)
            index.next = pLeft;
        if(pRight != null)
            index.next = pRight;
        return head.next;
    }
}
```




#### 203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

```python
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode index = head;
        ListNode preNode = null;
        while(index!=null && index.val == val){
            index = index.next;
        }
        preNode = index;
        ListNode res = preNode;
        while(index!=null){
            if(index.val == val){
                while(index != null && index.val == val){
                    index = index.next;
                }
                preNode.next = index;
                preNode = index;
            }else{
                preNode = index;
                index = index.next;
            }
        }
        return res;
    }
}
```

#### 125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

解题思路：题目要求判断字母数字字符串是否是回文。所以先把字符串toLowerCase，再用两个指针分别指向头和尾，判断索引的字符是否是数字或者字母，如果不是则指针移动，否则判断两个索引字符是否相等。

```python
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && (s.charAt(left) - 'a' < 0 || s.charAt(left) - 'a' > 26) && (s.charAt(left) - '0' < 0 || s.charAt(left) - '0' > 9))
                left +=1;
            while(left < right && (s.charAt(right) - 'a' < 0 || s.charAt(right) - 'a' > 26)&& (s.charAt(right) - '0' < 0 || s.charAt(right) - '0' > 9))
                right -=1;

            if(left < right && s.charAt(left)  != s.charAt(right))
                return false;
            left +=1;
            right -=1;
        }
        return true;
    }
}
```

#### 116. Populating Next Right Pointers in Each Node（2017年京东面试题）
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

解题思路：递归遍历树的每一层，将每一层中的节点指向其右侧节点。

```python
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        LinkedList<TreeLinkNode> lists = new LinkedList<TreeLinkNode>();
        lists.add(root);
        connect(lists, 1);
    }
    public void connect(LinkedList<TreeLinkNode> lists, int cnt){
        if(cnt == 0)
            return;
        TreeLinkNode lastNode = null;
        int count = 0 ;
        for(int i = 0; i < cnt; i++){
            TreeLinkNode curNode = lists.removeFirst();
            if(curNode.left != null){
                lists.add(curNode.left);
                count +=1;
            }
            if(curNode.right != null){
                lists.add(curNode.right);
                count +=1;
            }
            if(i > 0){
                lastNode.next = curNode;
            }
            lastNode = curNode;
        }
        connect(lists, count);
    }
}
```

不用额外空间的版本：
```python
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        root.next = null;
        conn(root);
        
    }
    private void conn(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            if(root.next != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
        }
        conn(root.left);
        conn(root.right);
    }
}
```


#### 131. Palindrome Partitioning（回溯）
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

解题思路：我们在最外层循环中判断字符串s中的[i,j]是否构成回文。如果构成回文，那么，接着判断s 中j+1及以后的字符是否构成回文；如果不构成回文，那么就不进行下一次递归，直接在本层循环中判断[i,j+1]是否构成回文。

```python
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists= new LinkedList<List<String>>();
        if(s == null || s.length() == 0)
            return lists;
        partition(s, lists, new LinkedList<String>(), 0);
        return lists;
    }
    public void partition(String s, List<List<String>> lists, LinkedList<String> path, int i){
        if(i >= s.length()){
            lists.add(new LinkedList<String>(path));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                path.addLast(s.substring(i,j+1));
                partition(s, lists, path, j+1);
                path.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        if(start < 0 || end >= s.length())
            return false;
        int i = start;
        int j = end;
        
        while(i <= end && j >= start){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i +=1;
            j -= 1;
        }
        return true;
    }
}
```
#### 328. Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

```python
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd_head = head;
        ListNode even_head = head.next;
        ListNode even_odd = even_head;
        while(even_head != null && even_head.next != null){
            odd_head.next = even_head.next;
            even_head.next = even_head.next.next;
            
            odd_head = odd_head.next;
            even_head = even_head.next;
        }
        odd_head.next = even_odd;
        return head;
    }
}
```


#### 343. Integer Break （动态规划，类似剑指offer面试题14）
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

```python
class Solution {
    public int integerBreak(int n) {
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for(int i = 4; i < n + 1; i++){
            int tmp=0;
            for(int j = 1; j <= i/2; j++){
                tmp = nums[j] * nums[i-j];
                if(nums[i] < tmp)
                    nums[i] = tmp;
            }
        }
        return nums[n];
        
    }
}
```
#### 162. Find Peak Element
A peak element is an element that is greater than its neighbors.

Given an input array nums, where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

解题思路：该题目要求寻找局部极值点。可以采用二分查找的策略，每次查看中间的数，判断是否是局部极值点。

```python
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int[] results = {-1};
        findPeakElement(nums, 0, nums.length - 1, results);
        return results[0];
    }
    public void findPeakElement(int[] nums, int start, int end, int[] res){
        if(start > end)
            return;
        int mid = start + (end - start) / 2;
        if((mid == 0 || nums[mid] > nums[mid-1]) && (mid==nums.length-1 || nums[mid] > nums[mid+1])){
            res[0] = mid;
            return;
        }
        if(mid == 0 || nums[mid] > nums[mid-1])
            findPeakElement(nums, mid+1, end, res);
        else
            findPeakElement(nums, start, mid-1, res);
    }

    public static void main(String[] args){
        int[] nums = {3,4,3,2,1};
        System.out.println(new Solution().findPeakElement(nums));
    }
}
```

#### 215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

解题思路：排序或者利用快排partion函数寻找第k大的数。

```python
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
        
    }
    public int findKthLargest(int[] nums, int target, int start, int end){
        if(start >= end)
            return nums[start];
        int j = partion(nums, start, end);
            
        if((nums.length - j) > target){
            return findKthLargest(nums, target, j+1, end);
        }else if((nums.length - j) < target){
            return findKthLargest(nums, target, start, j-1);
        }
        return nums[j];
    }
    public int partion(int[] nums, int start, int end){
        int i = start;
        int j = end + 1;
        int value = nums[start];
        int tmp = 0;
        while(true){
            while(nums[++i] < value){
                if(i == end)
                    break;
            }
            while(nums[--j] > value){
                if(j == start)
                    break;
            }
            if(i >= j)
                break;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[start] = nums[j];
        nums[j] = value;
        return j;
    }
}
```

#### 454. 4Sum II
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

解题思路：用空间换时间。用一个HashMap保存前两个数组各个元素对的和。再遍历后面两个数组的，分别计算元素对的和，然后访问HashMap是否有互补的，相加等于0。



```python
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int len = A.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                maps.put(A[i] + B[j], maps.getOrDefault(A[i] + B[j], 0)+1);
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int tmp = -(C[i] + D[j]);
                res += maps.getOrDefault(tmp,0);
            }
        }
        return res;
    }
}
```

#### 18. 4Sum

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.


解题思路：利用3sum和2sum的思路，注意通过两个相邻元素相等时则跳过。


```python
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            threeSum(nums, i+1, res, nums[i], target);
        }
        return res;
    }
    public void threeSum(int[] nums, int start, List<List<Integer>> res, int first, int target){
        for(int i = start; i < nums.length - 2; i ++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            twoSum(nums, i+1, res, first, nums[i], target);
        }
    }
    public void twoSum(int[] nums, int start, List<List<Integer>> res, int first, int second, int target){
        int i = start;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] + first + second == target){
                LinkedList<Integer> path = new LinkedList<Integer>();
                path.add(first);
                path.add(second);
                path.add(nums[i]);
                path.add(nums[j]);
                res.add(path);
                while(i<j && nums[i]==nums[i+1]) 
                    i +=1;  
                while(i<j && nums[j]==nums[j-1]) 
                    j -= 1; 
                i += 1;
                j -= 1;
            }else if(nums[i] + nums[j] + first + second < target){
                i += 1;
            }else{
                j -= 1;
            }
        }
    }
    
}
```


#### 136. Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

解题思路：剑指offer56题，用异或的方法遍历整个数组，数组中出现两次的数字在异或中会抵消掉，最终异或的结果就是在数组中只出现一次的数字。


```python
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
```

#### 414. Third Maximum Number
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

解题思路：由于时间复杂度O（n）。所以不能再用排序的方法解决该问题。可以设置三个指针，分别指向第一大，第二大和第三大的元素。每次遍历时需要注意该元素与三个指针所指向的元素是否是同一个值，如果是，则跳过，否则依次比较。

```python
class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int first = nums[0];
        int second = nums[0];
        int third = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == first || nums[i] == second || nums[i] == third)
                continue;
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }else if((nums[i] > second || second == first)){
                third = second;
                second = nums[i];
            }else if((nums[i] > third || third == second || third == first)){
                third = nums[i];
            }
        }
        if (first > second && second > third) return third;
        return first;
    }
}
```

#### 332. Reconstruct Itinerary（DFS）
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:

tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]

Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

解题思路：应该该题存在环，可以采用DFS。用HashMap存储图结构，key是起始点，value是list对应的目的地集合。用优先队列保存目的地集合，满足题目要求。用DFS遍历图结构，起始节点是JFK。在DFS中，需要注意需要将遍历后节点每次加到路径的头位置。

```python
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> paths = new LinkedList<String>();
        if(tickets == null || tickets[0] == null)
            return paths;
        HashMap<String, PriorityQueue<String>> maps = new HashMap<String, PriorityQueue<String>>();
        for(int i =0; i < tickets.length; i++){
            PriorityQueue<String> lists;
            if(maps.containsKey(tickets[i][0]))
                lists = maps.get(tickets[i][0]);
            else
                lists = new PriorityQueue<String>();
            lists.add(tickets[i][1]);
            maps.put(tickets[i][0], lists);
        }
        dfs("JFK", maps, paths);
        return paths;
    }
    public void dfs(String str, HashMap<String, PriorityQueue<String>> maps, List<String> lists){
        if(maps.get(str) == null){
            lists.add(0,str);
            return;
        }
        while(maps.get(str).size() > 0){
            String tmp = maps.get(str).poll();
            dfs(tmp, maps, lists);
        }
        lists.add(0,str);
    }
}
```

#### 686. Repeated String Match
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
```python
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if(B == null || A == null)
            return -1;
        StringBuilder tmp = new StringBuilder(A);
        int res = 1;
        while(tmp.length() < B.length()){
            tmp.append(A);
            res +=1;
        }
        if(tmp.toString().contains(B))
            return res;
        tmp.append(A);
        res +=1;
        if(tmp.toString().contains(B))
            return res;
        return -1;

    }
}
```


#### 110. Balanced Binary Tree（求二叉树每层的高度）

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

解题思路：利用递归的方法求二叉树每层的高度，计算左右子树的差值。

```python
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean[] res = new boolean[1];
        res[0] = true;
        isBalanced(root, res);
        return res[0];
    }
    public int isBalanced(TreeNode node, boolean[] res){
        if(res[0] == false)
            return 0;
        if(node == null)
            return 1;
        int left = isBalanced(node.left, res);
        int right = isBalanced(node.right, res);
        if(left - right > 1 || right - left > 1){
            res[0] = false;
            return 0;
        }
        return left > right ? 1 + left : 1 + right;
    }
}
```

#### 814. Binary Tree Pruning（二叉树）
We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

解题思路：需要将二叉树中全部包含0的子树删除掉。可以通过递归遍历的方式，从低到上一次判断该子树是否全部为0。


```python
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        pruneTreeCore(root);
        return root;
    }
    public boolean pruneTreeCore(TreeNode node){
        if(node == null)
            return true;
        boolean lRes = pruneTreeCore(node.left);
        boolean rRes = pruneTreeCore(node.right);
        if(lRes == true)
            node.left = null;
        if(rRes == true)
            node.right = null;
        if(node.val == 0 && rRes == true && lRes == true)
            return true;
        return false;
    }
}
```


#### 35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

```python
class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }
    public int searchInsert(int[] nums, int target, int start, int end){
        if(start > end)
            return start;
        int middle = start + (end - start)/2;
        if(nums[middle] == target)
            return middle;
        if(nums[middle] > target)
            return searchInsert(nums, target, start, middle-1);
        else
            return searchInsert(nums, target, middle+1, end);
    }
}
```

#### 228. Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.

Input:  [0,1,2,4,5,7]

Output: ["0->2","4->5","7"]

Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

解题思路：用一个容器来保存路径，判断是否连续。注意，在遍历完之后，需要处理最后一组区间字符串。

```python
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if(nums == null || nums.length == 0)
            return res;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(list.size() == 0)
                list.addFirst(nums[i]);
            else{
                if(nums[i] == list.getLast() + 1)
                    list.addLast(nums[i]);
                else{
                    String str = "";
                    int first = list.getFirst();
                    int last = list.getLast();
                    if(first != last)
                        str += first + "->" + last;
                    else
                        str += first;
                    res.add(str);
                    list.clear();
                    list.addFirst(nums[i]);
                }
            }
        }
        String str = "";
        int first = list.getFirst();
        int last = list.getLast();
        if(first != last)
            str += first + "->" + last;
        else
            str += first;
        res.add(str);
        return res;
    }
}
```

#### 832. Flipping an Image
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Input: [[1,1,0],[1,0,1],[0,0,0]]

Output: [[1,0,0],[0,1,0],[1,1,1]]

Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].

Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

解题思路：翻转元素时同时变换元素。

```python
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0)
            return A;
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; i++){
            if(n%2==1)
                A[i][n/2] = 1 - A[i][n/2];
            for(int j = 0; j < n/2; j++){
                int tmp = 1 - A[i][j];
                A[i][j] = 1 - A[i][n - j - 1];
                A[i][n - j -1] = tmp;
            }
        }
        return A;
    }
}
```


# 公司面试题

#### 蘑菇街一面：求两数组的交集，并且去重。

解题思路：先排序nums1和nums2，在用index1和index2来分别指向nums1和nums2的第一个元素。然后，在同时遍历。如果nums1[index1]==nums2[index2]，则找到交集元素，并且两指针自加，紧接着判断下一个元素是否还是相等，如果相等则继续自加，跳过下一个元素；如果果nums1[index1]<nums2[index2]，则index1自加；否则，index2自加。


```python
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    public static int[] core(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> lists = new LinkedList<Integer>();
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                lists.add(nums1[index1]);
                index1 +=1;
                index2 +=1;
                if(index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums1[index1-1] && nums1[index1] == nums2[index2]){
                    index1 +=1;
                    index2 +=1;
                }
            }else if(nums1[index1] < nums2[index2]){
                index1 +=1;
            }else{
                index2 +=1;
            }
        }
        int[] res = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++){
            res[i] = lists.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {2,1,3,10,9,8};
        int[] nums2 = {0,2,3,10};
        int[] res = core(nums1, nums2);
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
```

#### 京东面试题：给定一个树，令树中节点值等于其子结构中的节点数总和。
```python
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val = 0;
    public TreeNode(){}
}
public class Solution {
    public static void countNodeNum(TreeNode node){
        core(node);
    }
    public static int core(TreeNode node){
        if(node == null)
            return 0;
        node.val = core(node.left) + core(node.right);
        return node.val + 1;
    }
}
```

#### 京东面试题：从原点出发，每次投骰子，根据点数m每次移动m步，问如何求得经过n时的概率？（类似斐波那契数列解法）

解题思路：用数组保存前6次的概率。

递推公式：f(n)=f(n-1)*1/6+f(n-2)*1/6+…+f(n-6)*1/6


# 实习offer
蘑菇街、阿里、华为