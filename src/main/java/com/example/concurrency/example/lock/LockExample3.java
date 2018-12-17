package com.example.concurrency.example.lock;

import com.example.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@ThreadSafe
public class LockExample3 {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static final Map<String, Data> map = new TreeMap<>();
    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    class Data {

    }

    public static Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public static Data put(String key, Data val) {
        writeLock.lock();
        try {
            return map.put(key, val);
        } finally {
            writeLock.unlock();
        }
    }

}
