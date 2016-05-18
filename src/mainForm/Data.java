package mainForm;

/**
 * Created by vitaminjr on 18.05.16.
 */
public class Data {
    byte idType;
    String title;
    String description;

    public Data(byte idType, String title, String description) {
        this.idType = idType;
        this.title = title;
        this.description = description;
    }

    public byte getIdType() {
        return idType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setIdType(byte idType) {
        this.idType = idType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
