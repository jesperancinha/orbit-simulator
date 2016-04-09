package com.jfse.kartracelaps.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class DriverImpl implements Driver{
    private Kart kart;

    public DriverImpl(Kart kart)
    {
        this.kart = kart;
    }

    /**
     * Driver may need to change kart
     * @param kart Kart
     */
    @Override
    public void setKart(Kart kart) {
        this.kart = kart;
    }

    /**
     * Gets the Kart assigned to the driver
     * @return
     */
    @Override
    public Kart getKart() {
        return kart;
    }
}
