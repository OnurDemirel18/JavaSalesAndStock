package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SatisContract {
    private int satisId;
    private int musteriId;
    private int personelId;
    private int urunId;
    private int adet;
    private Date tarih;


    @Override
    public String toString() {
        return satisId + " " + musteriId + " " + personelId + " " + urunId + " " + adet + " " + tarih;
    }
}
