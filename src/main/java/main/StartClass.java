package main;


import action.actionImp.RenameItImp;
import bean.Cells;
import constants.ReanmeCellsConstants;

import java.util.HashMap;

public class StartClass {
    public static void main(String args[]) {
        Cells cells = new Cells();
        cells.setPath(ReanmeCellsConstants.PATH);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("sai0025","GG");
        cells.setHashMap(hashMap);
        RenameItImp renameItImp = new RenameItImp();
        renameItImp.traverseFolder(cells);
    }
}
