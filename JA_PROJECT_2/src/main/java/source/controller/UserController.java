package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import source.domain.Entrant;
import source.service.SpecialityService;
import source.service.UserDtoHelper;
import source.service.UserService;

import java.io.IOException;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SpecialityService specialityService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam MultipartFile image, @RequestParam String email, @RequestParam String firstName,
									 @RequestParam String lastName, @RequestParam String password) throws IOException {

		userService.save(UserDtoHelper.createUser(image,email,firstName,lastName,password));

		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("specialities", specialityService.getAllSpecialities());

		return map;
	}

	@RequestMapping(value = "/entrant-registration", method = RequestMethod.GET)
	public ModelAndView entrantRegistration() {
		ModelAndView map = new ModelAndView("entrant-registration");
		map.addObject("specialities", specialityService.getAllSpecialities());
		map.addObject("entrant", new Entrant());

		return map;
	}

}