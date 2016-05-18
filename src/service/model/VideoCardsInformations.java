package service.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vovaz on 18.05.2016.
 */
public class VideoCardsInformations {
    private List<VideoCard> informatioms;

    public VideoCardsInformations(List<VideoCard> informatioms) {
        this.informatioms = informatioms;
    }

    public List<VideoCard> getInformatioms() {
        return informatioms;
    }

    public static VideoCardsInformations genarate(){
        List<VideoCard> videoCards = new ArrayList<>();
        try {
            String filePath = "./foo.txt";
            // Use "dxdiag /t" variant to redirect output to a given file
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
            System.out.println("-- Executing dxdiag command --");
            Process p = pb.start();
            p.waitFor();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isDisplay = false;
            VideoCard videoCard = null;
            while((line = br.readLine()) != null){
                if (isDisplay){
                    if(line.trim().startsWith("Card name:")){
                        if (videoCard != null)
                            videoCards.add(videoCard);
                        videoCard = new VideoCard();
                        videoCard.cardName = line.trim();
                    }
                    else if (line.trim().startsWith("Manufacturer")){
                        videoCard.manufacturer = line.trim();
                    }
                    else if (line.trim().startsWith("Chip type")){
                        videoCard.chipset = line.trim();
                    }
                    else if (line.trim().startsWith("Shared Memory")){
                        videoCard.memory = line.trim();
                    }

                    if (line.trim().startsWith("Sound Devices")){
                        if (videoCard != null)
                            videoCards.add(videoCard);
                        break;
                    }
                } else {
                    if (line.trim().startsWith("Display Devices")){
                        isDisplay = true;
                    }
                }
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return new VideoCardsInformations(videoCards);
    }

    public static class VideoCard {
        String cardName;
        String manufacturer;
        String chipset;
        String memory;

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getChipset() {
            return chipset;
        }

        public void setChipset(String chipset) {
            this.chipset = chipset;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }
    }
}
