package DiamondShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.ProductDto;

@Service
public interface ICategoryService {
	
	public List<ProductDto> getAllProductsByID(int id);
	
	public List<ProductDto> getDataProductsPaginate(int id, int start, int totalPage);
}
