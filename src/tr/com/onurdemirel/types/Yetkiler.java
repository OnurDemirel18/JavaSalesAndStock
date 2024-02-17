package tr.com.onurdemirel.types;

public class Yetkiler {
    private int yetkiId;
    private String yetkiAdi;

    public int getYetkiId() {
        return yetkiId;
    }

    public void setYetkiId(int yetkiId) {
        this.yetkiId = yetkiId;
    }

    public String getYetkiAdi() {
        return yetkiAdi;
    }

    public void setYetkiAdi(String yetkiAdi) {
        this.yetkiAdi = yetkiAdi;
    }

    @Override
    public String toString() {
        return yetkiId + " " + yetkiAdi;
    }
}
