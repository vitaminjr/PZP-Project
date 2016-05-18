package service.model;

import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vovaz on 18.05.2016.
 */
public class IODevices {
    private String cdromName;
    private List<String> printers;
    private List<String> usbDevices;

    public String getCdromName() {
        return cdromName;
    }

    public List<String> getPrinters() {
        return printers;
    }

    public List<String> getUsbDevices() {
        return usbDevices;
    }

    public static IODevices genarate(){
        IODevices devices = new IODevices();
        //usb
        List<String> devicesNames = new ArrayList<>();
        try {
            com.codeminders.hidapi.ClassPathLibraryLoader.loadNativeHIDLibrary();
            HIDManager manager = HIDManager.getInstance();
            for (HIDDeviceInfo deviceInfo: manager.listDevices()){
                if (deviceInfo.getProduct_string() != null)
                    devicesNames.add(deviceInfo.getProduct_string());
                else if (deviceInfo.getSerial_number() != null){
                    devicesNames.add(deviceInfo.getProduct_string());
                } else {
                    devicesNames.add(deviceInfo.getPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        devices.usbDevices = devicesNames;
        //printers
        try {
            String result = null;
            Process p = Runtime.getRuntime().exec("wmic printer get Caption");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            line = input.readLine();
            List<String> printers = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                if (line != null && !line.isEmpty()){
                    printers.add(line.trim());
                }
            }
            input.close();
            devices.printers = printers;
        }catch (Exception e){
        }

        try {
            String result = null;
            Process p = Runtime.getRuntime().exec("wmic cdrom get Caption");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            line = input.readLine();
            while ((line = input.readLine()) != null) {
                if (line != null && !line.isEmpty()){
                    devices.cdromName = line.trim();
                }
            }
            input.close();
        }catch (Exception e){
        }
        return devices;
    }
}
