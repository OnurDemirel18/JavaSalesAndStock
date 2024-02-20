package tr.com.onurdemirel.complex.types;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SatisContractComplex {
    private int satisId;
    private String musteriAdi;
    private String personelAdi;
    private String urunAdi;
    private int adet;
    private Date tarih;

    public String toString() {
        return  musteriAdi + " " + personelAdi + " " + urunAdi ;
    }
}
