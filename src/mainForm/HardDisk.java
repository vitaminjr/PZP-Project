package mainForm;

/**
 * Created by vitaminjr on 19.05.16.
 */
public  class HardDisk{
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