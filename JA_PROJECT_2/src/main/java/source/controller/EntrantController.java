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

	@RequestMapping(value = "/entrants", method = RequestMethod.GET)
	public ModelAndView getEntrants() {
		ModelAndView map = new ModelAndView("entrants");
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

}
