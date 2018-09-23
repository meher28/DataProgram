package chapter.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.map.MultiValueMap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import chapter.dto.PortfolioRecord;

public class CSVReader {

	public static void main(String[] args) {

		try {
			CsvToBean csvRecords = new CsvToBeanBuilder(new FileReader(
					"C:\\Users\\meher\\workspace_mars\\DataProgram\\src\\main\\resources\\portfolio_records.csv"))
							.withType(PortfolioRecord.class).build();

			List<PortfolioRecord> recordsList = csvRecords.parse();

			MultiValueMap recordsFundList = new MultiValueMap();

			HashMap<String, PortfolioRecord> recordByText = new HashMap();

			for (PortfolioRecord portfolioRecord : recordsList) {
				recordsFundList.put(portfolioRecord.getPortfolioCode(), portfolioRecord);
			}

			System.out.println(recordsFundList.get("300"));

			Collection<PortfolioRecord> profile100 = recordsFundList.getCollection("300");

			for (PortfolioRecord record : profile100) {
				if (record.getShareClassISIN().equals("")) {
					record.setShareClassISIN("TOP_LEVEL_FUND");
				}
				System.out.println(
						record.getPortfolioCode() + " : " + record.getReport() + " : " + record.getShareClassISIN());
			}

			Set<String> uniqueProfileCodes = recordsFundList.keySet();

			for (String profileKeys : uniqueProfileCodes) {
				System.out.println("Unique ProfileCode : " + profileKeys);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
