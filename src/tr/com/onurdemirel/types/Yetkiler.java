package tr.com.onurdemirel.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Yetkiler {
    private int yetkiId;
    private String yetkiAdi;



    @Override
    public String toString() {
        return  yetkiAdi;
    }
}
