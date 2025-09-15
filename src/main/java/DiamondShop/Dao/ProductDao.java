package DiamondShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao {
	public List<ProductDto> getDataProducts() {
		String sql = "SELECT "
				+ "p.id as id_product "
				+ ", p.id_category "
				+ ", p.size "
				+ ", p.name "
				+ ", p.price "
				+ ", p.sale "
				+ ", p.title "
				+ ", p.highlight "
				+ ", p.new_product "
				+ ", p.detail "
				+ ", c.id as id_color "
				+ ", c.name as name_color "
				+ ", c.code as code_color "
				+ ", c.img "
				+ ", p.created_at "
				+ ", p.updated_at "
				+ "FROM "
				+ "products as p "
				+ "INNER JOIN "
				+ "colors as c "
				+ "ON "
				+ "p.id = c.id_product "
				+ "GROUP BY p.id, c.id_product "
				+ "ORDER BY RAND() "
				+ "LIMIT 12";
		List<ProductDto> listProducts = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return listProducts;
	}
}
