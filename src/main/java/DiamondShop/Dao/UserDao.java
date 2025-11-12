package DiamondShop.Dao;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperUser;
import DiamondShop.Entity.User;

@Repository
public class UserDao extends BaseDao {
	public int AddAccount(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users");
		sql.append("(");
		sql.append("user");
		sql.append(", password");
		sql.append(", display_name");
		sql.append(", address");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'" + user.getUser() + "'");
		sql.append(", '" + user.getPassword() + "'");
		sql.append(", '" + user.getDisplay_name() + "'");
		sql.append(", '" + user.getAddress() + "'");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public int CountUserByEmail(String email) {
		String sql = "SELECT COUNT(*) FROM users WHERE user = '" + email + "'";
		return _jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public User GetUserByAcc(User user) {
		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "'";
		User result = _jdbcTemplate.queryForObject(sql, new MapperUser());
		return result;
	}
}
