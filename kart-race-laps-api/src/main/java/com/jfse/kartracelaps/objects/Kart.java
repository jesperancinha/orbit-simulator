package com.jfse.kartracelaps.objects;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Kart {
    void  addTimeStamp(Integer lap, LocalTime timeStamp);

    LocalTime getTimeStampByLap(Integer lap);

    Integer getKartId();
}
