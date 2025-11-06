package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Dto.ProductDto;
import DiamondShop.Dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao {
	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.size ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.detail ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products as p ");
		sql.append("INNER JOIN ");
		sql.append("colors as c ");
		sql.append("ON "); 
		sql.append("p.id = c.id_product ");
		return sql;
	}
	
	private String sqlProducts(boolean highlight, boolean new_product) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		if (highlight)
			sql.append("AND p.highlight = true ");
		if (new_product)
			sql.append("AND p.new_product = true ");
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highlight)
			sql.append("LIMIT 9 ");
		if (new_product)
			sql.append("LIMIT 12 ");
		return sql.toString();
	}
	
	private StringBuffer sqlProductsByID(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + " ");
		return sql;
	}	
	
	private String sqlProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sql = sqlProductsByID(id);
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}
	
	private String sqlProductByID(long id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_product = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}	
	
	public List<ProductDto> getDataProducts() {
		List<ProductDto> listProducts = _jdbcTemplate.query(sqlString().toString(), new ProductDtoMapper());
		return listProducts;
	}
	
	public List<ProductDto> getNewProducts() {
		List<ProductDto> listNewProducts = _jdbcTemplate.query(sqlProducts(false,true), new ProductDtoMapper());
		return listNewProducts;
	}
	
	public List<ProductDto> getHighlightProducts() {
		List<ProductDto> listHighlightProducts = _jdbcTemplate.query(sqlProducts(true,false), new ProductDtoMapper());
		return listHighlightProducts;
	}
	
	public List<ProductDto> getAllProductsByID(int id) {
		List<ProductDto> listProducts = _jdbcTemplate.query(sqlProductsByID(id).toString(), new ProductDtoMapper());
		return listProducts;
	}
	
	public List<ProductDto> getDataProductsPaginate(int id, int start, int totalPage) {
		List<ProductDto> listProductsByID = getAllProductsByID(id);
		List<ProductDto> listProducts = new ArrayList<ProductDto>();
		
		if(listProductsByID.size() > 0) 
			listProducts = _jdbcTemplate.query(sqlProductsPaginate(id, start, totalPage), new ProductDtoMapper());
		
		return listProducts;
	}
	
	public List<ProductDto> getProductByID(long id) {
		List<ProductDto> listProducts = _jdbcTemplate.query(sqlProductByID(id), new ProductDtoMapper());
		return listProducts;
	}
	
	public ProductDto findProductByID(long id) {
		ProductDto product = _jdbcTemplate.queryForObject(sqlProductByID(id), new ProductDtoMapper());
		return product;
	}
}
