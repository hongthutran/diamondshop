package DiamondShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.CartDto;
import DiamondShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();

	@RequestMapping(value = "/gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlides());
		_mvShare.addObject("categories", _homeService.getDataCategories());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "/AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.AddCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
//		return "redirect:/chi-tiet-san-pham/" + id;
		//Redirects the user back to the URL of the previous page
		return "redirect:" + request.getHeader("Referer"); 
	}
	
	@RequestMapping(value = "/EditCart/{id}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.AddCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<Long, CartDto>();
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("totalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
}
