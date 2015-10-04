package com.andrzejpe.spring.soundSystem.compactDisks;

import java.util.List;

/**
 * Created by jedrek on 2015-10-04.
 */
public class PropertyCompactDisk  implements CompactDisc{
    private String author;
    private String title;
    private List<String> tracks;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        StringBuffer sb = new StringBuffer();
        tracks.stream().forEach(s -> sb.append(s + " "));
        System.out.println(author + " " + title + " " + sb.toString());
    }
}
