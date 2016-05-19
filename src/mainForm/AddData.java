package mainForm;



import Interface.ListViewInterface;
import service.SystemInformationController;
import service.model.HardDisksInformation;
import service.model.VideoCardsInformations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaminjr on 18.05.16.
 */
public class AddData implements ListViewInterface {

    public AddData(){
    }




    @Override
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

    @Override
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

    @Override
    public List<String> getTitle_list_memory() {
        List <String> titleListMemory = new ArrayList<>();
        titleListMemory.add("Системна плата");
        titleListMemory.add("Повна ОЗУ");
        titleListMemory.add("Вільна ОЗУ");
        return titleListMemory;
    }

    @Override
    public List<String> getDesc_list_memory() {
        List <String> DescListMemory = new ArrayList<>();
        DescListMemory.add(SystemInformationController.getInstance().getMotherBoardName());
        DescListMemory.add(SystemInformationController.getInstance().getFullMemory());
        DescListMemory.add(SystemInformationController.getInstance().getFreeMemory());
        return DescListMemory;
    }

    @Override
    public List<String> getTitle_list_graphic() {
            List <String> titleListGraphic = new ArrayList<>();
        titleListGraphic.add("Назва відеокарти");
        titleListGraphic.add("Чіпсет");
        titleListGraphic.add("Виробник");
        titleListGraphic.add("Пам’ять");
        return titleListGraphic;
    }

    @Override
    public List<String> getDesc_list_graphic() {
        List <String> descListGraphic = new ArrayList<>();
        List<VideoCardsInformations.VideoCard> videoCards = SystemInformationController.getInstance().getVideoCards();
        for (int i = 0; i < videoCards.size() ; i++) {
            descListGraphic.add(videoCards.get(i).getCardName());
            descListGraphic.add(videoCards.get(i).getChipset());
            descListGraphic.add(videoCards.get(i).getManufacturer());
            descListGraphic.add(videoCards.get(i).getMemory());
        }
        return descListGraphic;
    }

    @Override
    public List<String> getTitle_list_drives() {
        List <String> titleListDrives = new ArrayList<>();
        titleListDrives.add("Назва жосткого диску");
        titleListDrives.add("Диск");
        titleListDrives.add("Загальний розмір");
        titleListDrives.add("Вільне місця");
        return titleListDrives;
    }

    @Override
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

    @Override
    public List<String> getTitle_list_device() {

        List <String> titleListDevice = new ArrayList<>();
        titleListDevice.add("USB PORT 1");
        titleListDevice.add("USB PORT 2");
        titleListDevice.add("USB PORT 3");
        titleListDevice.add("CD-ROM");usu




        return titleListDevice;
    }

    @Override
    public List<String> getDesc_list_device() {
        List <String> descListDevice = new ArrayList<>();
       // descListDevice.addAll(SystemInformationController.getInstance().getPrintersName());
        descListDevice.addAll(SystemInformationController.getInstance().getUsbNames());
       descListDevice.add(SystemInformationController.getInstance().getCdRom());

        return descListDevice;
    }
}
