/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.rooms.RoomsInterface;

/**
 *
 * @author Jermy
 */
interface Subject {

    void add(RoomsInterface e);

    RoomsInterface remove(int index);
}
