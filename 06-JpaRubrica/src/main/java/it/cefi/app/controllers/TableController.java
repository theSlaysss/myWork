package it.cefi.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TableController {

	@GetMapping("/crea")
	public String crea(Model model, @RequestParam("colonne") int colonne, @RequestParam("righe") int righe) {
	    model.addAttribute("tabellina", creaTabella(colonne, righe));
	    return "index";
	}
	
	private Integer[][] creaTabella(int colonne, int righe) {
        Integer[][] tabella = new Integer[righe][colonne];
        int valore = 1;
        for (int i = 1; i < righe+1; i++) {
            for (int j = 1; j < colonne+1; j++) {
                tabella[i][j] = valore*j;
            }
        }
        return tabella;
}
	
}
