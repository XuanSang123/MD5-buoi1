package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demo.service.IProductService;

@Controller
@RequestMapping
public class home {
    @Autowired
    private IProductService productService;


    @RequestMapping
    public String homepage() {
        return "home";  // return the name of the view, not the path
    }



}
