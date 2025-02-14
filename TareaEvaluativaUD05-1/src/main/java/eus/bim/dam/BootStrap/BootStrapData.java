package eus.bim.dam.BootStrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.bim.dam.Domain.Comic;
import eus.bim.dam.Domain.Tienda;
import eus.bim.dam.Repository.ComicsRepository;
import eus.bim.dam.Repository.TiendaRepository;
import jakarta.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	
	@Transactional
	@Override
	public void run (String ...args) throws Exception{
		Tienda tienda1 = new Tienda("SpaceComics",LocalDate.parse("1989-04-04"));
		Comic comic1 = new Comic("SpidermanVsVenom","Steve Jobs",LocalDate.parse("1965-04-04"));
		
		tienda1.getComics().add(comic1);
	
		
		tiendaRepository.save(tienda1);
		comicsRepository.save(comic1);
	}

}
