package com.leetcode.problem;

import java.util.*;

/**
 * LFU Cache
 *
 * Implemented algorithm described in paper: An O(1) algorithm for implementing the LFU
 * cache eviction scheme (http://dhruvbird.com/lfu.pdf)
 *
 */
public class Problem460 {
    private Map<Integer, Element> hashTable;
    private final int CAPACITY;
    private FrequencyListNode frequencyList;

    public Problem460(int capacity) {
        CAPACITY = capacity;
        hashTable = new HashMap<>();
        frequencyList = new FrequencyListNode();
    }

    public int get(int key) {
        if (!hashTable.containsKey(key)) {
            return -1;
        }
        Element element = hashTable.get(key);
        increaseAccessCount(key, element);
        return element.value;
    }

    private void increaseAccessCount(int key, Element element) {
        FrequencyListNode frequencyListNode = element.frequency;
        FrequencyListNode nextFrequencyListNode = frequencyListNode.next;
        if (nextFrequencyListNode == null || nextFrequencyListNode.count != frequencyListNode.count + 1) {
            FrequencyListNode newFrequencyListNode = new FrequencyListNode();
            newFrequencyListNode.count = frequencyListNode.count + 1;
            newFrequencyListNode.next = nextFrequencyListNode;
            if (nextFrequencyListNode != null) {
                nextFrequencyListNode.prev = newFrequencyListNode;
            }
            frequencyListNode.next = newFrequencyListNode;
            newFrequencyListNode.prev = frequencyListNode;
            newFrequencyListNode.elementKeys.add(key);
        } else {
            nextFrequencyListNode.elementKeys.add(key);
        }
        frequencyListNode.elementKeys.remove(key);
        if (frequencyListNode.elementKeys.isEmpty()) {
            deleteNode(frequencyListNode);
        }
        element.frequency = frequencyListNode.next;
    }

    private void deleteNode(FrequencyListNode node) {
        FrequencyListNode prev = node.prev;
        if (node.next != null) {
            node.next.prev = prev;
        }
        prev.next = node.next;
    }

    public void put(int key, int value) {
        if (CAPACITY < 1) {
            return;
        }

        if (hashTable.containsKey(key)) { // set
            Element element = hashTable.get(key);
            element.value = value;
            hashTable.put(key, element);
            increaseAccessCount(key, element);
        } else if (hashTable.size() < CAPACITY) { // insert
            insertNewCacheItem(key, value);
        } else { // evict and insert
            Iterator<Integer> iterator = frequencyList.next.elementKeys.iterator();
            int keyToEvict = iterator.next();
            iterator.remove();
            if (frequencyList.next.elementKeys.isEmpty()) {
                deleteNode(frequencyList.next);
            }
            hashTable.remove(keyToEvict);
            insertNewCacheItem(key, value);
        }
    }

    private void insertNewCacheItem(int key, int value) {
        Element element = new Element(value);
        if (frequencyList.next == null || frequencyList.next.count != 1) {
            FrequencyListNode newFrequencyListNode = new FrequencyListNode();
            newFrequencyListNode.elementKeys.add(key);
            newFrequencyListNode.next = frequencyList.next;
            frequencyList.next = newFrequencyListNode;
            newFrequencyListNode.prev = frequencyList;
            if (newFrequencyListNode.next != null) {
                newFrequencyListNode.next.prev = newFrequencyListNode;
            }
            newFrequencyListNode.prev = frequencyList;
            element.frequency = newFrequencyListNode;
        } else {
            frequencyList.next.elementKeys.add(key);
            element.frequency = frequencyList.next;
        }
        hashTable.put(key, element);
    }

    /**
     * cache item
     */
    class Element {
        int value;
        FrequencyListNode frequency;

        Element(int value) {
            this.value = value;
        }
    }

    /**
     * Contains element keys that have a same frequency, ordered by access time
     */
    class FrequencyListNode {
        FrequencyListNode() {
            count = 1;
            elementKeys = new LinkedHashSet<>();
        }

        int count;
        FrequencyListNode next;
        FrequencyListNode prev;
        Set<Integer> elementKeys;
    }
}
