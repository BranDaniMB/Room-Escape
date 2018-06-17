/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.rooms.Rooms;

/**
 *
 * @author Jermy
 */
interface Subject {

    void add(Rooms e);

    Rooms remove(int index);
}
