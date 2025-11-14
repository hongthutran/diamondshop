package DiamondShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamondShop.Dao.BillDao;
import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Bill;
import DiamondShop.Entity.BillDetail;
import DiamondShop.Service.IBillService;

@Service
public class BillServiceImpl implements IBillService{

	@Autowired
	private BillDao billDao;
	
	public int addBill(Bill bill) {
		return billDao.addBill(bill);
	}

	public void addBillDetail(HashMap<Long, CartDto> cart) {
		
		for (Map.Entry<Long, CartDto> itemCart: cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(billDao.getIDLastBill());
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDao.addBillDetail(billDetail);
		}
	}
}
