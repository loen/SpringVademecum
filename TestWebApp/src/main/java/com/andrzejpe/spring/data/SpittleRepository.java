package com.andrzejpe.spring.data;

import java.util.List;

/**
 * Created by jedrek on 2015-10-17.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle getSpittle(long id);
}
