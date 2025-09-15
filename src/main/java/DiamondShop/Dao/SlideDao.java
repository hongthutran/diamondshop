package DiamondShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamondShop.Entity.MapperSlide;
import DiamondShop.Entity.Slide;

@Repository
public class SlideDao extends BaseDao{
	public List<Slide> getDataSlides() {
		List<Slide> list = new ArrayList<Slide>();
		String sql = "SELECT * FROM Slides";
		list = _jdbcTemplate.query(sql, new MapperSlide());
		return list;
	}
	
}
