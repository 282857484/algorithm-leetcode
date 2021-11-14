package com.leecode.algorithm.node;

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