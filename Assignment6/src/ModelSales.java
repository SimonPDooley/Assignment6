import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ModelSales {
	private int sales;
	private YearMonth salesMonth;

	public ModelSales() {

	}

	public ModelSales(String salesMonth,  String sales) {
		this.sales = Integer.parseInt(sales);
		this.salesMonth = YearMonth.parse(salesMonth , DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH));
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public YearMonth getSalesMonth() {
		return salesMonth;
	}

	public void setSalesMonth(YearMonth salesMonth) {
		this.salesMonth = salesMonth;
	}
	
	public Integer getYear() {
		return salesMonth.getYear();
	}

	@Override
	public String toString() {
		return salesMonth + " -> " + sales;
	}
	
	
}