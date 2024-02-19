package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SehirContract {
    private int sehirId;
    private String sehirAdi;

    public String toString() {
        return  sehirAdi;
    }

}
