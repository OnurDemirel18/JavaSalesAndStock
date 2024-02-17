package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.HesaplarContract;

import java.util.List;

public class HesaplarDal<HesaplarContract> extends ObjectHelper implements DalI<HesaplarContract> {
    @Override
    public void Insert(HesaplarContract entity) {

    }

    @Override
    public List<HesaplarContract> GetAll() {
        return null;
    }

    @Override
    public HesaplarContract Delete(HesaplarContract entity) {
        return null;
    }

    @Override
    public HesaplarContract Update(HesaplarContract entity) {
        return null;
    }

    @Override
    public List<HesaplarContract> GetById(int id) {
        return null;
    }
}
