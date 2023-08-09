package excelToConsole;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToConsole {
	//	fileNamePath = " C:/Users/ujjwa/All Files/Workspace/Eclipse/Additional_Practice/src/main/java/excelToConsole/excelFile.xlsx";
	public static void main(String[] args) throws IOException {
		String relative = Paths.get("./src/main/java/excelToConsole/excelFile.xlsx").toRealPath().toString();
		System.out.println(relative);
		File file = new File(relative);
		FileInputStream fInputStream = new FileInputStream(file);
		XSSFWorkbook xswb = new XSSFWorkbook(fInputStream);
		Iterator<Sheet> sheetIterator = xswb.sheetIterator();
		int sheetNo = 0;
		while (sheetIterator.hasNext()) {
			sheetNo++;
			Sheet next = sheetIterator.next();
			System.out.println("------------------------------------- Data of Sheet " + sheetNo + " :- "
					+ next.getSheetName() + " -------------------------------------\n\n\n");
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Row> rowIterator = next.rowIterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				int lastCellIndex = row.getLastCellNum();
				for (int i = 0; i < lastCellIndex; i++) {
					String cellValue2 = row.getCell(i) == null ? " " : dataFormatter.formatCellValue(row.getCell(i));
					String tab = cellValue2.length() < 8 ? "\t|" : "|";
					System.out.print(cellValue2 + tab);
				}
				System.out.println("");
			}
		}
		xswb.close();
	}
}
