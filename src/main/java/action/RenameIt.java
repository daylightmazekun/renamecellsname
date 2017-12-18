package action;


import bean.Cells;

import java.io.File;

public interface RenameIt {
    //test string sai0025
    public abstract void traverseFolder(Cells cells);
    // check the file is or not a excel file
     public abstract Boolean checkExcelVaild(File file);
}
