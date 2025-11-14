package DiamondShop.Dao;

import org.springframework.stereotype.Repository;


import DiamondShop.Entity.Bill;
import DiamondShop.Entity.BillDetail;

@Repository
public class BillDao extends BaseDao{
	public int addBill(final Bill bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("(");
		sql.append("`user`, `phone`, `display_name`, `address`, `total`, `quanty`, `note`");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("'" + bill.getUser() + "', ");
		sql.append("'" + bill.getPhone() + "', ");
		sql.append("'" + bill.getDisplay_name() + "', ");
		sql.append("'" + bill.getAddress() + "', ");
		sql.append("" + bill.getTotal() + ", ");
		sql.append("" + bill.getQuanty() + ", ");
		sql.append("'" + bill.getNote() + "' ");
		sql.append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long getIDLastBill() {
		String sql = "SELECT MAX(id) FROM bills";
		long id = _jdbcTemplate.queryForObject(sql, Long.class);
		return id;
	}
	
	public int addBillDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bill_details ");
		sql.append("(");
		sql.append("`id_product`, `id_bill`, `quanty`, `total`");
		sql.append(") ");
		sql.append("VALUES");
		sql.append("(");
		sql.append("" + billDetail.getId_product() + ", ");
		sql.append("" + billDetail.getId_bill() + ", ");
		sql.append("" + billDetail.getQuanty() + ", ");
		sql.append("" + billDetail.getTotal() + "");
		sql.append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
