package com.andrzejpe.spring.soundSystem.compactDisks;

import java.util.List;

/**
 * Created by jedrek on 2015-10-04.
 */
public class TrackedCompactDisc implements CompactDisc {

    private String author;
    private String title;
    private List<String> tracks;

    public TrackedCompactDisc(String author, String title, List<String> tracks) {
        this.author = author;
        this.title = title;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        StringBuffer sb = new StringBuffer();
        tracks.stream().forEach(s -> sb.append(s + " "));
        System.out.println(author + " " + title + " " + sb.toString());
    }
}
