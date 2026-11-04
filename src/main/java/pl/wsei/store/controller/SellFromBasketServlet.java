package pl.wsei.store.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.wsei.store.service.BasketService;
import pl.wsei.store.service.BasketService.SellResult;

import java.io.IOException;

@WebServlet(name = "SellFromBasketServlet", value = "/sell-from-basket")
public class SellFromBasketServlet extends HttpServlet {

    private final BasketService basketService = new BasketService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        Integer quantity = QuantityParam.parse(request.getParameter("quantity"));

        if (item == null || item.isBlank()) {
            redirectToBasket(request, response, BasketServlet.ERROR_MISSING_ITEM);
            return;
        }
        if (quantity == null) {
            redirectToBasket(request, response, BasketServlet.ERROR_INVALID_QUANTITY);
            return;
        }

        SellResult result;
        try {
            result = basketService.sellItem(item, quantity);
        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        }

        switch (result) {
            case NOT_IN_BASKET:
                redirectToBasket(request, response, BasketServlet.ERROR_NOT_IN_BASKET);
                break;
            case NOT_ENOUGH:
                redirectToBasket(request, response, BasketServlet.ERROR_NOT_ENOUGH);
                break;
            default:
                redirectToBasket(request, response, null);
        }
    }

    private static void redirectToBasket(HttpServletRequest request, HttpServletResponse response, String error) throws IOException {
        String url = request.getContextPath() + "/basket-servlet";
        response.sendRedirect(error == null ? url : url + "?error=" + error);
    }
}
