import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadService {
	
	//Add elements from csv file to a list of ModelSales objects
	public List<ModelSales> ReadFile(List<ModelSales> modelSales, String modelFileName) throws FileNotFoundException, IOException {
		// Read in the text file
	
			BufferedReader reader = new BufferedReader(new FileReader(modelFileName+".csv"));
			String line;
			//Skip file header
			reader.readLine();
			//Fill List using model sales files
			while ((line = reader.readLine()) != null) {
				String[] salesParsed = line.split(",");
				modelSales.add(new ModelSales(salesParsed[0], salesParsed[1]));
			}
			reader.close();
			return modelSales;
		} 			
	
	public void getSalesForYear(List<ModelSales> modelSales, int year) {
		Integer salesForYear = modelSales
			.stream()
			.filter(x -> x.getSalesMonth().isAfter(YearMonth.of(year-1, 12)))
			.filter(x -> x.getSalesMonth().isBefore(YearMonth.of(year+1, 01)))
			.map(x -> x.getSales())
			.collect(Collectors.summingInt(Integer::intValue));
		
		System.out.println(year + " -> " + salesForYear);
								
	}

	
	public void bestSalesMonth(List<ModelSales> modelSales, String modelName) {
		YearMonth maxSales = modelSales
			.stream()
			.max(Comparator.comparing(ModelSales::getSales))
			.map(x -> x.getSalesMonth())
			.get();
		
		System.out.println("");
		System.out.println("The best month for " + modelName + "was : " + maxSales);
	}
	
	public void worstSalesMonth(List<ModelSales> modelSales, String modelName) {
		YearMonth minSales = modelSales
			.stream()
			.min(Comparator.comparing(ModelSales::getSales))
			.map(x -> x.getSalesMonth())
			.get();
		
		System.out.println("The worst month for " + modelName + "was : " + minSales);
		System.out.println("");
	}
}

