package DiamondShop.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	private long id;
	
	@NotBlank(message = "Email không được để trống.")
	@Email(message = "Email không hợp lệ.")
	private String user;
	
	@NotBlank(message = "Mật khẩu không được để trống.")
	@Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự.")
	private String password;
	
	@NotBlank(message = "Họ và tên không được để trống.")
	private String display_name;
	
	private String address;
	
	public User() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
