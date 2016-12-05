package com.rc_long.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;

@Controller
public class InitIndexAction {
	@RequestMapping(value=AnRequest.sys_movie_init)
	public ModelAndView initMovie(){
		return new ModelAndView("index/movie");
	}
}
