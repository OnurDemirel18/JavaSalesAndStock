package tr.com.onurdemirel.contract;

import java.util.Date;

public class UrunlerContract {
    private int urunId;
    private String urunAdi;
    private String urunKategoriId;
    private Date urunTarih;
    private float urunFiyat;

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunKategoriId() {
        return urunKategoriId;
    }

    public void setUrunKategoriId(String urunKategoriId) {
        this.urunKategoriId = urunKategoriId;
    }

    public Date getUrunTarih() {
        return urunTarih;
    }

    public void setUrunTarih(Date urunTarih) {
        this.urunTarih = urunTarih;
    }

    public float getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(float urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    @Override
    public String toString() {
        return urunId + " " + urunAdi + " " + urunKategoriId + " " + urunTarih + " " + urunFiyat;
    }
}
