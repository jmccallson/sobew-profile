package org.sobew.ws.v1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
  @RequestMapping(value = "/hospice", method = RequestMethod.GET)
  public ModelAndView hospice() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("hospice/login.html");
    return modelAndView;
  }

  @RequestMapping(value = "/topot", method = RequestMethod.GET)
  public ModelAndView topot() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("topot/login.html");
    return modelAndView;
  }
}
