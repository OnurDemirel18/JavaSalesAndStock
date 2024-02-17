package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.MusteriContract;

import java.util.List;

public class MusteriDal<MusteriContract> extends ObjectHelper implements DalI<MusteriContract> {
    @Override
    public void Insert(MusteriContract entity) {

    }

    @Override
    public List<MusteriContract> GetAll() {
        return null;
    }

    @Override
    public MusteriContract Delete(MusteriContract entity) {
        return null;
    }

    @Override
    public MusteriContract Update(MusteriContract entity) {
        return null;
    }

    @Override
    public List<MusteriContract> GetById(int id) {
        return null;
    }
}
