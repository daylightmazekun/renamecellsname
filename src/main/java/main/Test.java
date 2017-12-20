package main;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String args[]) {
        InputStream is = null;
        try {
            is = new FileInputStream("D:\\javaworkspace\\renamecellsname\\src\\test\\resources\\book1.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            System.out.print(xssfWorkbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
