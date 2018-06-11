/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

/**
 *
 * @author Jermy
 */
public class Player implements Comparable<Player> {

    private String id;
    private boolean selected;

    public Player(String id, boolean selected) {
        this.id = id;
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Jugador: " + "id= " + id + ", seleccionado= " + selected;
    }

    @Override
    public int compareTo(Player o) {
        return id.compareTo(o.id);
    }
}
