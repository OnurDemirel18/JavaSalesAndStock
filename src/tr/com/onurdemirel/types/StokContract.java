package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StokContract {
    private int StokId;
    private int personelId;
    private int urunId;
    private Date tarih;
    private int adet;



    @Override
    public String toString() {
        return StokId + " " + personelId + " " + urunId + " " + tarih + " " + adet;
    }
}
