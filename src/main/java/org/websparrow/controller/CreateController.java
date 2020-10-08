package org.websparrow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.City;
import org.websparrow.model.Student;
import org.websparrow.model.Subject;
import org.websparrow.service.StudentService;




@Controller
@RequestMapping("/create")
public class CreateController {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create"; // jsp page
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createStudent(Student student, ModelAndView mv, ModelMap model) {
	// RequestParam = Request.getParameter() --> gets value from form
		
		model.put("student", student);

		int counter = studentDao.create(student);

		if (counter > 0) {
			mv.addObject("msg", "Student registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("create");

		return mv;
	}
	
	@ModelAttribute("cities")
	public List<City> populateCities(){
		return studentService.getAllCities();
	}
	
	@ModelAttribute("subjects")
	public List<Subject> populateSubjects(){
		return studentService.getAllSubjects();
	}
	
}


