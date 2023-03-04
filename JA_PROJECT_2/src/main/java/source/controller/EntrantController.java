package source.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import source.domain.Entrant;
import source.domain.User;
import source.service.EntrantService;
import source.service.UserService;

@Controller
public class EntrantController {

	@Autowired
	UserService userService;

	@Autowired
	EntrantService entrantService;
	private Entrant entrant;
	private BindingResult bindingResult;

	@RequestMapping(value = "/entrants", method = RequestMethod.GET)
	public ModelAndView getEntrants() {
		ModelAndView map = new ModelAndView("entrants");
		map.addObject("entrants", entrantService.getAllEntrants());

		return map;
	}

	@RequestMapping(value = "/received-entrants", method = RequestMethod.GET)
	public ModelAndView getReceivedEntrants() {
		ModelAndView map = new ModelAndView("received-entrants");
		map.addObject("entrants", entrantService.getAllEntrants());

		return map;
	}

	@RequestMapping(value = "/entrant-enrolling", method = RequestMethod.GET)
	public ModelAndView getEntrantsForEnrolling() {
		ModelAndView map = new ModelAndView("entrant-enrolling");
		map.addObject("entrants", entrantService.getAllEntrants());

		return map;
	}

	@RequestMapping(value = "/entrantRegistration", method = RequestMethod.POST)
	public ModelAndView addEntrant(@Valid @ModelAttribute("entrant") Entrant entrant, BindingResult bindingResult)
			throws NumberFormatException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findByEmail(userEmail);

		entrant.setUser(user);
		entrantService.save(entrant);

		ModelAndView map = new ModelAndView("redirect:/home");

		return map;
	}

	@RequestMapping(value = "/entrantEnrolling", method = RequestMethod.POST)
	public ModelAndView enrollEntrant(@Valid @ModelAttribute("entrant") Entrant entrant, @RequestParam Integer id, BindingResult bindingResult)
			throws NumberFormatException {

		entrantService.updateEntrant(true, entrant.getId());

		ModelAndView map = new ModelAndView("redirect:/home");

		return map;
	}

}
