package tr.com.onurdemirel.complex.types;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class StokContractComplex {
    private int id;
    private String personelAdi;
    private String urunAdi;
    private Date tarih;
    private int adet;

    public String toString() {
        return  personelAdi + " " + urunAdi ;
    }

}
