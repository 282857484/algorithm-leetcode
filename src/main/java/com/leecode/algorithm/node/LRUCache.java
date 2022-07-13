package com.leecode.algorithm.node;

import java.util.HashMap;

public class LRUCache {
    class LinkedValueNode {
        Integer key;
        Integer value;
        LinkedValueNode preNode;
        LinkedValueNode nextNode;
        public LinkedValueNode() {}
        public LinkedValueNode(Integer key, Integer value, LinkedValueNode pre, LinkedValueNode next) {
            this.key = key;
            this.value = value;
            this.preNode = pre;
            this.nextNode = next;
        }
    }
    protected HashMap<Integer, LinkedValueNode> map = null;
    protected int capacity = 0;
    protected LinkedValueNode head;
    protected LinkedValueNode tail;
    protected int linkedListSize = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new LinkedValueNode();
        this.tail = new LinkedValueNode();
        this.head.nextNode = tail;
        this.tail.preNode = head;
    }

    public int get(int key) {
        LinkedValueNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            // 缓存命中将其移动至顶部
            if (node != null){
                // 删除已存在节点
                node.preNode.nextNode = node.nextNode;
                node.nextNode.preNode = node.preNode;
            }

            // 将新节点添加到链表头
            node.preNode = head;
            node.nextNode = head.nextNode;

            head.nextNode.preNode = node;
            head.nextNode = node;
            return node.value;
        }
    }

    public void put(int key, int value) {
        // 删除已存在节点
        LinkedValueNode node = map.remove(key);
        if (node != null){
            node.preNode.nextNode = node.nextNode;
            node.nextNode.preNode = node.preNode;
            linkedListSize --;
        }

        // 将新节点添加到链表头
        node = new LinkedValueNode(key, value, head, head.nextNode);
        head.nextNode.preNode = node;
        head.nextNode = node;
        linkedListSize ++;
        map.put(key, node);

        // 淘汰队尾节点
        if (linkedListSize > capacity) {
            LinkedValueNode eliminateNode = map.remove(tail.preNode.key);
            tail.preNode = eliminateNode.preNode;
            eliminateNode.preNode.nextNode = tail;
            linkedListSize --;
        }
    }

}
