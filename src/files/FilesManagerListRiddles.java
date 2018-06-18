package files;

import gui.rooms.Room1;
import gui.rooms.Room2;
import gui.rooms.Room3;
import gui.rooms.Room4;
import gui.rooms.Room5;
import gui.rooms.Room6;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import objects.Riddle;
import objects.RoomRiddle;
import objects.TrackLocked;

/**
 * Binary riddle file
 * Save the game riddles
 * @author Jermy
 */
public class FilesManagerListRiddles {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    /**
     * Open file
     * Open the file where the list of riddles is
     * @param fileName
     * @throws IOException 
     */
    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    /**
     * Reading riddles
     * Read the list of riddles
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private ArrayList<RoomRiddle> read() throws IOException, ClassNotFoundException {
        return (ArrayList<RoomRiddle>) reader.readObject();
    }

    /**
     * Close read
     * Close the reading of the list of riddles
     * @throws IOException 
     */
    private void closeReader() throws IOException {
        reader.close();
    }

    /**
     * Open write
     * This method opens the writing of riddles to the file
     * @param fileName
     * @throws IOException 
     */
    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    /**
     * Writing
     * Write new elements to the file
     * @param element
     * @throws IOException 
     */
    private void write(ArrayList<RoomRiddle> element) throws IOException {
        writer.writeObject(element);
    }

    /**
     * Writing closing
     * Close the writing of elements in the file
     * @throws IOException 
     */
    private void closeWriter() throws IOException {
        writer.close();
    }
    /**
     * File reading
     * It is responsible for opening the file, reading it and closing it.
     * @param fileName
     * @return 
     */

