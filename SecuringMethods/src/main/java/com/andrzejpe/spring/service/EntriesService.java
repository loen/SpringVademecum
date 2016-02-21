package com.andrzejpe.spring.service;

import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntriesService {

    private Map<Integer, List<String>> entries = new HashMap<>();

    @RolesAllowed("ROLE_USER")
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

    @RolesAllowed("ROLE_USER")
    public void removeEntries(Integer count) {
        entries.remove(count);
    }
}
