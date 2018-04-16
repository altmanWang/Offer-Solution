import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

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
    public static void main(String[] args){
        int[] nums = {4,19,14,5,-3,1,8,5,11,15};
        ListNode head = new ListNode(-1);
        ListNode index =head;
        for(int i = 0; i < nums.length; i++){
            index.next = new ListNode(nums[i]);
            index = index.next;
        }

        ListNode res = new Solution().sortList(head.next);
        while (res!=null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}