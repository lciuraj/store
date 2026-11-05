package pl.wsei.store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.wsei.store.service.BasketService;

import java.io.IOException;

@WebServlet(name = "AddToBasketServlet", value = "/add-to-basket")
public class AddToBasketServlet extends HttpServlet {

    private final BasketService basketService = new BasketService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        Integer quantity = QuantityParam.parse(request.getParameter("quantity"));

        if (item == null || item.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/basket-servlet?error=" + BasketServlet.ERROR_MISSING_ITEM);
            return;
        }
        if (quantity == null) {
            response.sendRedirect(request.getContextPath() + "/basket-servlet?error=" + BasketServlet.ERROR_INVALID_QUANTITY);
            return;
        }

        try {
            basketService.buyItem(item, quantity);
            response.sendRedirect(request.getContextPath() + "/basket-servlet");
        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        }
    }
}
