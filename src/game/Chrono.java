/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import files.PropertiesConfig;

/**
 *
 * @author Jermy
 */
public class Chrono extends Thread {

    private int minut;
    private int second;
    private boolean stop;

    public Chrono() {
        minut = 0;
        second = 0;
        stop = false;
    }

    public int getMinut() {
        return minut;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public void run() {

        for (int i = 0; i < PropertiesConfig.getInstance().getProperties("timeLimit"); i++) {
            second++;
            if (second == 60) {
                minut++;
                second = 0;
            }
            notifyAll();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        stop = true;
        notifyAll();
    }
}
