package tr.com.onurdemirel.interfaces;

import java.util.List;

public interface DalI<T> {
    public void Insert(T entity);
    public List<T> GetAll();
    public T Delete(T entity);
    public void Update(T entity);
    public List<T> GetById(int id);

}
