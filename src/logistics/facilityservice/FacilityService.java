package logistics.facilityservice;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Uchenna F. Okoye
 */
public final class FacilityService
{
    private volatile static FacilityService instance;
    private HashMap<String, Facility> facilityHashMap = new HashMap<>();
    private Loader<Facility> loader;

    private FacilityService() 
    {
        loader = LoaderFactory.build("facility");

        try 
        {
            Collection<Facility> facilities = loader.load();
            for (Facility facility : facilities)
            {
                facilityHashMap.put(facility.getFacilityName(), facility);
            }
        } 
        catch (LoaderFileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static FacilityService getInstance()
    {
        if (instance == null)
        {
            synchronized (FacilityService.class)
            {
                if (instance == null)
                {
                    instance = new FacilityService();
                }
            }
        }
        return instance;
    }

    public FacilityDTO getFacility(String name) 
    {
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return null;
        return new FacilityDTO(facility.getFacilityName(), facility.getFacilityCost(), facility.getFacilityRate());
    }

    public Set<String> getFacilities()
    {
        return new TreeSet<String>(facilityHashMap.keySet());
    }

    public String getOutput(String name)
    {
        Facility facility = facilityHashMap.get(name);
        if (facility == null) return "";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(facility.getFacilityName());
        stringBuffer.append("\n");
        
        for (int i = 0; i < name.length(); i++)
		{
			stringBuffer.append("-");
		}
        
		stringBuffer.append("\n");
        stringBuffer.append("Rate per Day: " + facility.getFacilityRate());
        stringBuffer.append("\n");
        stringBuffer.append("Cost per day: " + facility.getFacilityCost());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    // Test that the service works
    public static void main(String[] args) 
    {
        FacilityService instance = FacilityService.getInstance();
//        FacilityDTO facilityDTO = instance.getFacility("San Francisco, CA");
//        System.out.println("Please get Facility");
//        System.out.println(" Facility name " + facilityDTO.name + " Facility cost " + facilityDTO.cost);

        String output = instance.getOutput("San Francisco, CA");
        System.out.println(output);

        System.out.println("Facilities: ");
        Set<String> facilities = instance.getFacilities();
        for (String facility : facilities)
        {
            System.out.println(facility);
        }
    }
}
