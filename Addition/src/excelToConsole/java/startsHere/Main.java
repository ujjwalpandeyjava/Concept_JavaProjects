package startsHere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
//	static String fileNamePath = "C:\\All files\\Workspace\\Eclipse\\ExcelToConsole\\src\\main\\java\\filesToScan\\excelFile.xlsx";
	static String fileNamePath = "..\\filesToSca\\excelFile.xlsx";

	public static void main(String[] args) throws IOException {
		File file = new File(fileNamePath);
		FileInputStream fInputStream = new FileInputStream(file);
		XSSFWorkbook xswb = new XSSFWorkbook(fInputStream);
		Iterator<Sheet> sheetIterator = xswb.sheetIterator();
		int sheetNo = 0;
		while (sheetIterator.hasNext()) {
			sheetNo++;
			Sheet next = sheetIterator.next();
			System.out.println("\n+------------------------------------- Data of Sheet " + sheetNo + " :- "
					+ next.getSheetName() + " -------------------------------------+\n");
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
				System.out.println();
			}
		}
		xswb.close();
	}
}
