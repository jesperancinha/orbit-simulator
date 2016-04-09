package com.jfse.kartracelaps.model;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ResultBean {

    private String kart;
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
