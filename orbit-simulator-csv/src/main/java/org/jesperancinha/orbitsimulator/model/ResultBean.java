package org.jesperancinha.orbitsimulator.model;

import com.opencsv.bean.CsvBindByName;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ResultBean {

    @CsvBindByName(column = "planet")
    private String planet;

    @CsvBindByName(column = "passingtime")
    private String passingtime;


    public ResultBean(String planet, String passingtime) {
        this.planet = planet;
        this.passingtime = passingtime;
    }

    public String getKart() {
        return planet;
    }

    public String getPassingtime() {
        return passingtime;
    }
}
