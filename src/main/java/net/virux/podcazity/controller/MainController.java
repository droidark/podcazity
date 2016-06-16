package net.virux.podcazity.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.virux.podcazity.model.Profile;
import net.virux.podcazity.model.User;
import net.virux.podcazity.service.ProfileService;
import net.virux.podcazity.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = {"/", "welcome"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(){
//		TEST RELATIONSHIP
		User usr = userService.getUser("comicorp");
		System.out.println(usr.getProfiles().size());
		for(Profile p : usr.getProfiles()){
			System.out.println(p.getProfile());
		}
		
		User u = new User();
		u.setUsername("acomics");
		u.setPassword("comicorprules");
		u.setAlias("Asamblea Comics");
		u.setAvatarUrl("http://abc.xyz/avatar.jpg");
		u.setCoverUrl("http://abc.xyz/cover.jpg");
		u.setDescription("Asamblea Comics");
		u.setUrl("http://comiqueros.blogspot.com");
		Date d = new Date();
		u.setSignUpDate(d);
		u.setState("Active");
		u.setPremium(false);
		
		Set<Profile> profiles = new HashSet<Profile>();
		profiles.add(profileService.getProfile(1));
		u.setProfiles(profiles);
		
		userService.addUser(u);
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message","This is welcome page!");
		model.setViewName("welcome");
		return model;
	}
	
	@RequestMapping(value = {"/admin**"}, method = RequestMethod.GET)
	public ModelAndView adminPage(){
		ModelAndView model = new ModelAndView();
		model.addObject("user", "Spring Security Hello World");
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		if(error != null){
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if(logout != null){
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;		
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("accessDenied");
		return model;

	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!!!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!!";
		}

		return error;
	}
}
