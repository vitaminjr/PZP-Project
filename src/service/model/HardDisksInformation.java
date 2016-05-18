package service.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vovaz on 18.05.2016.
 */
public class HardDisksInformation {
    private List<HardDisk> hardDisks;

    public HardDisksInformation(List<HardDisk> hardDisks) {
        this.hardDisks = hardDisks;
    }

    public List<HardDisk> getHardDisks() {
        return hardDisks;
    }

    public static HardDisksInformation generate(){
        List<HardDisk> hardDisks = new ArrayList<>();

        try {
            String filePath = "./foo.txt";
            // Use "dxdiag /t" variant to redirect output to a given file
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
            Process p = pb.start();
            p.waitFor();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isDisplay = false;
            HardDisk hardDisk = null;
            String previousModel = "";
            Map<String, HardDisk> hardDiskMap = new HashMap<>();
            while((line = br.readLine()) != null){
                if (isDisplay){
                    if(line.trim().startsWith("Model")){
                        HardDisk hardDisk1 = hardDiskMap.get(line.trim());
                        if (hardDisk == null){
                            hardDisk = new HardDisk();
                            hardDisk.name = line.trim();
                            hardDiskMap.put(hardDisk.name, hardDisk);
                        }
                    }
                    else if (line.trim().startsWith("Free Space")){
                        if (hardDisk == null){
                            hardDisk = new HardDisk();
                            hardDiskMap.put(hardDisk.name, hardDisk);
                        }
                        hardDisk.freeSize += Float.valueOf(line.trim().substring(line.trim().indexOf("Free Space:") + "Free Space: ".length(), line.length() - 3));
                    }
                    else if (line.trim().startsWith("Chip type")){
//                        hardDisk.chipset = line.trim();
                    }
                    else if (line.trim().startsWith("Shared Memory")){
                        hardDisk.disks = line.trim();
                    }

                    if (line.trim().startsWith("System Devices")){
                        break;
                    }
                } else {
                    if (line.trim().startsWith("Disk &")){
                        isDisplay = true;
                    }
                }
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

        return new HardDisksInformation(hardDisks);
    }

    public static class HardDisk{
        String name;
        float totalSize;
        float freeSize;
        String disks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(float totalSize) {
            this.totalSize = totalSize;
        }

        public float getFreeSize() {
            return freeSize;
        }

        public void setFreeSize(float freeSize) {
            this.freeSize = freeSize;
        }

        public String getDisks() {
            return disks;
        }

        public void setDisks(String disks) {
            this.disks = disks;
        }
    }
}
