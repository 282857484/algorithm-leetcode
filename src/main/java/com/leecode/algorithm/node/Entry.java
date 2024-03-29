package com.leecode.algorithm.node;

public class Entry<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public Entry() {
    }
}
