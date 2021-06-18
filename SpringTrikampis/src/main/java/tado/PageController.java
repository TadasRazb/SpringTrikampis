package tado;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
			model.addAttribute ("statieji_trikampiai", trikampiu_sudarytojas.trikampiaiy);
			model.addAttribute ("lygiasoniai_trikampiai", trikampiu_sudarytojas.trikampiaiz);
			model.addAttribute ("lygiasoniai_trikampiai", trikampiu_sudarytojas.trikampiaiw);
			model.addAttribute ("atkarpos", trikampiu_sudarytojas.atkarpos);
		} catch (Exception e) {
			
		}
		
		model.addAttribute( "fraze",  "Labas is Java Spring" );
		return "trik";
	}
	@RequestMapping(path="/trikampiu-sudarytojas")	
	public @ResponseBody TrikampiuSudarytojas trikampiuSudarytojas() throws IOException {
		
		AtkarposMusuIsFailo atkarposx = new AtkarposMusuIsFailo();
		
		TrikampiuSudarytojas trikampiu_sudarytojas = new TrikampiuSudarytojas(atkarposx);
		
		try {
			trikampiu_sudarytojas.atlikti();
			
		} catch (Exception e) {
			
		}
		
		return trikampiu_sudarytojas;
	}
	
	@RequestMapping(path="/pasiimti-ajax")	
	public String pasiimtiAjax() {
		
		
		return "trik-ajax";
	}	
	
	@RequestMapping(path="/labas-ajax")	
	public @ResponseBody String labasAjax() {
		
		
		return "Labas Ajax";
	}	
}