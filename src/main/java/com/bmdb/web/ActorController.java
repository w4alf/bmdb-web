package com.bmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepository;



@CrossOrigin
@RestController
@RequestMapping("/actors")

public class ActorController {

	@Autowired
	private ActorRepository actorRepo;
	
	//list - Return all Actors
		@GetMapping("/")
		public JsonResponse listActors() {
			JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(actorRepo.findAll());
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			
			return jr;
		}
	
		
		//get - return one actor for a given id
		@GetMapping("/{id}")
		public JsonResponse get(@PathVariable int id) {
			JsonResponse jr = null;
			try {
			jr = JsonResponse.getInstance(actorRepo.findById(id));
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
			
		//Add - Adds a new actor
		@PostMapping("/")
		public JsonResponse addActor(@RequestBody Actor a) {
			JsonResponse jr = null;
			
			try {
				jr = JsonResponse.getInstance(actorRepo.save(a));
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
			
		}
		
		//Update - update an actor
		@PutMapping("/")
		public JsonResponse updateActor(@RequestBody Actor a) {
			JsonResponse jr = null;
			
			
			try {
				if (actorRepo.existsById(a.getId())) {
					jr = JsonResponse.getInstance(actorRepo.save(a));
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error updating actor. id: " + a.getId() + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
			
		}
			
		
		//Delete - delete an Actor
		@DeleteMapping("/{id}")
		public JsonResponse deleteActor(@PathVariable int id) {
			JsonResponse jr = null;
			
			try {
				if (actorRepo.existsById(id)) {
					actorRepo .deleteById(id);
					
					jr = JsonResponse.getInstance("Delete Successful!");
					
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error deleting Actor. id: " + id + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
		}
		
		
	
}
