package chapter.filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;

public class FilterDate implements CsvToBeanFilter {

	private final MappingStrategy strategy;

	public FilterDate(MappingStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean allowLine(String[] line) {
		boolean result = false;
		int index = strategy.getColumnIndex("Report");
		String value = line[index];
		int dateIndex = strategy.getColumnIndex("date");
		String dateValue = line[dateIndex];
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Date date = sdf.parse(dateValue);
		Date afterDate;

			afterDate = sdf.parse("04092017");
			 result = date.after(afterDate);
//					 !"IA,EMT".equals(value) && date.after(afterDate);
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
