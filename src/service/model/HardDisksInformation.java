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
            while((line = br.readLine()) != null){
                if (isDisplay){
                    if(line.trim().startsWith("Drive")){
                        if (hardDisk != null && hardDisk.getFreeSize() != null && hardDisk.getTotalSize() != null){
                            hardDisks.add(hardDisk);
                        }

                        hardDisk = new HardDisk();
                        hardDisk.disks = line.substring(line.indexOf("Drive:") + "Drive: ".length()).trim();
                    }
                    else if (line.trim().startsWith("Free Space")){
                        if (hardDisk != null){
                            hardDisk.freeSize = line.substring(line.indexOf("Free Space:") + "Free Space: ".length()).trim();
                        }
                    }
                    else if (line.trim().startsWith("Total Space")){
                        if (hardDisk != null){
                            hardDisk.totalSize = line.substring(line.indexOf("Total Space:") + "Total Space: ".length()).trim();
                        }
                    }
                    else if (line.trim().startsWith("Model")){
                        if (hardDisk != null){
                            hardDisk.name = line.substring(line.indexOf("Model:") + "Model: ".length()).trim();
                        }
                    }
                    else if (line.trim().startsWith("System Devices")){
                        if (hardDisk != null && hardDisk.getFreeSize() != null && hardDisk.getTotalSize() != null)
                            hardDisks.add(hardDisk);
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
        private String name;
        private String totalSize;
        private String freeSize;
        private String disks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(String totalSize) {
            this.totalSize = totalSize;
        }

        public String getFreeSize() {
            return freeSize;
        }

        public void setFreeSize(String freeSize) {
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
