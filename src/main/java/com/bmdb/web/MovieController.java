package com.bmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepository;



@CrossOrigin
@RestController
@RequestMapping("/movies")




public class MovieController {

	@Autowired
	private MovieRepository movieRepo;
	
	//list - Return all Movies
		@GetMapping("/")
		public JsonResponse listMovies() {
			JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(movieRepo.findAll());
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			
			return jr;
		}
	
		
		//get - return one Movie for a given id
		@GetMapping("/{id}")
		public JsonResponse get(@PathVariable int id) {
			JsonResponse jr = null;
			try {
			jr = JsonResponse.getInstance(movieRepo.findById(id));
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
			
		//Add - Adds a new Movie
		@PostMapping("/")
		public JsonResponse addMovie(@RequestBody Movie m) {
			JsonResponse jr = null;
			
			try {
				jr = JsonResponse.getInstance(movieRepo.save(m));
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
			
		}
		
		//Update - update a Movie
		@PutMapping("/")
		public JsonResponse updateMovie(@RequestBody Movie m) {
			JsonResponse jr = null;
			
			
			try {
				if (movieRepo.existsById(m.getId())) {
					jr = JsonResponse.getInstance(movieRepo.save(m));
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error updating Movie. id: " + m.getId() + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
			
		}
			
		
		//Delete - delete a Movie
		@DeleteMapping("/{id}")
		public JsonResponse deleteMovie(@PathVariable int id) {
			JsonResponse jr = null;
			
			try {
				if (movieRepo.existsById(id)) {
					movieRepo.deleteById(id);
					
					jr = JsonResponse.getInstance("Delete Successful!");
					
				} else {
					//record doesn't exist
					jr = JsonResponse.getInstance("Error deleting Movie. id: " + id + " doesn't exist.");
				}
				
				}catch (Exception e) {
					jr = JsonResponse.getInstance(e);
				}
				return jr;
		}
		
	
	
	
}
