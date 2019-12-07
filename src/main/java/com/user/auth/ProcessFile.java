package com.user.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ProcessFile {

	public void readFile() throws IOException {
		System.out.println("---Inside readFile -----");
		List<User> userList = new ArrayList<User>();
		File myFile = new File("C:\\Users\\LENOVO\\Downloads\\poc\\authsystem\\src\\main\\resources\\User.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
   
        Iterator<Row> rowIterator = mySheet.iterator();
       
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                User user = new User();
                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t");
                    break;
                default :
             
                }
                userList.add(user);
            }
            System.out.println("");
        }
	}
}
