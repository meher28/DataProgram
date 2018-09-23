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
import chapter.dto.PortfolioRecordWithBinding;

public class CSVReaderWithBinder {

	public static void main(String[] args) {

		try {
			CsvToBean csvRecords = new CsvToBeanBuilder(new FileReader(
					"C:\\Users\\meher\\workspace_mars\\DataProgram\\src\\main\\resources\\portfolio_records.csv"))
							.withType(PortfolioRecordWithBinding.class).build();

			List<PortfolioRecordWithBinding> recordsList = csvRecords.parse();

			MultiValueMap recordsFundList = new MultiValueMap();

			HashMap<String, PortfolioRecordWithBinding> recordByText = new HashMap();

			for (PortfolioRecordWithBinding portfolioRecord : recordsList) {
				recordsFundList.put(portfolioRecord.getPortfolioCode(), portfolioRecord);
			}

			System.out.println(recordsFundList.get("100"));

			Collection<PortfolioRecordWithBinding> profile100 = recordsFundList.getCollection("100");

			for (PortfolioRecordWithBinding record : profile100) {
				if (record.getShareClassISIN().equals("")) {
					record.setShareClassISIN("TOP_LEVEL_FUND");
				}
				System.out.println(record.getPortfolioCode() + " : " + record.getReport() + " : "
						+ record.getShareClassISIN() + " : " + record.getDateFormatted().getYear());
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
