package DiamondShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamondShop.Dto.PaginationDto;
import DiamondShop.Service.User.CategoryServiceImpl;
import DiamondShop.Service.User.PaginationServiceImpl;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private PaginationServiceImpl paginateService;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		
		int totalData = categoryService.getAllProductsByID(Integer.parseInt(id)).size();
		int totalProductsPage = 9;
		PaginationDto paginationInfo = paginateService.getPaginationInfo(totalData, totalProductsPage, 1);

		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("productsPaginate", categoryService.getDataProductsPaginate(Integer.parseInt(id), paginationInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		
		int totalData = categoryService.getAllProductsByID(Integer.parseInt(id)).size();
		int totalProductsPage = 9;
		PaginationDto paginationInfo = paginateService.getPaginationInfo(totalData, totalProductsPage, Integer.parseInt(currentPage));

		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginationInfo", paginationInfo);
		_mvShare.addObject("productsPaginate", categoryService.getDataProductsPaginate(Integer.parseInt(id), paginationInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
}

