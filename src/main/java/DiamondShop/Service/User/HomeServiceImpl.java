package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.CategoryDao;
import DiamondShop.Dao.MenuDao;
import DiamondShop.Dao.ProductDao;
import DiamondShop.Dao.SlideDao;
import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Category;
import DiamondShop.Entity.Menu;
import DiamondShop.Entity.Slide;

@Service
public class HomeServiceImpl implements IHomeService {
	
	@Autowired
	private SlideDao slide;
	@Autowired
	private CategoryDao category;
	@Autowired
	private MenuDao menu;
	@Autowired
	private ProductDao productDao;
	
	public List<Slide> getDataSlides() {
		return slide.getDataSlides();
	}

	public List<Category> getDataCategories() {
		return category.getDataCategories();
	}

	public List<Menu> getDataMenus() {
		return menu.getDataMenus();
	}

	public List<ProductDto> getDataProducts() {
		List<ProductDto> listProducts = productDao.getDataProducts();
		return listProducts;
	}
	
	public List<ProductDto> getNewProducts() {
		List<ProductDto> listNewProducts = productDao.getNewProducts();
		return listNewProducts;
	}

	public List<ProductDto> getHighlightProducts() {
		List<ProductDto> listHighlightProducts = productDao.getHighlightProducts();
		return listHighlightProducts;
	}
	
}
