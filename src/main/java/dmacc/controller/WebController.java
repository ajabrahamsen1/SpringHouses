package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.repository.HouseRepository;
import dmacc.beans.House;

@Controller
public class WebController {
	@Autowired
	HouseRepository repo;
	
	@GetMapping("/viewAll")
		public String viewAllHouses(Model model) {
			model.addAttribute("houses", repo.findAll());
			return "results";
		}
	
	@GetMapping("/inputHouse")
		public String addNewHouses(Model model) {
			House h = new House(); 
			model.addAttribute("newHouse", h);
			return "input";
	}
	
	@PostMapping("/inputHouse")
		public String addNewHouses(@ModelAttribute House h, Model model) {
			repo.save(h);
			model.addAttribute("houses", repo.findAll());
			return "results";
	}
	
	@GetMapping("/edit/{id}")
		public String showUpdateForm(@PathVariable("id") long id, Model model) {
			House h = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			model.addAttribute("house", h);
			return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateHouse(@PathVariable("id") long id, @Valid House h, BindingResult result, Model model) {
		if(result.hasErrors()) {
			h.setId(id);
			return "update";
		}
		repo.save(h);
		model.addAttribute("houses", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteHouse(@PathVariable("id") long id, Model model) {
		House h = repo.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repo.delete(h);
		model.addAttribute("houses", repo.findAll());
		return "results";
}
	
}
