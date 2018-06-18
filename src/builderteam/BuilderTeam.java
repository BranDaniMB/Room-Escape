package builderteam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import objects.Player;
import objects.Team;
import java.time.LocalDate;
import listManager.TeamList;

/**
 * equipment verifications
 * performs multiple checks so that the equipment is created correctly.
 * @author Jermy
 */
public class BuilderTeam implements Builder {

    private Team team;
    private Pattern pattern;
    private Matcher matcher;

    
    public BuilderTeam() {
        this.team = new Team();
    }

    /**
     * Name team
     * Assign a name to the team
     * @param name 
     */
    @Override
    public void buildName(String name) {
        team.setTeamName(name);
    }

    /**
     * Create player
     * 
     * @param id
     * @throws InvalidDataException 
     */    
    @Override
    public void buildPlayers(String id) throws InvalidDataException {
        String[] s = id.split("-");
        for (String item : s) {
            if (!item.equals("")) {
                pattern = Pattern.compile("^[a-zA-Z0-9]{3,8}$");
                matcher = pattern.matcher(item);
                if (matcher.find()) {
                    if (!TeamList.getInstance().existId(item)) {
                        team.add(new Player(item));
                    } else {
                        throw new InvalidDataException("Id ya registrado " + item + "\n");
                    }
                } else {
                    throw new InvalidDataException("Nombre de jugador incorrecto " + item + "\n");
                }
            }
        }
    }

    /**
     * Date
     * Assign the date of enrollment to the team
     * @param date 
     */
    @Override
    public void buildInscription(LocalDate date) {
        team.setDateInscription(date);
    }

    /**
     * Validations of the team
     * It performs a series of validations that if fulfilled, it is stored in a String variable that is then thrown to the user
     * @return team
     * @throws InvalidDataException 
     */
    @Override
    public Team getTeam() throws InvalidDataException {
        String txt = "";
        pattern = Pattern.compile("^[a-zA-Z ]{2,10}$");
        matcher = pattern.matcher(team.getTeamName());
        if (!matcher.find()) {
            txt += "El nombre del equipo debe tener entre dos y diez caracteres y no puede"
                    + " contener números ni caracteres especiales (solamente el espacio).\n";
        }
        if (TeamList.getInstance().searchTeam(team.getTeamName()) != null) {
            txt += "Este equipo ya existe.\n";
        }
        if (team.getDateInscription() == null) {
            txt += "La Fecha de inscripción no puede ser nula.\n";
        }
        if (team.getPlayersList().size() < 3) {
            txt += "Debe tener al menos 3 jugadores.\n";
        }
        if (!txt.equals("")) {
            throw new InvalidDataException(txt);
        }
        return team;
    }
}
