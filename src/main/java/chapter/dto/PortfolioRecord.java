package chapter.dto;

public class PortfolioRecord {

	private String Product, PortfolioCode, QuasarCode, ShareClassISIN, date, Report;

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
