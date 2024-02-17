package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;

import java.util.List;

public class YetkilerDal<YetkilerContract> extends ObjectHelper implements DalI<YetkilerContract> {
    @Override
    public void Insert(YetkilerContract entity) {

    }

    @Override
    public List<YetkilerContract> GetAll() {
        return null;
    }

    @Override
    public YetkilerContract Delete(YetkilerContract entity) {
        return null;
    }

    @Override
    public YetkilerContract Update(YetkilerContract entity) {
        return null;
    }

    @Override
    public List<YetkilerContract> GetById(int id) {
        return null;
    }
}
