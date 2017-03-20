package com.restwebservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.ItemBusiness;
import com.business.UserBusiness;
import com.domain.business.ItemBO;
import com.domain.business.UserBO;

@RestController
public class GroceryBuddyWebService {
	
	private ItemBusiness itemBusinessFacade;
	private UserBusiness userBusinessFacade;
	
	//Default Constructor
	public GroceryBuddyWebService(){}
	
	public GroceryBuddyWebService(ItemBusiness itemBusinessFacade){
		this.itemBusinessFacade = itemBusinessFacade;
	}

	@ResponseBody
    @RequestMapping(value="/services/getItemsByUserId", method=RequestMethod.GET, headers="Accept=application/json")
    public List<ItemBO> getItemsByUserId(@RequestParam(value="userId", defaultValue="3") String userId) {
    	return itemBusinessFacade.getItemsByUserId(Integer.parseInt(userId));
    }
    
	@ResponseBody
    @RequestMapping(value="/services/getAllUsers", method=RequestMethod.GET, headers="Accept=application/json")
    public List<UserBO> getAllUsers() {
    	return userBusinessFacade.getAllUsers();
    }
	
	@ResponseBody

    @RequestMapping(value="/services/getAllItems", 
    				method=RequestMethod.GET, 
    				headers="Accept=application/json")
    public List<ItemBO> getAllItems() {
    	return itemBusinessFacade.getAllItems();
    }

	/**
	 * @param itemBusinessFacade the itemBusinessFacade to set
	 */
    @Autowired
	public void setItemBusinessFacade(ItemBusiness itemBusinessFacade) {
		this.itemBusinessFacade = itemBusinessFacade;
	}

	/**
	 * @param userBusinessFacade the userBusinessFacade to set
	 */
    @Autowired
	public void setUserBusinessFacade(UserBusiness userBusinessFacade) {
		this.userBusinessFacade = userBusinessFacade;
	}

}