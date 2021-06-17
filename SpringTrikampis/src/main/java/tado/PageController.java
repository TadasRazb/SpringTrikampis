package tado;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(path="/")
	public String home( Model model ) {
		
		 // Model model = new Model();
		
		AtkarposMusuIsFailo atkarposx = new AtkarposMusuIsFailo();
		
		TrikampiuSudarytojas trikampiu_sudarytojas = new TrikampiuSudarytojas(atkarposx);
		
		try {
			trikampiu_sudarytojas.atlikti();
			model.addAttribute ("atkarpos_pradines", trikampiu_sudarytojas.atkarpos_pradines);
			model.addAttribute ("trikampiai", trikampiu_sudarytojas.trikampiaix);
			model.addAttribute ("atkarpos", trikampiu_sudarytojas.atkarpos);
		} catch (Exception e) {
			
		}
		
		model.addAttribute( "fraze",  "Labas is Java Spring" );
		return "trik";
	}

}