package tr.com.onurdemirel.types;

public class KategoriContract {
    private int kategoriId;
    private String kategoriAdi;
    private int parentId;

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAdi() {

        return kategoriAdi;
    }

    public void GetKategoriAdi(String kategoriAdi) {

        this.kategoriAdi = kategoriAdi;
    }

    public int getParentId() {

        return parentId;
    }


    public void setParentId(int parentId) {

        this.parentId = parentId;
    }

    @Override
    public String toString() {

        return kategoriId + " " + kategoriAdi + " " + parentId;
    }
}
