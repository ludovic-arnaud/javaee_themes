package fr.arnaud.ludovic.themes.dao;



import java.util.List;

public interface DAO<T, ID> {
	public T create(T object);

	public T update(T object);

	public void delete(T object);

	public void deleteById(ID id);

	public List<T> findAll();

	public T findById(ID id);

	public int count();

	public List<T> findAll(int maxResults, int numeroPage);

}
