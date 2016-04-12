package com.steelzack.orbitsimulator.model;

import com.opencsv.bean.CsvBind;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ResultBean {

    @CsvBind
    private String kart;

    @CsvBind
    private String passingtime;


    public ResultBean(String kart, String passingtime) {
        this.kart = kart;
        this.passingtime = passingtime;
    }

    public String getKart() {
        return kart;
    }

    public String getPassingtime() {
        return passingtime;
    }
}
