package com.leetcode.code;

import com.leetcode.code.commons.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {



        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(3);
        l1.next=l11;
        l11.next=l12;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(8);
        l2.next=l21;
        l12.next=l22;
        ListNode list = mergeTwoLists(l1,l2);
        System.out.println(list);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }




}
