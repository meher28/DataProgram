package chapter.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import chapter.dto.PortfolioRecordWithPositionBinding;

public class CSVReaderWithPositionBinder {

	private static String csvFile;

	public static void main(String[] args) {
		try {

			ColumnPositionMappingStrategy<PortfolioRecordWithPositionBinding> cpms = new ColumnPositionMappingStrategy<PortfolioRecordWithPositionBinding>();
			cpms.setType(PortfolioRecordWithPositionBinding.class);

			csvFile = "C:\\Users\\meher\\workspace_mars\\DataProgram\\src\\main\\resources\\portfolio_records_001.csv";
			CsvToBean<PortfolioRecordWithPositionBinding> csvRecords = new CsvToBeanBuilder<PortfolioRecordWithPositionBinding>(new FileReader(csvFile))
					.withType(PortfolioRecordWithPositionBinding.class)
					.withMappingStrategy(cpms)
					.build();

			List<PortfolioRecordWithPositionBinding> recordsList = csvRecords.parse();

			for (PortfolioRecordWithPositionBinding record : recordsList) {
				System.out.println(record.toString());
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
