package chapter.dto;

import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class PortfolioRecordWithPositionBinding {

	@CsvBindByName(column = "Product")
	@CsvBindByPosition(position = 0)
	private String Product;

	@CsvBindByName(column = "PortfolioCode")
	@CsvBindByPosition(position = 1)
	private String PortfolioCode;

	@CsvBindByName(column = "QuasarCode")
	@CsvBindByPosition(position = 2)
	private String QuasarCode;

	@CsvBindByName(column = "ShareClassISIN")
	@CsvBindByPosition(position = 3)
	private String ShareClassISIN;

	@CsvBindByName(column = "date")
	@CsvBindByPosition(position = 4)
	private String date;

	// @CsvBindAndJoinByPosition(position = "5,6", elementType = String.class)
	@CsvBindByName(column = "Report")
	// @CsvBindByPosition(position = 5)
	@CsvBindAndJoinByPosition(position = "5,6", required = true, elementType = String.class)
	private String Report;

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

}
