import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeslaSalesAnalysisApplication {

	public static void main(String[] args) throws IOException {
		
		//Create lists for each of the models
		List<ModelSales> model3Sales = new ArrayList<ModelSales>();
		List<ModelSales> modelSSales = new ArrayList<ModelSales>();
		List<ModelSales> modelXSales = new ArrayList<ModelSales>();
		
		
		String model3 = "model3";
		String modelS = "modelS";
		String modelX = "modelX";

		FileReadService filereadService = new FileReadService();

		filereadService.ReadFile(model3Sales, model3);
		filereadService.ReadFile(modelSSales, modelS);
		filereadService.ReadFile(modelXSales, modelX);

		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");	
		filereadService.getSalesForYear(model3Sales,2017);
		filereadService.getSalesForYear(model3Sales,2018);
		filereadService.getSalesForYear(model3Sales,2019);
								 
		
		filereadService.bestSalesMonth(model3Sales, model3);
		filereadService.worstSalesMonth(model3Sales, model3);
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------------");
		filereadService.getSalesForYear(modelSSales,2016);
		filereadService.getSalesForYear(modelSSales,2017);
		filereadService.getSalesForYear(modelSSales,2018);
		filereadService.getSalesForYear(modelSSales,2019);
		
		filereadService.bestSalesMonth(modelSSales, modelS);
		filereadService.worstSalesMonth(modelSSales, modelS);
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("---------------------------");
		filereadService.getSalesForYear(modelXSales,2016);
		filereadService.getSalesForYear(modelXSales,2017);
		filereadService.getSalesForYear(modelXSales,2018);
		filereadService.getSalesForYear(modelXSales,2019);
								 	
		filereadService.bestSalesMonth(modelXSales, modelX);
		filereadService.worstSalesMonth(modelXSales, modelX);
	}
}
