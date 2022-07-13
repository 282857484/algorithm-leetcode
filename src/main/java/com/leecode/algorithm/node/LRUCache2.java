package com.leecode.algorithm.node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache2 {
    protected HashMap<Integer, Integer> map = null;
    protected LinkedBlockingQueue<Integer> queue = null;

    public LRUCache2(int capacity) {
        map = new HashMap<>(capacity);
        queue = new LinkedBlockingQueue<Integer>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //通过hashmap可改造为O(1)的remove操作
            try {
                queue.remove(key);
                queue.put(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        try {
            if (queue.contains(key)) {
                queue.remove(key);
            }
            if (queue.remainingCapacity() == 0) {
                Integer ekey = queue.poll();
                map.remove(ekey);
            }
            queue.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put(key, value);
    }
}

