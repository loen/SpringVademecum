package com.andrzejpe.spring.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntriesService {

    private Map<Integer, List<String>> entries = new HashMap<>();

    @Cacheable("entries")
    public List<String> getEntries(Integer count) {
        List<String> entry = new ArrayList<>();

        for (int i = 0 ; i < count ; i++) {
            entry.add(new String("entry for " + (i + 1)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        entries.put(count, entry);
        return entry;
    }

    @CacheEvict("entries")
    public void removeEntries(Integer count) {
        entries.remove(count);
    }
}
