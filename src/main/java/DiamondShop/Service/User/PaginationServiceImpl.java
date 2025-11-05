package DiamondShop.Service.User;

import org.springframework.stereotype.Service;

import DiamondShop.Dto.PaginationDto;

/**
 * Service implementation for pagination logic.
 */
@Service
public class PaginationServiceImpl implements IPaginationService{

	/**
     * Calculates all necessary pagination data (total pages, start/end index)
     * based on the total records, limit per page, and requested page.
     *
     * @param totalData Total number of records.
     * @param limit Records per page.
     * @param currentPage Requested page number (may be invalid).
     * @return PaginationDto with normalized information.
     */
	public PaginationDto getPaginationInfo(int totalData, int limit, int currentPage) {
		PaginationDto pagination = new PaginationDto();
		pagination.setLimit(limit);
		
		// 1. Calculate total pages
		pagination.setTotalPages(setInfoTotalPages(totalData, limit));
		
		// 2. Normalize and set current page (handle < 1 or > totalPage cases)
		pagination.setCurrentPage(checkCurrentPage(currentPage, pagination.getTotalPages()));
		
		// 3. Calculate 1-based start index
		int start = findStart(pagination.getCurrentPage(), limit);  
		pagination.setStart(start);
		
		// 4. Calculate 1-based end index, ensuring it doesn't exceed totalData
		int end = findEnd(pagination.getStart(), limit, totalData);
		pagination.setEnd(end);
		
		return pagination;
	}
	
	/**
     * Calculates the 1-based starting index for the data on the given page.
     * Formula: (currentPage - 1) * limit + 1
     */
	private int findStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}
	
	/**
     * Calculates the 1-based ending index, capped by the total number of records.
     */
	private int findEnd(int start, int limit, int totalData) {
		// Return totalData if theoretical end exceeds totalData
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}
	
	/**
     * Calculates the total number of pages.
     */
	private int setInfoTotalPages(int totalData, int limit) {
		int totalPages = 0;
		totalPages = totalData / limit;
		
		// If there's a remainder, add one more page.
		totalPages = totalPages * limit < totalData ? totalPages + 1 : totalPages;
		
		return totalPages;
	}
	
	/**
     * Checks if the requested page is less than 1. Note: This original
     * implementation allows currentPage to exceed totalPage.
     */
	public int checkCurrentPage(int requestedPage, int totalPages) {
		if (requestedPage < 1) 
			return 1; // Default to page 1
		
		// Original logic: returns currentPage even if it exceeds totalPage.
		if (requestedPage > totalPages)
			return totalPages;
		
		return requestedPage;
	}

}
