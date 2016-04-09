package com.jfse.kartracelaps.objects;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ResultImpl implements Result {
    private static DateTimeFormatter DATEFORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private String driverName;
    private Integer kartNumber;
    private LocalTime timeStamp;

    public ResultImpl(String driverName, Integer kartNumber, LocalTime timeStamp) {
        this.driverName = driverName;
        this.kartNumber = kartNumber;
        this.timeStamp = timeStamp;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public Integer getKartNumber() {
        return kartNumber;
    }

    @Override
    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String getTimeStampString() {
        return DATEFORMATTER.format(timeStamp);
    }

    @Override
    public String toString() {
        return driverName.concat(",").concat(kartNumber.toString()).concat(",").concat(getTimeStampString());
    }
}
