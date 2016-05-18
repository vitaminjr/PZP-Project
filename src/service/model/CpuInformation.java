package service.model;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vovaz on 18.05.2016.
 */
public class CpuInformation {
    private String cores;
    private String names;
    private String arch;
    private String mhz;
    private String l2Cache;
    private String l3Cache;

    public CpuInformation() {
    }

    public String getCores() {
        return cores;
    }

    public String getNames() {
        return names;
    }

    public String getArch() {
        return arch;
    }

    public String getMhz() {
        return mhz;
    }

    public String getL2Cache() {
        return l2Cache;
    }

    public String getL3Cache() {
        return l3Cache;
    }

    public static CpuInformation getDetails(Sigar sigar){
        CpuInformation information = new CpuInformation();
        try {
            CpuInfo[] cpuInformationList = sigar.getCpuInfoList();
            for (org.hyperic.sigar.CpuInfo info : cpuInformationList) {
                information.names = info.getModel();
                information.mhz =  String.valueOf(info.getMhz());
                information.cores =  String.valueOf(info.getTotalCores());
                information.arch =  info.getVendor();
                break;
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }

        try {
            String result = null;
            Process p = Runtime.getRuntime().exec("wmic cpu get L2CacheSize");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null)
            {
                result += line;
            }
            input.close();
            if (result != null){
                if (result.contains("L2CacheSize")){
                    information.l2Cache = result.substring(result.indexOf("L2CacheSize") + "L2CacheSize".length());
                }
            }

            p = Runtime.getRuntime().exec("wmic cpu get L3CacheSize");
            input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null)
            {
                result += line;
            }
            input.close();
            if (result != null){
                if (result.contains("L3CacheSize")){
                    information.l3Cache = result.substring(result.indexOf("L3CacheSize") + "L3CacheSize".length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return information;
    }
}
