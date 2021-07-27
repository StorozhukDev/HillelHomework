package service;

/**
 * Interface Cache
 * A Map-like data structure that provides temporary storage of application data.
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 20.07.2021
 *
 * @see service.impl.SimpleCache
 */
public interface Cache {

    /**
     * Insert object into cache
     * @param cache cache name
     * @param key key name
     * @param o Object to be inserted into cache with such key
     * @return true if success, false otherwise
     */
    boolean put(String cache, String key, Object o);

    /**
     * Get object from selected cache by key
     * @param cache cache
     * @param key key to find Object in such cache
     * @return Object from cache if such key found, null if key or cache not exists
     */
    Object get (String cache, String key);

    /**
     * Remove all existing caches
     */
    void clear();

    /**
     * Remove selected cache
     * @param cache cache to be removed
     */
    void clear(String cache);
}
