package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ProductDto getProductByID(long id) {
		List<ProductDto> listProducts = productDao.getProductByID(id);
		return listProducts.get(0);
	}
	
	public List<ProductDto> getProductsByIDCategory(int id) {
		return productDao.getAllProductsByID(id);
	}

}
