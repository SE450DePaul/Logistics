import logistics.reportservice.ReportService;

/**
 * 
 * @author David Olorundare and Uchenna F. Okoye
 *
 */
// This should be the main class of the application

public class Logistics 
{
	// Should initialize all the services: Facility, Item, Inventory, Network, Report

	// SHOULD SOMETHING BE HERE ?
	
	// call the Report service to generate all required output
	public static void main(String[] args)
	{
		ReportService reportService = ReportService.getInstance();
		reportService.reportEverything();
		
	}
	
	
}
