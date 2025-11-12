package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Entity.User;

@Service
public interface IAccountService {
	public int AddAccount(User user);
	public int CountUserByEmail(String email);
	public User CheckAccount(User user);
}
