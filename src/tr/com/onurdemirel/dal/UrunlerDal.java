package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.UrunlerContract;

import java.util.List;

public class UrunlerDal<UrunlerContract> extends ObjectHelper implements DalI<UrunlerContract> {
    @Override
    public void Insert(UrunlerContract entity) {

    }

    @Override
    public List<UrunlerContract> GetAll() {
        return null;
    }

    @Override
    public UrunlerContract Delete(UrunlerContract entity) {
        return null;
    }

    @Override
    public UrunlerContract Update(UrunlerContract entity) {
        return null;
    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }
}
