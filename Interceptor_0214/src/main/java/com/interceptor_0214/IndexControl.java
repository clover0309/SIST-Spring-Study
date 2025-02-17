package com.interceptor_0214;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexControl {

    // localhost:8080/으로 넘어옴.
        @RequestMapping("/")
        public String index() {
            return "index";
        }

        @RequestMapping("index")
        public String main() {
            return "index";
        }

        @RequestMapping("/sub/bravo")
        public ModelAndView bravo() {
            ModelAndView mv = new ModelAndView("bravo");

            //할일들이 있다면..
            mv.addObject("msg", "Hello World");

            return mv;
        }
    }