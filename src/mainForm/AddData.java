package mainForm;



import Interface.ListViewInterface;
import service.SystemInformationController;
import service.model.HardDisksInformation;
import service.model.VideoCardsInformations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vitaminjr on 18.05.16.
 */
public class AddData {

    public AddData(){
    }


    public List<String> getTitle_list_proc() {
        List <String> titleListProc = new ArrayList<>();
        titleListProc.add("Назва процесора");
        titleListProc.add("Архітектура процесора");
        titleListProc.add("Тактова частота");
        titleListProc.add("Кількість ядер");
        titleListProc.add("Кеш 2-го рівня");
        titleListProc.add("Кеш 3-го рівня");
        return titleListProc;
    }

    public List<String> getDesc_list_proc() {
        List <String> descListProc = new ArrayList<>();
        descListProc.add(SystemInformationController.getInstance().getCpuName());
        descListProc.add(SystemInformationController.getInstance().getCpuArch());
        descListProc.add(SystemInformationController.getInstance().getCpuMhz());
        descListProc.add(SystemInformationController.getInstance().getCpuCores());
        descListProc.add(SystemInformationController.getInstance().getCpuL2Cahce());
        descListProc.add(SystemInformationController.getInstance().getCpuL3Cahce());
        return descListProc;
    }

    public List<String> getTitle_list_memory() {
        List <String> titleListMemory = new ArrayList<>();
        titleListMemory.add("Системна плата");
        titleListMemory.add("Повна ОЗУ");
        titleListMemory.add("Вільна ОЗУ");
        return titleListMemory;
    }

    public List<String> getDesc_list_memory() {
        List <String> DescListMemory = new ArrayList<>();
        DescListMemory.add(SystemInformationController.getInstance().getMotherBoardName());
        DescListMemory.add(SystemInformationController.getInstance().getFullMemory());
        DescListMemory.add(SystemInformationController.getInstance().getFreeMemory());
        return DescListMemory;
    }

    public Map<Integer, List<String>> getGraphicsList(){
        List <String> titleListGraphic = new ArrayList<>();
        List <String> descListGraphic = new ArrayList<>();
        List<VideoCardsInformations.VideoCard> videoCards = SystemInformationController.getInstance().getVideoCards();
        titleListGraphic.add("Кількість відеокарт:");
        descListGraphic.add(videoCards.size()+"");
        for (int i = 0; i < videoCards.size() ; i++) {
            titleListGraphic.add("Назва відеокарти");
            titleListGraphic.add("Чіпсет");
            titleListGraphic.add("Виробник");
            titleListGraphic.add("Пам’ять");
            titleListGraphic.add(" ");
            descListGraphic.add(videoCards.get(i).getCardName());
            descListGraphic.add(videoCards.get(i).getChipset());
            descListGraphic.add(videoCards.get(i).getManufacturer());
            descListGraphic.add(videoCards.get(i).getMemory());
            descListGraphic.add(" ");
        }

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, titleListGraphic);
        map.put(1, descListGraphic);
        return map;
    }

    public List<String> getTitle_list_drives() {
        List <String> titleListDrives = new ArrayList<>();
        titleListDrives.add("Назва жосткого диску");
        titleListDrives.add("Диск");
        titleListDrives.add("Загальний розмір");
        titleListDrives.add("Вільне місця");
        return titleListDrives;
    }

    public List<String> getDesc_list_drives() {
        List <String> descListDrives = new ArrayList<>();

        List<HardDisksInformation.HardDisk> hardDisks = SystemInformationController.getInstance().getHardDiskList();
        for (int i = 0; i < hardDisks.size() ; i++) {
            descListDrives.add(hardDisks.get(i).getName());
            descListDrives.add(hardDisks.get(i).getDisks());
            descListDrives.add(hardDisks.get(i).getTotalSize());
            descListDrives.add(hardDisks.get(i).getFreeSize());
        }
        return descListDrives;
    }

    public List<String> getTitle_list_device() {

        List <String> titleListDevice = new ArrayList<>();
        titleListDevice.add("USB PORT 1");
        titleListDevice.add("USB PORT 2");
        titleListDevice.add("USB PORT 3");
        titleListDevice.add("CD-ROM");




        return titleListDevice;
    }

    public Map<Integer,List<String>> getListDevice() {

        List <String> titleListDevice = new ArrayList<>();


        List <String> descListDevice = new ArrayList<>();
        int i = 1;
        titleListDevice.add("Printers count:");
        descListDevice.add(SystemInformationController.getInstance().getPrintersName().size() + "");
        for (String text : SystemInformationController.getInstance().getPrintersName()){
            titleListDevice.add(" ");
            descListDevice.add(text);
        }

        titleListDevice.add(" ");
        descListDevice.add(" ");
        titleListDevice.add("Usb counts:");
        descListDevice.add(SystemInformationController.getInstance().getUsbNames().size()+"");
        for (String text : SystemInformationController.getInstance().getUsbNames()){
            titleListDevice.add(" ");
            descListDevice.add(text);
        }
        titleListDevice.add(" ");
        descListDevice.add(" ");
        titleListDevice.add("CD-ROM");
        descListDevice.add(SystemInformationController.getInstance().getCdRom());

        Map<Integer,List<String>> map = new HashMap<>();
        map.put(0,titleListDevice);
        map.put(1,descListDevice);
       return  map;
    }
}
