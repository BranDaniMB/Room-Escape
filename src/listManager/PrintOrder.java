/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import objects.Team;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Jermy
 */
public interface PrintOrder extends Comparator<Team> {

    void orderList(List<Team> teamsList);
}
