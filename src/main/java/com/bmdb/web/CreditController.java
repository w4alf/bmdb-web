package com.bmdb.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.bmdb.business.Credit;

import com.bmdb.db.CreditRepository;




@CrossOrigin
@RestController
@RequestMapping("/credits")




public class CreditController {

	@Autowired
	private CreditRepository creditRepo;
	
	//list - Return all Credits
		@GetMapping("/")
		public JsonResponse listCredits() {
			JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(creditRepo.findAll());
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			
			return jr;
		}
	
		
		//get - return one Credit for a given id
		@GetMapping("/{id}")
		public JsonResponse get(@PathVariable int id) {
			JsonResponse jr = null;
			try {
			jr = JsonResponse.getInstance(creditRepo.findById(id));
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
			
		//Add - Adds a new Credit
		@PostMapping("/")
		public JsonResponse addCredit(@RequestBody Credit c) {
			JsonResponse jr = null;
			
			try {
				jr = JsonResponse.getInstance(creditRepo.save(c));
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
					
				}
				return jr;
			
		}
		
		//Update - update a Credit
		@PutMapping("/")
		public JsonResponse updateCredit(@RequestBody Credit c) {
			JsonResponse jr = null;
			
			
			try {
				if (creditRepo.existsById(c.getId())) {
					jr = JsonResponse.getInstance(creditRepo.save(c));
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error updating Credit. id: " + c.getId() + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
			
		}
			
		
		//Delete - delete a Credit
		@DeleteMapping("/{id}")
		public JsonResponse deleteCredit(@PathVariable int id) {
			JsonResponse jr = null;
			
			try {
				if (creditRepo.existsById(id)) {
					creditRepo.deleteById(id);
					
					jr = JsonResponse.getInstance("Delete Successful!");
					
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error deleting Credit. id: " + id + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
		}
		
	

	
	
	
	
}
