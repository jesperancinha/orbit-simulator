package com.jfse.kartracelaps.objects;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Result {
    String getDriverName();

    Integer getKartNumber();

    LocalTime getTimeStamp();
}
