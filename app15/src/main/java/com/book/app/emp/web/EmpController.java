package com.book.app.emp.web;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbal.app.emp.service.EmpService;
import com.dbal.app.model.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmpController {

    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    EmpService empService;


    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String emp(Locale locale, Model model, EmpVO empVO) {

        model.addAttribute("emp", empService.getEmp(empVO));

        return "emp/emp";
    }
}
