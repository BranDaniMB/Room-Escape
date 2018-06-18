package builderteam;

import objects.Team;
import java.time.LocalDate;

/**
 * Interface Builder
 * It contains 4 methods that will be used to create the equipment
 * @author BranDaniMB
 */
public interface Builder {

    void buildName(String name);

    void buildPlayers(String id) throws InvalidDataException;

    void buildInscription(LocalDate date);

    Team getTeam() throws InvalidDataException;
}
