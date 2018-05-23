package com.restservices.app.controllers;

import com.restservices.app.exceptions.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mrityunjaya on 7/12/17.
 */
@Controller
public class ApplicationController {


    Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8};

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        return "index";
    }


    @RequestMapping(value = "/errorPage")
    public String getErrorPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        throw new CustomException("This is an error page!");
    }
}
