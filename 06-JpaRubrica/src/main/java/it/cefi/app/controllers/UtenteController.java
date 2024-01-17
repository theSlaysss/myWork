package it.cefi.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.cefi.app.models.Utente;
import it.cefi.app.services.UtenteService;

@Controller
@RequestMapping("/user")
public class UtenteController {
	@Autowired
	private UtenteService utenteService; 

	
	@ModelAttribute
	public Utente iniUtente()
	{
		Utente ut=new Utente();
		ut.setUsername("admin");
		ut.setCitta("Roma");
		return ut;
	}
	
	@GetMapping
	public String index()
	{
		return "form";
	}
	@PostMapping
	public String index(@ModelAttribute Utente utente)
	{ 
		utenteService.saveUtente(utente);
		return "redirect:/user/list"; 
	}
	@GetMapping("/list")
	public ModelAndView getAllUser()
	{
		return new ModelAndView("user_list", "utenti", utenteService.getAllUsers()); 
	}
	@GetMapping("/search")
	public String search()
	{
		return "search";
	}
	@PostMapping("/filtro")
	public ModelAndView filtro(@RequestParam(value="eta",defaultValue = "0") int eta)
	{
		return new ModelAndView("search","utenti",utenteService.findByEta(eta));
	}
	
}
