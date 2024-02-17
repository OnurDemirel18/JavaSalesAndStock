package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;

import java.util.List;

public class SatisDal<SatisContract> extends ObjectHelper implements DalI<SatisContract> {
    @Override
    public void Insert(SatisContract entity) {

    }

    @Override
    public List<SatisContract> GetAll() {
        return null;
    }

    @Override
    public SatisContract Delete(SatisContract entity) {
        return null;
    }

    @Override
    public SatisContract Update(SatisContract entity) {
        return null;
    }

    @Override
    public List<SatisContract> GetById(int id) {
        return null;
    }
}
