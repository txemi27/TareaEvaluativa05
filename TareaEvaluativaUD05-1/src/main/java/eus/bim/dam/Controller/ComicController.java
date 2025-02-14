package eus.bim.dam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.bim.dam.Domain.Comic;
import eus.bim.dam.Repository.ComicsRepository;
import eus.bim.dam.Repository.TiendaRepository;

@Controller
@RequestMapping ("/comics")
public class ComicController {
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private ComicsRepository comicRepository;

	@GetMapping("/new")
	public String addComic(Model model) {
		Comic comic = new Comic();
		model.addAttribute("comic", comic);
		model.addAttribute("stores", tiendaRepository.findAll());
		return "comicsForm";
	}
	
	@PostMapping("/new/submit")
		public String submitCreationForm(@ModelAttribute Comic comic) {
			comicRepository.save(comic);
			return "redirect:/comics";
	}
	
	@GetMapping("/edit/{id}")
	public String editComic(@PathVariable("id") int id, Model model) {
		model.addAttribute("comic", comicRepository.findById(id));
		model.addAttribute("stores", tiendaRepository.findAll());
		return "comicsForm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComic(@PathVariable("id") int id, Model model) {
		comicRepository.deleteById(id);
		return "redirect:/comics";
	}
	
}
