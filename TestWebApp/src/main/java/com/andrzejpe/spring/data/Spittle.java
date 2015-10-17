package com.andrzejpe.spring.data;

import java.time.LocalTime;

/**
 * Created by jedrek on 2015-10-17.
 */
public class Spittle {

    private final long id;
    private final String message;
    private final LocalTime time;
    private final Double latitude;
    private final Double longitude;

    public Spittle(long id, String message, LocalTime time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalTime getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spittle spittle = (Spittle) o;

        if (id != spittle.id) return false;
        if (!message.equals(spittle.message)) return false;
        if (!time.equals(spittle.time)) return false;
        if (!latitude.equals(spittle.latitude)) return false;
        return longitude.equals(spittle.longitude);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + message.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        return result;
    }
}
