package train.tasks;

public class Twosum {
	
	public static void main(String[] args) {
		ListNode first = null;
		ListNode second = null;
        int[] firstNumbers = {2, 4, 3};
        int[] secondNumbers = {5, 6, 4};
        
        Solution result = new Solution();
        first = result.setList(firstNumbers, 0);
        second = result.setList(secondNumbers, 0);
        ListNode sumList = result.addTwoNumbers(first, second);
        
        result.printList(sumList);
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode setList(int[] array, int index) {
        if(index >= array.length) {
            return null;
        }
        return new ListNode(array[index], setList(array, index+1));
    }
    
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentFirst = first, currentSecond = second, currentResult = dummyHead;
        int carry = 0;

        while (currentFirst != null || currentSecond != null) {
            int firstVal = (currentFirst != null) ? currentFirst.val : 0;
            int secondVal = (currentSecond != null) ? currentSecond.val : 0;

            int sum = carry + firstVal + secondVal;
            carry = sum / 10;

            currentResult.next = new ListNode(sum % 10);
            currentResult = currentResult.next;

            if (currentFirst != null) currentFirst = currentFirst.next;
            if (currentSecond != null) currentSecond = currentSecond.next;
        }

        if (carry > 0) {
            currentResult.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public void printList(ListNode head) {
    	System.out.print('[');
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.print(']');
    }
}
