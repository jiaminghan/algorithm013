package com.company.leetcode.homework;

import com.company.Utils;

import java.util.HashMap;
import java.util.Map;

public class Week08 {

    public static void main(String[] args){
        LRUCache.test();
        HammingWeight.test();
        RelativeSortArray.test();
    }

}

class LRUCache {

    /**
     * 146. LRU缓存机制
     */

    private int capacity;
    private Map<Integer, Node> map;
    private DoubleLinkedList doubleLinkedList;

    public static void test(){
        LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            result = node.val;
            doubleLinkedList.remove(node);
            doubleLinkedList.addFirst(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            doubleLinkedList.remove(map.get(key));
        } else {
            while(doubleLinkedList.size >= capacity){
                Node last = doubleLinkedList.removeLast();
                map.remove(last.key);
            }
        }
        doubleLinkedList.addFirst(node);
        map.put(key, node);
    }
}
class DoubleLinkedList{
    private Node head;
    private Node tail;
    public int size;
    public DoubleLinkedList(){
        head = new Node(0, 0);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    public void addFirst(Node node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        size++;
    }

    public Node remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        return node;
    }

    public Node removeLast(){
        if(size <= 0){
            return null;
        }
        return remove(tail.pre);
    }

}
class Node{
    public int key;
    public int val;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class HammingWeight{

    /**
     * 191. 位1的个数
     */

    public static void test(){
        HammingWeight h = new HammingWeight();
        System.out.println(h.hammingWeight(11));
    }


    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}

class RelativeSortArray{
    /**
     * 1122. 数组的相对排序
     */

    public static void test(){
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        RelativeSortArray r = new RelativeSortArray();
        int[] result = r.relativeSortArray(arr1, arr2);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i : result){
            stringBuilder.append(i).append(",");
        }
        System.out.println(stringBuilder.toString());
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(len1 <= 1 || 0 == len2){
            return arr1;
        }
        int[] cntArr = new int[1001];
        for(int num : arr1){
            cntArr[num]++;
        }
        int index = 0;
        int[] result = new int[len1];
        for(int num : arr2){
            while(cntArr[num]-- > 0){
                result[index++] = num;
            }
        }
        for(int i = 0; i < 1001; i++){
            if(cntArr[i] == 0){
                continue;
            }
            while(cntArr[i]-- > 0){
                result[index++] = i;
            }
        }
        return result;
    }
}
