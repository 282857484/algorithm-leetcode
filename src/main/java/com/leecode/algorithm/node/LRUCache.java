package com.leecode.algorithm.node;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
