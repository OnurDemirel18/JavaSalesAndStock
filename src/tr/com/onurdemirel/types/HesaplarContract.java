package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HesaplarContract {
    private int hesapId;
    private int yetkiId;
    private int personelId;
    private String sifre;



    @Override
    public String toString() {
        return hesapId + " " + personelId + " " + sifre + " " + yetkiId;
    }
}
