package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import source.service.SpecialityService;

@Controller
public class SpecialityController {

	@Autowired
	SpecialityService specialityService;

}
