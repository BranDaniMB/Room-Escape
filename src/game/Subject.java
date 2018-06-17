/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.rooms.RoomInterface;

/**
 *
 * @author Jermy
 */
interface Subject {

    void add(RoomInterface e);

    RoomInterface remove(int index);
}
