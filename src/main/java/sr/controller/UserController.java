package sr.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sr.model.User;
import sr.service.UserService;

@Controller
public class UserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	
	@RequestMapping(value = "/showForm" , method = RequestMethod.GET)
	public ModelAndView showForm(User user, Map<String, Object> map) {
		map.put("user", new User());
		ModelAndView view = new ModelAndView("/showForm");
		return view;
		
	}
	
	@RequestMapping(value = "/userAdd" , method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		User user = new User();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		user.setName(name);
		user.setEmail(email);
		Set<User> saveuser = new HashSet<User>();
		saveuser.add(user);
		userservice.saveAll(saveuser);
		ModelAndView view = new ModelAndView("/userListLink");
//		view.addObject("listStaff",staff);
		return view;
	}
	
	@RequestMapping("/userList")
	public ModelAndView userList() {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		List<User> userList = userservice.findAll();
		ModelAndView view = new ModelAndView("/userList");
		view.addObject("userList", userList);
		return view;
	}
	

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id , Model model) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		userservice.deleteById(id);
		ModelAndView view = new ModelAndView("/userListLink");
		return view;
	}
	
	@RequestMapping(value = "/detail" , method = RequestMethod.GET)
	public ModelAndView details(@RequestParam("id") int id , Model model) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		Optional<User> user =userservice.findById(id);
		ModelAndView view = new ModelAndView("/detail");
		view.addObject("name",user.get().getName());
		view.addObject("email", user.get().getEmail());
		return view;
	}
	
	@RequestMapping(value = "/edit" , method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id , Map<String, Object> map) {
		map.put("user", new User());
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		Optional<User> u =userservice.findById(id);
		ModelAndView view = new ModelAndView("/edit");
		view.addObject("name",u.get().getName());
		view.addObject("email", u.get().getEmail());
		view.addObject("id", u.get().getId());
		return view;
	}
	
	
	@RequestMapping(value = "/userUpdate" , method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/Lenovo/eclipse-workspace/TestProject/src/main/resources/SpringConfig.xml");
		UserService userservice = (UserService) context.getBean("userservice");
		User user = new User();
		int id = request.getParameterValues(id);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		Set<User> saveuser = new HashSet<User>();
		saveuser.add(user);
		userservice.saveAll(saveuser);
		ModelAndView view = new ModelAndView("/userListLink");
//		view.addObject("listStaff",staff);
		return view;
	}
		
}
