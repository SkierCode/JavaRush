package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    Storage storage;
    OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(20);

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        final Object o = lruCache.find(id);
        if (o == null) {
            final Object retrieve = originalRetriever.retrieve(id);
            lruCache.set(id, retrieve);
            return retrieve;
        }
        return o;
    }
}
