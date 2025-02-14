package eus.bim.dam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.bim.dam.Domain.Tienda;
//import eus.bim.dam.Repository.ComicsRepository;
import eus.bim.dam.Repository.TiendaRepository;

@Controller
@RequestMapping("/stores")
public class TiendaController {
	
	@Autowired
	private TiendaRepository tiendaRepo;
	
	/*
	@Autowired
	private ComicsRepository comicRepo;
	*/
	
	@GetMapping("/new")
	public String newStore(Model model) {
		Tienda tienda = new Tienda();
		model.addAttribute("store", tienda);
		return "storeForm";
	}
	
	@PostMapping("/new/submit")
	public String submitForm(@ModelAttribute Tienda store) {
		tiendaRepo.save(store);
		return "redirect:/stores";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStore(@PathVariable("id") int id, Model model) {
		tiendaRepo.deleteById(id);
		return "redirect:/stores";
	}
	
	@GetMapping("/edit/{id}")
	public String editStore(@PathVariable("id") int id, Model model) {
		model.addAttribute("store", tiendaRepo.findById(id));
		return "storeForm";
	}
	
}
