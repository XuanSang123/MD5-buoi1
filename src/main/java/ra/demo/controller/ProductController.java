package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.Product;
import ra.demo.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public String productpage(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model model) {
        model.addAttribute("products", productService.searchByName(keyword)); // add data to the model for the view
        model.addAttribute("keyword", keyword);
        return "products/productlist";  // return the name of the view, not the path
    }

    @GetMapping("/add")
    public String addProduct() {
        return "products/addProduct";
    }

    @PostMapping("/add")
    public String doAddProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    ;

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/products";

    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "products/editProduct";
    }

    @PostMapping("/update")
    public String doEdit(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }


}
