package service;

import service.model.HardDisksInformation;
import service.model.VideoCardsInformations;

/**
 * Created by vovaz on 18.05.2016.
 */
public class TestActivity {
    public static void main(String[] args) {
        System.out.println(SystemInformationController.getInstance().getCpuArch());
        System.out.println(SystemInformationController.getInstance().getCpuCores());
        System.out.println(SystemInformationController.getInstance().getCpuL2Cahce());
        System.out.println(SystemInformationController.getInstance().getCpuL3Cahce());
        System.out.println(SystemInformationController.getInstance().getCpuMhz());
        System.out.println(SystemInformationController.getInstance().getCpuName());
        System.out.println(SystemInformationController.getInstance().getFreeMemory());
        System.out.println(SystemInformationController.getInstance().getFullMemory());
        System.out.println(SystemInformationController.getInstance().getMotherBoardName());

        for (String text : SystemInformationController.getInstance().getPrintersName()){
            System.out.println(text);
        }

        for (String text : SystemInformationController.getInstance().getUsbNames()){
            System.out.println(text);
        }
        System.out.println(SystemInformationController.getInstance().getCdRom());

        for (VideoCardsInformations.VideoCard card : SystemInformationController.getInstance().getVideoCards()){
            System.out.println(card.getCardName());
            System.out.println(card.getChipset());
            System.out.println(card.getManufacturer());
            System.out.println(card.getMemory());
        }


        for (HardDisksInformation.HardDisk hardDisk: SystemInformationController.getInstance().getHardDiskList()){
            System.out.println(hardDisk.getDisks());
            System.out.println(hardDisk.getFreeSize());
            System.out.println(hardDisk.getTotalSize());
            System.out.println(hardDisk.getName());
        }
    }
}
