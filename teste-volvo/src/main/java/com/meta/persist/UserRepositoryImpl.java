package com.meta.persist;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.meta.entity.User;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractRepository<Integer, User> implements UserRepository {

	public void save(User employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public void removerById(Integer id) {
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	public User findById(int id) {
		return getByKey(id);
	}
}
