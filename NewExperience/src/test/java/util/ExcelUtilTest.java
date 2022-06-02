package util;

import java.io.IOException;

public class ExcelUtilTest {

    public static void main(String[] args) throws IOException {

        // String excelPath = "src/test/resources/data/Data.xlsx";
        String scheetName = "login";

        ExcelUtils excelUtils = new ExcelUtils(scheetName);

        excelUtils.getRowCount();
        excelUtils.getStringCellData(2, 0);
        excelUtils.getStringCellData(2, 1);
        excelUtils.readExcel();

    }

}
