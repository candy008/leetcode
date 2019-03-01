package com.leetcode.code;

import com.leetcode.code.commons.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        //[[1,4,5],[1,3,4],[2,6]]

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;


        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        ListNode l32 = new ListNode(11);
        l3.next = l31;
        //l31.next=l32;

        ListNode l5 = new ListNode(8);
        ListNode l51 = new ListNode(9);
        ListNode l52 = new ListNode(16);
        l5.next = l51;
        l51.next = l52;

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        //lists[3] = l5;
        ListNode listNode = mergeKLists1(lists);
        System.out.println(listNode);

    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        if (lists.length <= 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }
        ListNode listNode = lists[0];
        for (int i = 0; i < lists.length - 1; i++) {
            listNode = mergeTwoLists(listNode, lists[i + 1]);
        }
        return listNode;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeKLists2(ListNode[] lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        return null;

    }


}
