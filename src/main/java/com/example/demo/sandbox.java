//package com.example.demo;
//
//public class sandbox {
//
//    Ingredient cheese = new Ingredient();
//        cheese.setName("Mozzarella");
//        ingredientRepository.save(cheese);
//
//    Ingredient vegetable = new Ingredient();
//        vegetable.setName("Green Pepper");
//        ingredientRepository.save(vegetable);
//
//    Ingredient protein = new Ingredient();
//        protein.setName("Pepporoni");
//        ingredientRepository.save(protein);
//
//    Ingredient dough = new Ingredient();
//        dough.setName("Gluten-Free");
//        ingredientRepository.save(dough);
//
//    //adding to calculate price
//
//    Ingredient misc = new Ingredient();
//        misc.setName("misc");
//        ingredientRepository.save(misc);
//
//    Ingredient misc2 = new Ingredient();
//        misc.setName("misc2");
//        ingredientRepository.save(misc2);
//
//    Ingredient sauce1 = new Ingredient();
//        sauce1.setName("Classic Tomato");
//        ingredientRepository.save(sauce1);
//
//    Ingredient sauce2 = new Ingredient();
//        sauce2.setName("White Sauce");
//        ingredientRepository.save(sauce2);
//
//
//    Order order1 = new Order();
//
//    Pizza pizza1 = new Pizza();
//        pizza1.addIngredient(cheese);
//        pizza1.addIngredient(vegetable);
//        pizza1.addIngredient(dough);
//        pizza1.addIngredient(protein);
//        pizza1.addIngredient(misc);
//        pizza1.addIngredient(misc2);
//
//        order1.setUser(user1);
//        pizza1.setOrder(order1);  //replaced with order1.addPizza
//        pizza1.setPrice(pizza1.calculatePrice());
////        pizzaRepository.save(pizza1);
//        order1.addPizza(pizza1);
//
//    Pizza pizza2 = new Pizza();
//        pizza2.addIngredient(dough);
//        pizza2.addIngredient(vegetable);
//        pizza2.addIngredient(protein);
//        pizza2.setOrder(order1); // replaced with order1.addPizza
////        pizzaRepository.save(pizza2);
//        pizza2.setPrice(pizza2.calculatePrice());
//        order1.addPizza(pizza2);
//
//        order1.setTotal(order1.calculateTotal());
//        orderRepository.save(order1);
//    Order order2 = new Order();
//        order2.setUser(user1);
//        orderRepository.save(order2);
//
//        System.out.println("Total for order 1: " + order1.getTotal());
//
//
////        int orderNum = 0;
////        for (Order order : user1.getOrders()){
////            System.out.println("Order#"+orderNum +": " + order.getTotal());
////        }
//
//
//}
