package chapter.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiValueMap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import chapter.dto.PortfolioRecord;
import chapter.filters.FilterDate;

public class CSVReaderWithFilter {

	public void reader() {
		try {

			HeaderColumnNameMappingStrategy<PortfolioRecord> strategy = new HeaderColumnNameMappingStrategy();
			strategy.setType(PortfolioRecord.class);

			HeaderColumnNameTranslateMappingStrategy<PortfolioRecord> dateStrategy = new HeaderColumnNameTranslateMappingStrategy<PortfolioRecord>();
			dateStrategy.setType(PortfolioRecord.class);
			Map<String, String> columnMap = new HashMap();
			columnMap.put("Product", "Product");
			columnMap.put("PortfolioCode", "PortfolioCode");
			columnMap.put("QuasarCode", "QuasarCode");
			columnMap.put("ShareClassISIN", "ShareClassISIN");
			columnMap.put("date", "date");
			columnMap.put("Report", "Report");
			dateStrategy.setColumnMapping(columnMap);

			

			List<PortfolioRecord> csvRecords = new CsvToBean().parse(dateStrategy,
					new FileReader(
							"C:\\Users\\meher\\workspace_mars\\DataProgram\\src\\main\\resources\\portfolio_records.csv"),
					new FilterDate(dateStrategy));
			for (PortfolioRecord portfolioCode : csvRecords) {
				System.out.println(portfolioCode.toString());
			}


		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CSVReaderWithFilter csvReaderWithFilter = new CSVReaderWithFilter();

		csvReaderWithFilter.reader();

	}

}
