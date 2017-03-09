package pl.kobietydokodu.koty.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kobietydokodu.koty.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.dto.KotDTO;

@Controller
public class KotyController {

	@Autowired
	KotDAO dao;
	
	@RequestMapping("/lista")
	public String listaKotow(Model model) {
		model.addAttribute("koty", dao.getKoty());
		return "lista";
	}
	
	@RequestMapping("/dodaj")
	public String dodajKota(HttpServletRequest request,  @ModelAttribute("kotDto") @Valid KotDTO kotDto, BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			Kot kot = new Kot();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				kot.setDataUrodzenia(sdf.parse(kotDto.getDataUrodzenia()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			kot.setImie(kotDto.getImie());
			kot.setImieOpiekuna(kotDto.getImieOpiekuna());
			kot.setWaga(kotDto.getWaga());
			dao.dodajKota(kot);
			return "redirect:/lista";
		}
		return "dodaj";
	}
	
	@RequestMapping("/kot-{id}")
	public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("kot", dao.getKotById(id));
		return "szczegoly";
	}
	
}
