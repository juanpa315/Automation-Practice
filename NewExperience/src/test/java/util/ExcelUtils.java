package util;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String scheetName) {
        try {
            String excelPath = "src/test/resources/data/Data.xlsx";
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(scheetName);

        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    public String getStringCellData(int row, int cell) {

        String stringValue = sheet.getRow(row).getCell(cell).getStringCellValue();

        return stringValue;
    }

    public double getIntCellData(int row, int cell) {

        double numericValue = sheet.getRow(row).getCell(cell).getNumericCellValue();

        return numericValue;
    }

    public boolean getBooleanCellData(int row, int cell) {
        boolean booleanValue = sheet.getRow(row).getCell(cell).getBooleanCellValue();
        return booleanValue;
    }

    public Object getObjectCellData(int row, int cell) throws IOException {

        DataFormatter formatter = new DataFormatter();
        Object objectValue = formatter.formatCellValue(sheet.getRow(row).getCell(cell));

        System.out.println("the value is: " + objectValue);
        return objectValue;

    }

    public void getRowCount() throws IOException {

        System.out.println("the sheet 1 is: " + sheet);
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows: " + rowCount);

    }

    public void readExcel() {
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        System.out.println("The rowCount is: " + rowCount);
        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {

                System.out.println(row.getCell(j).getStringCellValue() + "||");
            }
        }
    }

}
