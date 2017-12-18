package action.actionImp;

import action.RenameIt;

import bean.Cells;
import constants.ReanmeCellsConstants;
import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RenameItImp implements RenameIt {

    private static Logger logger = Logger.getLogger(RenameIt.class);

    @Override
    public void traverseFolder(Cells cells) {
        File file = new File(cells.getPath());
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                if (logger.isDebugEnabled()) {
                    logger.debug("文件夹是空的!");
                }
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("文件夹:" + file2.getAbsolutePath());
                        }
                        cells.setPath(file2.getAbsolutePath());
                        traverseFolder(cells);

                    } else {
                        if (logger.isDebugEnabled()) {
                            logger.debug("文件:" + file2.getAbsolutePath());
                        }
                        if (this.checkExcelVaild(file2)) {
                            try {
                                //初始化输入流
                                FileInputStream is = new FileInputStream(file2.toString());
                                //创建Excel,并指定Excel读取位置
                                XSSFWorkbook workbook = new XSSFWorkbook(is);
                                XSSFSheet sheet = null;
                                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
                                    sheet = workbook.getSheetAt(i);
                                    for (int j = 0; j < sheet.getLastRowNum(); j++) {//获取每行
                                        if (logger.isDebugEnabled()) {
                                            logger.debug("共几行" + sheet.getLastRowNum());
                                        }
                                        Row row = sheet.getRow(j);
                                        if (row != null) {
                                            for (int k = 0; k < row.getLastCellNum(); k++) {//获取每个单元格
                                                if (logger.isDebugEnabled()) {
                                                    logger.debug("单元格" + row.getCell(k));
                                                }
                                                if(row.getCell(k) != null) replaceCells();
                                            }
                                        }
                                    }
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("文件不存在!");
            }
        }
    }

    @Override
    public Boolean checkExcelVaild(File file) {
        if (file.getName().endsWith(ReanmeCellsConstants.EXCEL_XLS) ||
                file.getName().endsWith(ReanmeCellsConstants.EXCEL_XLSX) ||
                file.getName().endsWith(ReanmeCellsConstants.EXCEL_XLSM)) {
            return true;
        } else {
            return false;
        }
    }

}
