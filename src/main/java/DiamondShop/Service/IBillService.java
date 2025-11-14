package DiamondShop.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.CartDto;
import DiamondShop.Entity.Bill;

@Service
public interface IBillService {
	public int addBill(Bill bill);
	public void addBillDetail(HashMap<Long, CartDto> cart);
}
