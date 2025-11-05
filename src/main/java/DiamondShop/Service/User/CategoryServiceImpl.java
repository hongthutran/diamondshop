package DiamondShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.ProductDao;
import DiamondShop.Dto.ProductDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductDao productDao;
	
	public List<ProductDto> getAllProductsByID(int id) {
		return productDao.getAllProductsByID(id);
	}
	
	public List<ProductDto> getDataProductsPaginate(int id, int start, int totalPage) {
		return productDao.getDataProductsPaginate(id, start, totalPage);
	}

	
}
