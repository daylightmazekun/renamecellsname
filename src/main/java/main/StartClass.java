package main;


import action.actionImp.RenameItImp;
import bean.Cells;
import constants.ReanmeCellsConstants;

public class StartClass {
    public static void main(String args[]) {
        Cells cells = new Cells();
        cells.setPath(ReanmeCellsConstants.PATH);
        RenameItImp renameItImp = new RenameItImp();
        renameItImp.traverseFolder(cells);
    }
}
