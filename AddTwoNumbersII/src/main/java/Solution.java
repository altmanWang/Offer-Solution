import java.util.LinkedList;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
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
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(0);

        ListNode result = new Solution().addTwoNumbers(l1,l4);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}