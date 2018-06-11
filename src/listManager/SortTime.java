
package listManager;

import objects.Team;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jermy
 */
public class SortTime implements PrintOrder {

    @Override
    public void orderList(List<Team> teamsList) {
        Collections.sort(teamsList, this);
    }

    @Override
    public int compare(Team o1, Team o2) {
        return o1.getBestTimeMultiplayer().compareTo(o2.getBestTimeMultiplayer());
    }
}
