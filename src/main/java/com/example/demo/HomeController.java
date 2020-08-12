package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/order")
    public String orderPizza(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("doughs", ingredientRepository.findAllByType(typeRepository.findByName("dough")));
        model.addAttribute("proteins", ingredientRepository.findAllByType(typeRepository.findByName("protein")));
        model.addAttribute("veggies", ingredientRepository.findAllByType(typeRepository.findByName("veggie")));
        model.addAttribute("sauces", ingredientRepository.findAllByType(typeRepository.findByName("sauce")));
        model.addAttribute("toppings", ingredientRepository.findAllByType(typeRepository.findByName("topping")));
        //ingredients
        return "orderForm";
    }

    @PostMapping("/processOrder")
    public String processPizzaOrder(@ModelAttribute("pizza") Pizza pizza, Model model, @RequestParam("dough") long id, Principal principal) {
        Ingredient ing = ingredientRepository.findById(id).get();
        pizza.addIngredient(ing);

        model.addAttribute("pizza", pizza);
        Order order = new Order();
        order.addPizza(pizza);
        pizza.setPrice(pizza.calculatePrice());
        pizza.setOrder(order);
        order.setTotal(order.calculateTotal());

        if (principal!=null){
            User currentUser = userRepository.findByUsername(principal.getName());
            order.setUser(currentUser);
//            order.setComplete(true);
        }
        orderRepository.save(order);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String loadUserCart(Model model, Principal principal){

        if (principal!=null) {
            User currentUser = userRepository.findByUsername(principal.getName());
            for (Order order : orderRepository.findAllByUserNull()){
                order.setUser(currentUser);
                orderRepository.save(order);
            }
            model.addAttribute("user", currentUser);
        } else {
//            model.addAttribute("guestOrders",orderRepository.findAllByComplete(false));
            model.addAttribute("guestOrders",orderRepository.findAllByUserNull());
        }
        return "cart";
    }


}