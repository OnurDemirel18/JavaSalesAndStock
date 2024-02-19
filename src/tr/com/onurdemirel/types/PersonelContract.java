package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonelContract {
    private int personelId;
    private String personelAdSoyad;
    private String email;





    @Override
    public String toString() {
        return  personelAdSoyad;
    }
}
