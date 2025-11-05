package DiamondShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController extends BaseController{
	
	@RequestMapping(path = {"/","/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlides());
		_mvShare.addObject("categories", _homeService.getDataCategories());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.addObject("newProducts", _homeService.getNewProducts());
		_mvShare.addObject("highlightProducts", _homeService.getHighlightProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
//	public String index() {
//		return "user/index";
//	}
	
	
	@RequestMapping(path = "/product")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
}