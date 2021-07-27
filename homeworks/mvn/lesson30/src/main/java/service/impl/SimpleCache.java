package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Class SimpleCache
 *
 * Simple implementation of Cache allow to store data by key-value pairs.
 * NullPointerException safe, allows null keys and values.
 * There is no timeout, so caches persist as long as SimpleCache exists or until clean () methods are called.
 * Logs stored into ./log/ directory.
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 20.07.2021
 */
public class SimpleCache implements Cache {
    /** Common logger */
    private final Logger log = LoggerFactory.getLogger("commonLogger");
    /** Common storage for cached data */
    private final Map<String, Map<String, Object>> cacheMap;

    /** Storage initialization */
    public SimpleCache() {
        cacheMap = new HashMap<>();
    }

    @Override
    public boolean put(String cache, String key, Object o) {
        Map<String, Object> keyMap;

        if(cache == null || key == null || o == null) {
            log.warn("Got null param while put into cache: cache={}, key={}", cache, key);
            return false;
        }

        if(!cacheMap.containsKey(cache)) {
            keyMap = new HashMap<>();
            log.info("Created new cache={} into cacheMap.", cache);
        } else {
            keyMap = cacheMap.get(cache);
        }
        if(keyMap.containsKey(key)) {
            log.info("Rewritten key={} in cache={}.", key, cache);
        }
        keyMap.put(key, o);
        cacheMap.put(cache, keyMap);
        return cacheMap.get(cache).containsKey(key);
    }

    @Override
    public Object get(String cache, String key) {
        if(cache == null || key == null) {
            log.warn("Got null param while get cache: cache={}, key={}", cache, key);
            return null;
        }
        if(!cacheMap.containsKey(cache)) {
            log.warn("Got non existent: cache={}", cache);
            return null;
        }
        return cacheMap.get(cache).get(key);
    }

    @Override
    public void clear() {
        if(!cacheMap.isEmpty()) {
            cacheMap.clear();
            log.info("All caches cleared.");
            return;
        }
        log.warn("Trying to clear empty cache.");
    }

    @Override
    public void clear(String cache) {
        if(cacheMap.containsKey(cache)) {
            cacheMap.remove(cache);
            log.info("Cache={} cleared.", cache);
            return;
        }
        log.warn("Trying to clear empty cache={}.", cache);
    }
}
