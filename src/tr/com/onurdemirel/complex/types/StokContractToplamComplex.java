package tr.com.onurdemirel.complex.types;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class StokContractToplamComplex {
    private int id;
    private String personelAdi;
    private String urunAdi;
    private Date tarih;
    private int adet;
    private int toplam;

    public Object[] getVeriler() {
        Object[] veriler = {id, personelAdi, urunAdi, tarih, toplam};
        return veriler;
    }

    public String toString() {
        return urunAdi;
    }
}
