package tr.com.onurdemirel.contract;

public class MusteriContract {
    private int musteriId;
    private String musteriAdiSoyadi;
    private String musteriTelefon;
    private String musteriAdres;
    private int sehirId;

    public int getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    public String getMusteriAdiSoyadi() {
        return musteriAdiSoyadi;
    }

    public void setMusteriAdiSoyadi(String musteriAdiSoyadi) {
        this.musteriAdiSoyadi = musteriAdiSoyadi;
    }

    public String getMusteriTelefon() {
        return musteriTelefon;
    }

    public void setMusteriTelefon(String musteriTelefon) {
        this.musteriTelefon = musteriTelefon;
    }

    public String getMusteriAdres() {
        return musteriAdres;
    }

    public void setMusteriAdres(String musteriAdres) {
        this.musteriAdres = musteriAdres;
    }

    public int getSehirId() {
        return sehirId;
    }

    public void setSehirId(int sehirId) {
        this.sehirId = sehirId;
    }

    @Override
    public String toString() {
        return musteriId + " " + musteriAdiSoyadi+ " " + sehirId+ " " + musteriAdres+ " " + musteriTelefon;
    }
}
