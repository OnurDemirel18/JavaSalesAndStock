package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.PersonelContract;

import java.util.List;

public class PersonelDal<PersonelContract> extends ObjectHelper implements DalI<PersonelContract> {
    @Override
    public void Insert(PersonelContract entity) {

    }

    @Override
    public List<PersonelContract> GetAll() {
        return null;
    }

    @Override
    public PersonelContract Delete(PersonelContract entity) {
        return null;
    }

    @Override
    public PersonelContract Update(PersonelContract entity) {
        return null;
    }

    @Override
    public List<PersonelContract> GetById(int id) {
        return null;
    }
}
