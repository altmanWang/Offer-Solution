# 剑指OFFER面试题编程练习
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

##### 面试题7：重建二叉树
**题目**：输入某二叉树的前序遍历和中序遍历的结果。请重建该二叉树。

解题思路：在二叉树的前序遍历中，第一数字总是树的根节点的值。但在中序遍历中，根节点的中再序列的中间。左子树位于其左边，右子树位于其右边。通过遍历前序，可以在中序中判断出哪一部分为左子树和右子树。从而通过递归，重建出二叉树。


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
	return ture
    return false
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


#### 面试题：24 反转列表（多指针，3个指针）
**题目**:定义一个函数，输入一链表的头节点，反转该链表并输出反转后链表的头节点。

解题思路：定义三个指针，即前指针（preNode）指向前一个节点，当前指针（curNode）指向当前节点和后指针（nexNode）指向后一个节点。
反转的过程如下（收敛依据，curNodex！=null）：
- 首先用nexNode保存curNode.next；
- 然后断开连接，curNode.next = preNode;
- 其次反转连接，用preNode保存curNode，preNode=curNode；
- 最后替换curNode，curNode = nexNode.
- 返回preNode；



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

#### 面试题：27 二叉树镜像
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

#### 面试题：55 二叉树的深度
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