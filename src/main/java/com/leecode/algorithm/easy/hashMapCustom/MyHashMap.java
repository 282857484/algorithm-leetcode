package com.leecode.algorithm.easy.hashMapCustom;

import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 */
public class MyHashMap {

    private LinkedList<Entry<Integer, Integer>>[] map;
    private int capability = 64;
    public MyHashMap() {
        map = new LinkedList[capability];
        for (int i = 0; i < capability; i++) {
            map[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        int hash = hashKey(key);
        LinkedList<Entry<Integer, Integer>> list = map[hash];
        for (Entry<Integer, Integer> entry : list) {
            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
        }
        list.add(new Entry(key,value));
    }

    public int get(int key) {
        int hash = hashKey(key);
        LinkedList<Entry<Integer, Integer>> list = map[hash];
        for (Entry<Integer, Integer> entry : list) {
            if (entry.key.intValue() == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hashKey(key);
        LinkedList<Entry<Integer, Integer>> list = map[hash];
        int i = 0;
        for (Entry<Integer, Integer> entry : list) {
            if (entry.key.intValue() == key) {
                list.remove(i);
                return;
            }
            i ++;
        }
    }

    private int hashKey(int key) {
        return key % capability;
    }

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
}
