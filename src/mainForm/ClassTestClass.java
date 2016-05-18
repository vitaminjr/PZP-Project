package mainForm;

import Interface.ListViewInterface;

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


    public List get(){
        return  dataList;
    }





 //   List<Data> title = new ArrayList<>();

 //   for (int i = 0; i<list.size(); i++){

  //      if()
  //          title.add(list.get(i));
 //   }


    @Override
    public List<String> getTitle_list_proc() {
        List <String> titleListProc = new ArrayList<>();
     //   Data
        return titleListProc;
    }

    @Override
    public List<String> getDesc_list_proc() {
        List <String> DescListProc = new ArrayList<>();
        return DescListProc;
    }

    @Override
    public List<String> getTitle_list_memory() {
        List <String> titleListMemory = new ArrayList<>();
        return titleListMemory;
    }

    @Override
    public List<String> getDesc_list_memory() {
        List <String> DescListMemory = new ArrayList<>();
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
