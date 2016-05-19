package mainForm;

import Interface.ListViewInterface;
import service.SystemInformationController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaminjr on 18.05.16.
 */
public class ClassTestClass implements ListViewInterface {

    public ClassTestClass(){
        addList();
    }

    private List<Data> dataList;
    private Data data;


    public void addList(){
        dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            data = new Data(i,"zxc","zxc");
            dataList.add(data);
        }
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
        return titleListGraphic;
    }

    @Override
    public List<String> getDesc_list_graphic() {
        List <String> DescListGraphic = new ArrayList<>();
    //    DescListGraphic.add(SystemInformationController.getInstance().getMotherBoardName());
     //   DescListGraphic.add(SystemInformationController.getInstance().getFullMemory());
      //  DescListGraphic.add(SystemInformationController.getInstance().getFreeMemory());
        return DescListGraphic;
    }

    @Override
    public List<String> getTitle_list_drives() {
        List <String> titleListDrives = new ArrayList<>();
        return titleListDrives;
    }

    @Override
    public List<String> getDesc_list_drives() {
        List <String> DescListDrives = new ArrayList<>();
        return DescListDrives;
    }

    @Override
    public List<String> getTitle_list_device() {
        List <String> titleListDevice = new ArrayList<>();
        return titleListDevice;
    }

    @Override
    public List<String> getDesc_list_devive() {
        List <String> DescListDevice = new ArrayList<>();
        return DescListDevice;
    }
}
