package builderteam;

import objects.Team;
import java.time.LocalDate;

/**
 *
 * @author BranDaniMB
 */
public class BuilderDirector {

    public Team createTeam(Builder builder, String name, String id, LocalDate date) throws InvalidDataException {
        if (builder == null) {
            builder = new BuilderTeam();
        }
        builder.buildName(name);
        builder.buildPlayers(id);
        builder.buildInscription(date);

        return builder.getTeam();
    }

}
