package chapter.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opencsv.bean.CsvBindByName;

public class PortfolioRecordWithBinding {

	@CsvBindByName
	private String Product;

	@CsvBindByName
	private String PortfolioCode;

	@CsvBindByName
	private String QuasarCode;

	@CsvBindByName
	private String ShareClassISIN;

	@CsvBindByName
	private String date;

	@CsvBindByName
	private String Report;

	private Date dateFormatted;

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getPortfolioCode() {
		return PortfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		PortfolioCode = portfolioCode;
	}

	public String getQuasarCode() {
		return QuasarCode;
	}

	public void setQuasarCode(String quasarCode) {
		QuasarCode = quasarCode;
	}

	public String getShareClassISIN() {
		return ShareClassISIN;
	}

	public void setShareClassISIN(String shareClassISIN) {
		ShareClassISIN = shareClassISIN;
	}

	public String getDate() {

		return date;
	}

	public void setDate(String date) {
		this.date = date;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		try {
			dateFormatted = sdf.parse(this.date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	@Override
	public String toString() {
		return "PortfolioRecord [Product=" + Product + ", PortfolioCode=" + PortfolioCode + ", QuasarCode=" + QuasarCode
				+ ", ShareClassISIN=" + ShareClassISIN + ", date=" + date + ", Report=" + Report + "]";
	}

	public Date getDateFormatted() {
		return dateFormatted;
	}

}
