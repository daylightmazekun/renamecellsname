package action.actionImp;

import action.RenameIt;

import bean.Cells;
import constants.ReanmeCellsConstants;
import org.apache.log4j.Logger;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.Iterator;

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
                        if (file2.getAbsolutePath().endsWith(ReanmeCellsConstants.EXCEL_XLSM)) {
                            try {
                                //初始化输入流
                                InputStream is = new FileInputStream(file2.getAbsolutePath());

                                //创建Excel,并指定Excel读取位置
                                XSSFWorkbook workbook = new XSSFWorkbook(is);
                                is.close();
                                XSSFSheet sheet = null;
                                //获取每个Sheet表
                                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
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
                                                if (row.getCell(k) != null) {
                                                    Iterator<String> iter = cells.getHashMap().keySet().iterator();
                                                    while (iter.hasNext()) {
                                                        String key = iter.next();
                                                        //String value = cells.getHashMap().get(key);
                                                        if (logger.isDebugEnabled()) {
                                                            logger.debug("row.getCell(k)" + row.getCell(k));
                                                            logger.debug("key" + key);
                                                        }
                                                        if (key.equals(row.getCell(k).toString())) {
                                                            FileOutputStream out = new FileOutputStream(file2.toString());
                                                            //替换
                                                            row.createCell(k).setCellValue(cells.getHashMap().get(key));
                                                            out.flush();
                                                            workbook.write(out);
                                                            out.close();
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else if (file2.getAbsolutePath().endsWith(ReanmeCellsConstants.EXCEL_XLS)) {
                            {
                                try {
                                    //初始化输入流
                                    InputStream is = new FileInputStream(file2.getAbsolutePath());

                                    //创建Excel,并指定Excel读取位置
                                    HSSFWorkbook workbook = new HSSFWorkbook(is);
                                    is.close();
                                    HSSFSheet sheet = null;
                                    //获取每个Sheet表
                                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                                        sheet = workbook.getSheetAt(i);
                                        //获取每行
                                        for (int j = 0; j < sheet.getLastRowNum(); j++) {
                                            if (logger.isDebugEnabled()) {
                                                logger.debug("共几行" + sheet.getLastRowNum());
                                            }
                                            Row row = sheet.getRow(j);
                                            if (row != null) {
                                                //获取每个单元格
                                                for (int k = 0; k < row.getLastCellNum(); k++) {
                                                    if (logger.isDebugEnabled()) {
                                                        logger.debug("单元格" + row.getCell(k));
                                                    }
                                                    if (row.getCell(k) != null) {
                                                        Iterator<String> iter = cells.getHashMap().keySet().iterator();
                                                        while (iter.hasNext()) {
                                                            String key = iter.next();
                                                            //String value = cells.getHashMap().get(key);
                                                            if (logger.isDebugEnabled()) {
                                                                logger.debug("row.getCell(k)" + row.getCell(k));
                                                                logger.debug("key" + key);
                                                            }
                                                            if (key.equals(row.getCell(k).toString())) {
                                                                FileOutputStream out = new FileOutputStream(file2.toString());
                                                                //替换
                                                                row.createCell(k).setCellValue(cells.getHashMap().get(key));
                                                                out.flush();
                                                                workbook.write(out);
                                                                out.close();
                                                            }

                                                        }
                                                    }
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
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("文件不存在!");
            }
        }
    }


}
