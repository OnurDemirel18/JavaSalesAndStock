package tr.com.onurdemirel.types;



public class PersonelContract {
    private int personelId;
    private String personelAdSoyad;
    private String email;


    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getPersonelAdSoyad() {
        return personelAdSoyad;
    }

    public void setPersonelAdSoyad(String personelAdSoyad) {
        this.personelAdSoyad = personelAdSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return personelId + " " + personelAdSoyad + " " + email;
    }
}
