/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import objects.Team;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jermy
 */
public class SortInscription implements PrintOrder {

    @Override
    public void orderList(List<Team> teamsList) {
        Collections.sort(teamsList, this);
    }

    @Override
    public int compare(Team o1, Team o2) {
        if (o1.getDateInscription().equals(o2.getDateInscription())) {
            return o1.getTeamName().compareTo(o2.getTeamName());
        }
        return o1.getDateInscription().compareTo(o2.getDateInscription());
    }

}
