package builderteam;

import objects.Team;
import java.time.LocalDate;

/**
 *
 * @author BranDaniMB
 */
public interface Builder {

    void buildName(String name);

    void buildPlayers(String id) throws InvalidDataException;

    void buildInscription(LocalDate date);

    Team getTeam() throws InvalidDataException;
}
