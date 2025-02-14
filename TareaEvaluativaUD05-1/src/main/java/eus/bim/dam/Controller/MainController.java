package eus.bim.dam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.bim.dam.Repository.ComicsRepository;
import eus.bim.dam.Repository.TiendaRepository;

@Controller
public class MainController {
	
	@Autowired
	private ComicsRepository comicRepository;
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@GetMapping({"/",""})
	public String index() {
		return "index";
	}
	
	@GetMapping("/comics")
	public String getComics(Model model) {
		model.addAttribute("comics", comicRepository.findAll());
		return "comics";
	}
	
	@GetMapping("/stores")
	public String getStore(Model model) {
		model.addAttribute("stores", tiendaRepository.findAll());
		return "stores";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}

}
