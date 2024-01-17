/*
  La DispatcherServlet

Il cuore di Spring MVC è costituito dalla DispatcherServlet, l’elemento
che implementa i meccanismi di routing delle richieste HTTP. In sintesi,
il framework si basa su una singola servlet che ha il compito
di intercettare le richieste dirette verso l’applicazione, per
poi “smistarle” ai Controller di competenza. Se stiamo lavorando con
Spring Boot, il nostro progetto disporrà già di una configurazione di
default. In particolare, la nostra applicazione disporrà di
una dispatcher servlet pronta a gestire tutte le richieste, ovvero tutte
quelle con url corrispondenti al pattern /*. 


L’annotazione @Controller è una specializzazione di @Component;
un Controller in Spring MVC rappresenta infatti un tipo particolare di
componente, la cui creazione è gestita dallo Spring IoC container.
Un classe decorata con @Controller, sarà gestita dalla Dispatcher Servlet quando verrà fatta la richiesta a metodi della classe

  
  L’annotazione @RequestMapping viene utilizzata per indicare i metodi addetti 
alla gestione delle richieste HTTP. 
Per esempio, se un metodo viene decorato con @RequestMapping("/") , allora l’annotazione 
registra nel contesto dell’applicazione il metodo (handler) per le chiamate dirette verso la root (/) dell’applicazione. 
metodo che gestisce (handler) la richiesta di root http://localhost:8080/
 */

package it.cefi.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	/*
	  metodo che gestisce (handler) la richiesta di root http://localhost:8080/ 
	  il @requestMapping gestisce sia richieste di tipo get che di tipo Post
	  
	  @GetMapping gestisce solo richieste di tipo Get 
	 */
	
//@RequestMapping(path = "/",method = RequestMethod.GET)
//gestisce richieste del tipo http://localhost:8080/ dove "/" è la route di root
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("msg","Benvenuto");
		return "index";
	
	}
	
	
	
}
