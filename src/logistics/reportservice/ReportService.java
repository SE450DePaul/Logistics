package logistics.reportservice;

import java.text.DecimalFormat;
import java.util.Set;

import logistics.facilityservice.FacilityService;
import logistics.inventoryservice.InventoryService;
import logistics.itemservice.ItemCatalogService;
import logistics.networkservice.NetworkService;
import logistics.utilities.exceptions.FacilityNotFoundInNetworkException;
import logistics.utilities.exceptions.NeighborNotFoundInNetworkException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * 
 * @author David Olorundare
 *
 */

//Strategy: First hardcode this, test it works, and then work 
// backwards till it works un-hardcoded/dynamically and is properly structured.


public class ReportService 
{
	// Initialize and setup a bunch of stuff
	
	private volatile static ReportService instance;
	ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();
	NetworkService networkService = NetworkService.getInstance();
	FacilityService facilityService = FacilityService.getInstance();
	InventoryService inventoryService = InventoryService.getInstance();
		
	
	public static ReportService getInstance()
    {
        if (instance == null)
        {
            synchronized (ReportService.class)
            {
                if (instance == null)
                {
                    instance = new ReportService();
                }
            }
        }
        return instance;
    }

	
	
	
	
	
	
	
	// will probably make this its own class.
	// iterate and output facility and inventory details for EACH facility
	public void facilityOutput()
	{
		// Facility output should use an iterator of some sort,
		// make use of the Facility and Inventory Service APIs
				System.out.println("--------------------------------------------------------------------------");
				
				//this should be in a try block
				Set<String> facilities = facilityService.getFacilities();
				
				try
				{
					for (String facility : facilities)
			        {
			        	System.out.println(facilityService.getOutput(facility));
			        	System.out.println("Direct Links:");
						System.out.println(networkService.getOutput(facility));
						System.out.println(inventoryService.getOutput(facility));
						// Schedule Manager getOutput code goes here
						System.out.println("Schedule: \n");
			        }
				}
				catch (FacilityNotFoundInNetworkException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*
				
				// generate SCHEDULE for facility using Schedule Manager API
				System.out.println("\nSchedule: ");
				// generate SCHEDULE day using API
				System.out.println("Day: \t\t1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
				// generate SCHEDULE availability using API
				System.out.println("Available: \t10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10");
				// facility output ends here
				System.out.print("------------------------------------------------------------------------------");
				
		//facilityService.getOutput(name)*/
	}
	
	// display item catalog output
	public void itemCatalogOutput()
	{
		System.out.println("\n\nItem Catalog: ");
		
		
		/*// don't forget to make the formatting dynamic
		
		System.out.println("\n\nItem Catalog: ");
		// use an iterator structure to generate item details using ItemCatalog Service APIs
		System.out.println("ABC123\t: $550\t\tCR2032\t: $240\t\tCT1928\t: $910\t\tE241i\t: $10,400");
		System.out.println("JBL3100\t: $180\t\tMM35P\t: $1,950\tPL132-C\t: $440\t\tPU238\t: $2,200");
		System.out.println("JBL3100\t: $180\t\tMM35P\t: $1,950\tPL132-C\t: $440\t\tPU238\t: $2,200");
		System.out.println("RL123A\t: $360\t\tRTF110\t: $715\t\tRX100-3\t: $642\t\tSN-241-L: $620");
		System.out.println("SR71-D\t: $1,600\tXLK200B\t: $820\t\tXTP202\t: $345\t\tZTF109\t: $1,100");	
		// end output of item catalog for facility*/
	}
	
	// display shortest path test output
	public void shortestPathOutput() 
	{
		System.out.println("\nShortest Path Tests:\n");
		
		System.out.println("a) Santa Fe, NM to Chicago, IL:");
		networkService.displayFacilityPathInfo("Santa Fe, NM", "Chicago, IL");
		
		System.out.println("b) Atlanta, GA to St. Louis, MO:");
		networkService.displayFacilityPathInfo("Atlanta, GA", "St. Louis, MO");
		
		System.out.println("c) Seattle, WA to Nashville, TN:");
		networkService.displayFacilityPathInfo("Seattle, WA", "Nashville, TN");
		
		System.out.println("d) New York City, NY to Phoenix, AZ:");
		networkService.displayFacilityPathInfo("New York City, NY", "Phoenix, AZ"); 
		
		System.out.println("e) Fargo, ND to Austin, TX:");
		networkService.displayFacilityPathInfo("Fargo, ND", "Austin, TX");
		
		System.out.println("f) Denver, CO to Miami, FL:");
		networkService.displayFacilityPathInfo("Denver, CO", "Miami, FL");
		
		System.out.println("g) Austin, TX to Norfolk, VA:");
		networkService.displayFacilityPathInfo("Austin, TX", "Norfolk, VA");
		
		System.out.println("h) Miami, FL to Seattle, WA:");
		networkService.displayFacilityPathInfo("Miami, FL", "Seattle, WA");
		
		System.out.println("i) Los Angeles, CA to Chicago, IL:");
		networkService.displayFacilityPathInfo("Los Angeles, CA", "Chicago, IL");
		
		System.out.println("j) Detroit, MI to Nashville, TN:");
		networkService.displayFacilityPathInfo("Detroit, MI", "Nashville, TN"); 
	}
	
	public static void main(String[] args)
	{
		//TO-DO: Need to create a dedicated display 
		// method for each of the three parts of the output
		
		ReportService reportService = ReportService.getInstance();
		
		reportService.facilityOutput();
		System.out.println("---------------------------------------------------------------------------");
		reportService.itemCatalogOutput();
		System.out.println("---------------------------------------------------------------------------");
		reportService.shortestPathOutput();
	}
}
