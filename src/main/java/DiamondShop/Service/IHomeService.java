package DiamondShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Entity.Category;
import DiamondShop.Entity.Slide;

@Service
public interface IHomeService {
	@Autowired
	public List<Slide> getDataSlides();
	public List<Category> getDataCategories();
	public List<ProductDto> getDataProducts();
}

