package cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cart.dto.ProductRequest;
import cart.service.CartService;

@Controller
@RequestMapping("/admin")
public class CartAdminController {
    private final CartService cartService;

    public CartAdminController(final CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping
    @ResponseBody
    public void createProduct(@ModelAttribute final ProductRequest productRequest) {
        System.out.println("================");
        System.out.println(productRequest.getName());
        System.out.println("================");

        cartService.create(productRequest);
    }

    @PutMapping
    @ResponseBody
    public void updateProduct(@ModelAttribute final ProductRequest productRequest) {
        cartService.update(productRequest);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteProduct(@ModelAttribute final ProductRequest productRequest) {
        cartService.delete(productRequest);
    }

}
