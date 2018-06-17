package game;

import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import gui.rooms.Room1;
import java.util.ArrayList;
import listManager.ListRoomRiddle;
import listManager.TeamList;
import objects.Riddle;
import objects.RoomRiddle;
import objects.TrackLocked;

/**
 *
 * @author Jermy
 */
public class RoomEscape {

    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        TeamList.getInstance().setTeamsList(FILES_MANAGER_LIST.readFile("Files/TeamList.ser"));
        ListRoomRiddle.getInstance().setListRiddle(FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser"));
        PropertiesConfig.getInstance().readConfig();
//        chargeRiddles();
//        FILES_MANAGER_LIST_RIDDLES.writeFile("Files/RiddlesList.ser", ListRoomRiddle.getInstance().getListRiddle());
        System.out.println(ListRoomRiddle.getInstance().getListRiddle().get(0).toString());
        new Menu().runGui();
    }

    public static void chargeRiddles() {
        //#1.1
        ArrayList<Riddle> riddles = new ArrayList<>();
        ArrayList<String> riddle = new ArrayList<>();
        riddle.add("Es tangible");
        riddle.add("Es parte del día a día humano");
        riddles.add(new Riddle("En mí trabajan mujeres y hombres: ellos me muelen, "
                + "ellas me escogen; \nsi estoy presente hay gran contento y si no estoy hay gran descontento en donde no estoy.",
                "pan", riddle, new TrackLocked("si", "¿Es comestible?", "Es buen acompañamiento casi para cualquier cosa.")));
        //#1.2
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Con el viento me voy");
        riddle.add("Con el agua hago buen complemento");
        riddles.add(new Riddle("Blanca soy, y como dice mi vecina, útil siempre soy en la cocina.", "harina", riddle,
                new TrackLocked("cuatro", "¿Cantidad de mesas?", "Me miden por tazas")));
        //#1.3
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Es blanco por fuera");
        riddle.add("No tengo un buen olor");
        riddles.add(new Riddle("¿Tiene dientes y no come, tiene cabeza y no es hombre?", "ajo", riddle,
                new TrackLocked("cinco", "¿Cantidad de notas?", "Estoy cubierto con una especie de hojas")));
        //#1.4
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Soy transparente");
        riddle.add("Indispensable para la humanos");
        riddles.add(new Riddle("¿Cuánto más me lavo, más sucia estoy?", "agua", riddle,
                new TrackLocked("horno", "¿El objeto mas importante de la sala?", "Soy vida")));
        ListRoomRiddle.getInstance().addRiddle(new RoomRiddle(riddles, new Room1()));

        //#2.1
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Soy sumamente útil");
        riddle.add("Tiene diferentes tamaños");
        riddles.add(new Riddle("¿Sube llena, baja vacía, y si no se da prisa, la sopa se enfría?", "cuchara", riddle,
                new TrackLocked("cinco", "¿Cantidad de sacos?", "En toda cocina hay")));
        //#2.2
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Casi siempre anda con uno");
        riddle.add("Es de metal");
        riddles.add(new Riddle("¿Chiquita como un ratón, guarda la casa como un león?", "llave", riddle,
                new TrackLocked("ocho", "¿Cantidad de bombillos?", "Es única")));
        //"2.3
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Soy suave");
        riddle.add("Soy bastante confortable");
        riddles.add(new Riddle("¿es muy usado?", "sillón", riddle,
                new TrackLocked("ocho", "¿Cantidad de tazas?", "Todos descansan en mí, casi no me muevo")));
        //2.4
        riddle = new ArrayList<>();
        riddles = new ArrayList<>();
        riddle.add("Guardo suciedad");
        riddle.add("Siempre andamos por el suelo de alcobas y de salones");
        riddles.add(new Riddle("Tengo una forma geométrica", "alfombra", riddle,
                new TrackLocked("cajeros", "¿Hay dos presentes?", "A veces estoy en las entras o en salas de estar")));
        ListRoomRiddle.getInstance().addRiddle(new RoomRiddle(riddles, new Room1()));
    }
}
