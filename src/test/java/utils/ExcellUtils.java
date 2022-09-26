package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcellUtils {
    private Workbook workbook;
    private Sheet sheet;
    private String path;
    public ExcellUtils(String path, String sheetN){
        this.path = path;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
