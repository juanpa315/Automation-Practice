package util;

import java.io.IOException;

public class ExcelUtilTest {

    public static void main(String[] args) throws IOException {

        // String excelPath = "src/test/resources/data/Data.xlsx";
        String scheetName = "createAccount";

        ExcelUtils excelUtils = new ExcelUtils(scheetName);

        excelUtils.getRowCount();
        excelUtils.getStringCellData(1, 0);
        excelUtils.getStringCellData(1, 1);
        excelUtils.readExcel();

    }

}
