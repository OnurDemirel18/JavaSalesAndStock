package tr.com.onurdemirel.types;


// KategoriContract sınıfı veritabanındaki Kategori tablosu için bir sözleşme oluşturmak için kullanılır.
// Üç alanı vardır: kategoriId, kategoriAdi ve parentId. Her alan için getter ve setter'ları vardır.
// Ayrıca kategoriAdi alanını döndürmek için bir toString metodu vardır.

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KategoriContract {
    private int kategoriId;
    private String kategoriAdi;
    private int parentId;



    @Override
    public String toString() {

        return kategoriAdi;
    }
}
