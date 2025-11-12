package DiamondShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Entity.User;
import DiamondShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	private AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registerForm() {
		_mvShare.addObject("user", new User());
		_mvShare.addObject("status", "");
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		// Handling validation errors
		if (result.hasErrors()) {
			_mvShare.addObject(user);
			// Return to the registration page to display the error
	        _mvShare.setViewName("user/account/register"); 
	        return _mvShare;
		}
		// Handle email existence check
		int countUser = accountService.CountUserByEmail(user.getUser());
		if (countUser == 1) {
			result.rejectValue("user", "emailExists", "Email này đã được sử dụng");
			_mvShare.setViewName("user/account/register");
	        return _mvShare;
		}
		
		int countRow = accountService.AddAccount(user);
		if (countRow > 0) {
			_mvShare.clear();
			_mvShare.setViewName("user/account/login");
		}
		else {
			_mvShare.addObject("status", "Đăng ký thất bại. Vui lòng thử lại.");
			_mvShare.setViewName("user/account/register");
		}
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		_mvShare.addObject("user", new User());
		_mvShare.addObject("status", "");
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView processLogin(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		User loggedInUser = accountService.CheckAccount(user);
		if (loggedInUser != null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", loggedInUser);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại. Vui lòng thử lại.");
			_mvShare.setViewName("user/account/login");
		}
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}
}
