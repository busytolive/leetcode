package com.leetcode;

import java.util.*;

/**
 * LFU Cache
 *
 */
public class Problem460 {
    private Map<Integer, CacheItem> lookupTable;
    private int capacity;
    private FrequencyNode head;

    public Problem460(int capacity) {
        this.capacity = capacity;
        lookupTable = new HashMap<>();
        head = new FrequencyNode();
    }

    public int get(int key) {
        if (!lookupTable.containsKey(key)) {
            return -1;
        }
        CacheItem cacheItem = lookupTable.get(key);
        increaseAccessCount(key, cacheItem);
        return cacheItem.value;
    }

    private void increaseAccessCount(int key, CacheItem cacheItem) {
        FrequencyNode frequencyNode = cacheItem.frequencyNode;
        FrequencyNode nextFrequencyNode = frequencyNode.next;
        if (nextFrequencyNode == null || nextFrequencyNode.accessCount != frequencyNode.accessCount + 1) {
            FrequencyNode newFrequencyNode = new FrequencyNode();
            newFrequencyNode.accessCount = frequencyNode.accessCount + 1;
            newFrequencyNode.next = nextFrequencyNode;
            if (nextFrequencyNode != null) {
                nextFrequencyNode.prev = newFrequencyNode;
            }
            frequencyNode.next = newFrequencyNode;
            newFrequencyNode.prev = frequencyNode;
            newFrequencyNode.cacheKeys.add(key);
        } else {
            nextFrequencyNode.cacheKeys.add(key);
        }
        frequencyNode.cacheKeys.remove(key);
        if (frequencyNode.cacheKeys.isEmpty()) {
            deleteNode(frequencyNode);
        }
        cacheItem.frequencyNode = frequencyNode.next;
    }

    private void deleteNode(FrequencyNode node) {
        FrequencyNode prev = node.prev;
        if (node.next != null) {
            node.next.prev = prev;
        }
        prev.next = node.next;
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            return;
        }

        if (lookupTable.containsKey(key)) { // set
            CacheItem cacheItem = lookupTable.get(key);
            cacheItem.value = value;
            lookupTable.put(key, cacheItem);
            increaseAccessCount(key, cacheItem);
        } else if (lookupTable.size() < capacity) { // insert
            insertNewCacheItem(key, value);
        } else { // evict and insert
            Iterator<Integer> iterator = head.next.cacheKeys.iterator();
            int keyToEvict = iterator.next();
            iterator.remove();
            if (head.next.cacheKeys.isEmpty()) {
                deleteNode(head.next);
            }
            lookupTable.remove(keyToEvict);
            insertNewCacheItem(key, value);
        }
    }

    private void insertNewCacheItem(int key, int value) {
        CacheItem cacheItem = new CacheItem(value);
        if (head.next == null || head.next.accessCount != 1) {
            FrequencyNode newFrequencyNode = new FrequencyNode();
            newFrequencyNode.cacheKeys.add(key);
            newFrequencyNode.next = head.next;
            head.next = newFrequencyNode;
            newFrequencyNode.prev = head;
            if (newFrequencyNode.next != null) {
                newFrequencyNode.next.prev = newFrequencyNode;
            }
            newFrequencyNode.prev = head;
            cacheItem.frequencyNode = newFrequencyNode;
        } else {
            head.next.cacheKeys.add(key);
            cacheItem.frequencyNode = head.next;
        }
        lookupTable.put(key, cacheItem);
    }

    class CacheItem {
        CacheItem(int value) {
            this.value = value;
        }
        int value;
        FrequencyNode frequencyNode;
    }

    class FrequencyNode {
        FrequencyNode() {
            accessCount = 1;
            cacheKeys = new LinkedHashSet<>();
        }

        int accessCount;
        FrequencyNode next;
        FrequencyNode prev;
        Set<Integer> cacheKeys;
    }
}
