package tr.com.onurdemirel.types;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UrunlerContract {
    private int urunId;
    private String urunAdi;
    private int urunKategoriId;
    private Date urunTarih;
    private float urunFiyat;

    @Override
    public String toString() {
        return urunId + " " + urunAdi + " " + urunKategoriId + " " + urunTarih + " " + urunFiyat;
    }
}
