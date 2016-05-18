package service;


import org.hyperic.sigar.Sigar;
import service.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by vovaz on 18.05.2016.
 */
public class SystemInformationController {
    private static SystemInformationController sController;

    private CpuInformation cpuInformation;
    private MemoryInformation memoryInformation;
    private IODevices ioDevices;
    private VideoCardsInformations videoCardsInformations;
    private HardDisksInformation hardDisksInformation;

    private SystemInformationController(Sigar sigar){
        cpuInformation = CpuInformation.getDetails(sigar);
        memoryInformation = MemoryInformation.generate(sigar);
        ioDevices = IODevices.genarate();
        videoCardsInformations = VideoCardsInformations.genarate();
        hardDisksInformation = HardDisksInformation.generate();
    }

    public synchronized static SystemInformationController getInstance(){
        if (sController == null){
            final Sigar sigar = new Sigar();
            sController = new SystemInformationController(sigar);
        }
        return sController;
    }

    //================================
    // CPU
    //=================================
    public String getCpuName(){
        return cpuInformation.getNames();
    }

    public String getCpuMhz(){
        return cpuInformation.getMhz();
    }

    public String getCpuArch(){
        return cpuInformation.getArch();
    }

    public String getCpuCores(){
        return cpuInformation.getCores();
    }

    public String getCpuL2Cahce(){
        return cpuInformation.getL2Cache();
    }

    public String getCpuL3Cahce(){
        return cpuInformation.getL3Cache();
    }


    //==================================
    // Memory
    //==================================
    public String getFullMemory(){
        return memoryInformation.getFullMemory();
    }

    public String getFreeMemory(){
        return memoryInformation.getFreeMemory();
    }

    public String getMotherBoardName(){
        return memoryInformation.getMotherBoardName();
    }

    //==================================
    // IO devices
    //==================================
    public String getCdRom(){
        return ioDevices.getCdromName();
    }

    public List<String> getPrintersName(){
        return ioDevices.getPrinters();
    }

    public List<String> getUsbNames(){
        return ioDevices.getUsbDevices();
    }
    //==================================
    // Hard disks
    //==================================
    public List<VideoCardsInformations.VideoCard> getVideoCards(){
        return videoCardsInformations.getInformatioms();
    }

    public List<HardDisksInformation.HardDisk> getHardDiskList(){
        return hardDisksInformation.getHardDisks();
    }

    //==================================
    // Full information about system
    //==================================
    public File getFullDescriptionOfSystem(){
        try {
            String filePath = "./foo.txt";
            // Use "dxdiag /t" variant to redirect output to a given file
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
            System.out.println("-- Executing dxdiag command --");
            Process p = pb.start();
            p.waitFor();
            return new File(filePath);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
