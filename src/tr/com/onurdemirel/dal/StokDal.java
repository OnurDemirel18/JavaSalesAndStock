package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;

import java.util.List;

public class StokDal<StokContract> extends ObjectHelper implements DalI<StokContract> {

    @Override
    public void Insert(StokContract entity) {

    }

    @Override
    public List<StokContract> GetAll() {
        return null;
    }

    @Override
    public StokContract Delete(StokContract entity) {
        return null;
    }

    @Override
    public StokContract Update(StokContract entity) {
        return null;
    }

    @Override
    public List<StokContract> GetById(int id) {
        return null;
    }
}
