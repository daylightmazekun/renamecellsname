package main;


import action.actionImp.RenameItImp;
import bean.Cells;
import constants.RenameCellsConstants;

import java.util.HashMap;

public class StartClass {
    public static void main(String args[]) {
        Cells cells = new Cells();
        cells.setPath(RenameCellsConstants.PATH);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("GG","sssss");
        cells.setHashMap(hashMap);
        RenameItImp renameItImp = new RenameItImp();
        renameItImp.traverseFolder(cells);
    }
}
