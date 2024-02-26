package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusteriContract {
    private int musteriId;
    private String musteriAdiSoyadi;
    private String musteriTelefon;
    private String musteriAdres;
    private int sehirId;



    @Override
    public String toString() {
        return musteriAdiSoyadi;
    }
}
