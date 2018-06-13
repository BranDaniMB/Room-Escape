/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import builderteam.InvalidDataException;
import files.FilesManagerList;
import files.FilesManagerListRiddles;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jermy
 */
public class Test {

    public static void main(String[] args) {
        try {
             FilesManagerList listManager = new FilesManagerList();
             FilesManagerListRiddles listRiddles= new FilesManagerListRiddles();
             
             
             listManager.readFile("filesManager.dat");
             listManager.writeFile("filesManager.dat", TeamList.getInstance());
             
             
            buildPlayers("brandons");
        } catch (InvalidDataException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void buildPlayers(String id) throws InvalidDataException {
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("^[a-zA-Z ]{2,10}$");
        matcher = pattern.matcher(id);
        if (matcher.find()) {
            if (TeamList.getInstance().searchTeam(id) == null) {
                System.out.println(id);
            }
        }
    }
}
