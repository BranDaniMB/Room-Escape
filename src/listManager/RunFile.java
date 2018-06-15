/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import builderteam.InvalidDataException;
import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jermy
 */
public class RunFile {

    FilesManagerList listManager = new FilesManagerList();
    FilesManagerListRiddles listRiddles = new FilesManagerListRiddles();
    PropertiesConfig config = new PropertiesConfig ();
    
    public void charmingReadFile() {
        listManager.readFile("filesManager.dat");
        listRiddles.readFile("filesRiddle.dat");
        config.readConfig();
    }

    public void charmingWriteFile() {
        listManager.writeFile("/files/filesManager.dat", TeamList.getInstance());
        listRiddles.writeFile("/files/filesManager.dat", ListRoomRiddle.getInstance());
    }
    
    

}