    public ArrayList<RoomRiddle> readFile(String fileName) {
        ArrayList<RoomRiddle> listRiddle = new ArrayList<>();
        try {
            openReader(fileName);
            listRiddle = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Creando archivos");
            ArrayList<RoomRiddle> roomRiddles = chargeRiddles();
            writeFile("Files/RiddlesList.ser", roomRiddles);
            System.err.println("Creados");
            return roomRiddles;
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return listRiddle;
    }

    /**
     * File write
     * It is responsible for opening the file, writing the new elements, guards them and closing them.
     * @param fileName
     * @param listRiddle 
     */
    private void writeFile(String fileName, ArrayList<RoomRiddle> listRiddle) {
        try {
            openWriter(fileName);
            write(listRiddle);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Load riddles
     * He is responsible for loading the riddles and inserts them in a list of all the riddles of the game
     * @return Lis Riddles
     */
    private ArrayList<RoomRiddle> chargeRiddles() {
        ArrayList<RoomRiddle> listRiddles = new ArrayList<>();
        //#1.1
        RoomRiddle roomRiddle = new RoomRiddle(new Room1());
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("Es tangible");
        tracks.add("Es parte del día a día humano");
        roomRiddle.addRiddleGame(new Riddle("En mí trabajan mujeres y hombres: ellos me muelen, "
                + "ellas me escogen; \nsi estoy presente hay gran contento y si no estoy hay gran descontento en donde no estoy.",
                "pan", tracks, new TrackLocked("si", "¿Es comestible?", "Es buen acompañamiento casi para cualquier cosa.")));
        //#1.2
        tracks = new ArrayList<>();
        tracks.add("Con el viento me voy");
        tracks.add("Con el agua hago buen complemento");
        roomRiddle.addRiddleGame(new Riddle("Blanca soy, y como dice mi vecina, útil siempre soy en la cocina.", "harina", tracks,
                new TrackLocked("cuatro", "¿Cantidad de mesas?", "Me miden por tazas")));
        //#1.3
        tracks = new ArrayList<>();
        tracks.add("Es blanco por fuera");
        tracks.add("No tengo un buen olor");
        roomRiddle.addRiddleGame(new Riddle("¿Tiene dientes y no come, tiene cabeza y no es hombre?", "ajo", tracks,
                new TrackLocked("cinco", "¿Cantidad de notas?", "Estoy cubierto con una especie de hojas")));
        //#1.4
        tracks = new ArrayList<>();
        tracks.add("Soy transparente");
        tracks.add("Indispensable para la humanos");
        roomRiddle.addRiddleGame(new Riddle("¿Cuánto más me lavo, más sucia estoy?", "agua", tracks,
                new TrackLocked("horno", "¿El objeto mas importante de la sala?", "Soy vida")));
        listRiddles.add(roomRiddle);

        //#2.1
        roomRiddle = new RoomRiddle(new Room2());
        tracks.add("Soy sumamente útil");
        tracks.add("Tiene diferentes tamaños");
        roomRiddle.addRiddleGame(new Riddle("¿Sube llena, baja vacía, y si no se da prisa, la sopa se enfría?", "cuchara", tracks,
                new TrackLocked("cinco", "¿Cantidad de sacos?", "En toda cocina hay")));
        //#2.2
        tracks = new ArrayList<>();
        tracks.add("Casi siempre anda con uno");
        tracks.add("Es de metal");
        roomRiddle.addRiddleGame(new Riddle("¿Chiquita como un ratón, guarda la casa como un león?", "llave", tracks,
                new TrackLocked("ocho", "¿Cantidad de bombillos?", "Es única")));
        //"2.3
        tracks = new ArrayList<>();
        tracks.add("Soy suave");
        tracks.add("Soy bastante confortable");
        roomRiddle.addRiddleGame(new Riddle("¿es muy usado?", "sillón", tracks,
                new TrackLocked("ocho", "¿Cantidad de tazas?", "Todos descansan en mí, casi no me muevo")));
        //2.4
        tracks = new ArrayList<>();
        tracks.add("Guardo suciedad");
        tracks.add("Siempre andamos por el suelo de alcobas y de salones");
        roomRiddle.addRiddleGame(new Riddle("Tengo una forma geométrica", "alfombra", tracks,
                new TrackLocked("cajeros", "¿Hay dos presentes?", "A veces estoy en las entras o en salas de estar")));
        listRiddles.add(roomRiddle);

        //#3.1
        roomRiddle = new RoomRiddle(new Room3());
        tracks.add("Soy indispensable para desplazarse");
        tracks.add("A veces en mi interior tengo mal olor");
        roomRiddle.addRiddleGame(new Riddle("¿Dos hermanitos muy igualitos, si llegan a viejos abren los ojitos?", "zapatos", tracks,
                new TrackLocked("secadora", "¿Esta frente al espejo?", "Tengo un compañero inseparable")));
        //#3.2
        tracks = new ArrayList<>();
        tracks.add("Todas las personas me usan");
        tracks.add("Las mujeres les en canta comprarme");
        roomRiddle.addRiddleGame(new Riddle("Yo te protejo del frío y de los rayos del sol; no soy gorra ni sombrero, pero te cubro mejor", "ropa", tracks,
                new TrackLocked("cajero", "¿Esta en el escritorio", "Segunda la temporada tengo un estilo")));
        //"3.3
        tracks = new ArrayList<>();
        tracks.add("Protejo del frio o de sustancias");
        tracks.add("Soy de latex o de lana");
        roomRiddle.addRiddleGame(new Riddle("Dos guaridas cálidas con sus escondrijos, para dos hermanos y sus quintillizos", "guantes", tracks,
                new TrackLocked("palmeras", "Hay dos en el escenario", "Los doctores casi siempre me usan")));
        //3.4
        tracks = new ArrayList<>();
        tracks.add("Para ir al trabajo me usan");
        tracks.add("Nunca paso de moda");
        roomRiddle.addRiddleGame(new Riddle("Casi siempre me veo bien con cualquier atuendo", "pantalón", tracks,
                new TrackLocked("naranja", "¿Color del abrigo del mostrador?", "Aunque tenemos dos piernas no podemos caminar")));
        listRiddles.add(roomRiddle);
        //#4.1
        roomRiddle = new RoomRiddle(new Room4());
        tracks.add("Son blancos");
        tracks.add("Tienen un figura rectangular");
        roomRiddle.addRiddleGame(new Riddle("Veintiocho caballeros, que se ponen en la mesa", "domino", tracks,
                new TrackLocked("1", "¿Cantidad de bolas de fútbol?", "Juego de mesa")));
        //#4.2
        tracks = new ArrayList<>();
        tracks.add("Existe hace mucho tiempo");
        tracks.add("Me controlan con una cuerda");
        roomRiddle.addRiddleGame(new Riddle("Subo y bajo. A los niños divierto", "yoyo", tracks,
                new TrackLocked("4", "¿Cantidad de ventanas presentes en la habitación", "Soy redondo")));
        //"4.3
        tracks = new ArrayList<>();
        tracks.add("Han hecho muchas películas de nosotros");
        tracks.add("Soy muy grande");
        roomRiddle.addRiddleGame(new Riddle("Le gustamos a la mayoría de las personas", "dinosaurios", tracks,
                new TrackLocked("cofre", "Contiene un secreto y está debajo una bandera", "Fuimos los primeros en existir en la tierra.")));
        //4.4
        tracks = new ArrayList<>();
        tracks.add("Para ir al trabajo me usan");
        tracks.add("Los niños nos piden como juguetes");
        roomRiddle.addRiddleGame(new Riddle("Somos indispensables para la humanidad.", "carros", tracks,
                new TrackLocked("3", "¿Cantidad de uñas que tiene la huella?", "Con nosotros hacen carreras")));
        listRiddles.add(roomRiddle);

        //5.1
        roomRiddle = new RoomRiddle(new Room5());
        tracks = new ArrayList<>();
        tracks.add("Me encargo de múltiples tareas");
        tracks.add("En toda oficina me encuentro.");
        roomRiddle.addRiddleGame(new Riddle("Ocupo de electricidad para funcionar.", "computadora", tracks,
                new TrackLocked("caña de pescar", "¿Mucha gente usa este instrumento para ganarse la vida en el mar?", "Me volví una herramienta de trabajo muy importante.")));

        //5.2
        tracks = new ArrayList<>();
        tracks.add("Soy como una pera");
        tracks.add("Me caliento bastante.");
        roomRiddle.addRiddleGame(new Riddle("Me encuentro en dentro de la casa.", "bombillo", tracks,
                new TrackLocked("verde", "¿Color del basurero?", "Venzo a la oscuridad")));

        //5.3
        tracks = new ArrayList<>();
        tracks.add("Soy sensible al agua");
        tracks.add("Me encuentran en las bibliotecas.");
        roomRiddle.addRiddleGame(new Riddle("Conservo mucha información en mi interior.", "libro", tracks,
                new TrackLocked("hojas", "¿Que cosa esta prensada con un libro?", "Todas las palabras sé aunque nunca las pronunciaré")));

        //5.4
        tracks = new ArrayList<>();
        tracks.add("Me encuentro en los rincones.");
        tracks.add("Estoy presente en oficinas, escuelas, colegios etc..");
        roomRiddle.addRiddleGame(new Riddle("Almaceno historias desechadas.", "basurero", tracks,
                new TrackLocked("3", "¿Cantidad de animales presentes en la habitación?", "Sin mí la basura sería un caos")));
        listRiddles.add(roomRiddle);
        //6.1
        roomRiddle = new RoomRiddle(new Room6());
        tracks = new ArrayList<>();
        tracks.add("Soy blanco");
        tracks.add("Soy parte de una película muy famosa.");
        roomRiddle.addRiddleGame(new Riddle("Me encuentro en los mares polares.", "iceberg", tracks,
                new TrackLocked("8", "¿Cantidad de cajas de pizza presentes en la habitación?", "Solo pueden ver mi cima, me gusta el frío")));
        //6.2
        tracks = new ArrayList<>();
        tracks.add("Soy como una gran hoja.");
        tracks.add("Me encuentro virtualmente también.");
        roomRiddle.addRiddleGame(new Riddle("Desde hace mucho tiempo existo.", "mapa", tracks,
                new TrackLocked("10", "¿Cuál es número que aparece en la habitación?", "En mi se puede encontrar cualquier lugar.")));

        //6.3
        tracks = new ArrayList<>();
        tracks.add("Soy redonda.");
        tracks.add("Me hornean.");
        roomRiddle.addRiddleGame(new Riddle("Vengo de la gran bota, le encanto a muchas personas.", "pizza", tracks,
                new TrackLocked("3", "¿Cuantos lápiz aparecen en la habitación?", "Me crearon por primera vez en Nápoles.")));

        //6.4
        tracks = new ArrayList<>();
        tracks.add("Huelo muy bien.");
        tracks.add("Soy muy frágil.");
        roomRiddle.addRiddleGame(new Riddle("Le encanto a humanos e insectos por mi gran belleza y dulzura.", "rosa", tracks,
                new TrackLocked("3", "¿Cuantos almohadas aparecen en la habitación?", "Tengo espinas y a veces no.")));
        listRiddles.add(roomRiddle);

        return listRiddles;
    }
}
