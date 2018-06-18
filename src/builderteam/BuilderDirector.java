package builderteam;

import objects.Team;
import java.time.LocalDate;

/**
 * Creation of teams
 * Create the equipment that will be used in the game
 * @author BranDaniMB
 */
public class BuilderDirector {

    
    /**
     * 
     * Creator of equipment.
     * It is responsible for joining all the parts of the equipment object and has a series of validations before creating the equipment so that no teams are created and valid.
     * @param builder
     * @param name
     * @param id 
     * @param date
     * @return returns a properly created team
     * @throws InvalidDataException 
     */
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
