package DiamondShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Bill;
import DiamondShop.Entity.User;
import DiamondShop.Service.User.BillServiceImpl;
import DiamondShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();

	@Autowired
	private BillServiceImpl billService = new BillServiceImpl();
	
	@RequestMapping(value = "/gio-hang")
	public ModelAndView index() {
		_mvShare.addObject("slides", _homeService.getDataSlides());
		_mvShare.addObject("categories", _homeService.getDataCategories());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "/AddCart/{id}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.AddCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
		//Redirects the user back to the URL of the previous page
		return "redirect:" + request.getHeader("Referer"); 
	}
	
	@RequestMapping(value = "/EditCart/{id}/{quanty}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/DeleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkoutForm(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bill/checkout");
		Bill bill = new Bill();
		User loginInfo = (User) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			bill.setAddress(loginInfo.getAddress());
			bill.setDisplay_name(loginInfo.getDisplay_name());
			bill.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bill", bill);
		return _mvShare;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String processCheckout(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
		bill.setQuanty((Integer) session.getAttribute("totalQuantyCart"));
		bill.setTotal((Double) session.getAttribute("totalPriceCart"));
		if (billService.addBill(bill) > 0) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
			billService.addBillDetail(cart);
		}
		session.removeAttribute("cart");
		session.removeAttribute("totalQuantyCart");
		session.removeAttribute("totalPriceCart");
		return "redirect:gio-hang";
	}
}
