package service.model;

import org.hyperic.sigar.Sigar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vovaz on 18.05.2016.
 */
public class MemoryInformation {
    private String motherBoardName;
    private String fullMemory;
    private String freeMemory;

    public String getFullMemory() {
        return fullMemory;
    }

    public String getFreeMemory() {
        return freeMemory;
    }


    public String getMotherBoardName() {
        return motherBoardName;
    }

    public static MemoryInformation generate(Sigar sigar){
        final MemoryInformation memoryInformation = new MemoryInformation();
        final int mb = 1024*1024;
        com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean)
                java.lang.management.ManagementFactory.getOperatingSystemMXBean();
        memoryInformation.fullMemory = os.getTotalPhysicalMemorySize() / mb + "";
        memoryInformation.freeMemory = os.getFreePhysicalMemorySize() / mb + "";
        try {
            String result = null;
            Process p = Runtime.getRuntime().exec("wmic baseboard get Manufacturer, Product");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null)
            {
                result += line;
            }
            input.close();
            if (result != null){
                if (result.contains("Product")){
                    memoryInformation.motherBoardName = result.substring(result.indexOf("Product") + "Product".length()).trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memoryInformation;
    }
}
