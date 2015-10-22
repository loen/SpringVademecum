package com.andrzejpe.spring.data;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jedrek on 2015-10-17.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    private Random r = new Random();

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        LocalTime now = LocalTime.now();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            Spittle spittle = new Spittle(i, String.format("Spittle No.%d", i), now.minusMinutes(i),
                    r.nextDouble(), r.nextDouble());
            spittles.add(spittle);
        }
        return spittles;
    }

    @Override
    public Spittle getSpittle(long id) {
        return new Spittle(id, "Spittle for id " + id, LocalTime.now(), r.nextDouble(),r.nextDouble());
    }
}
