package pl.wsei.store.controller;

import java.io.*;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import pl.wsei.store.model.Basket;
import pl.wsei.store.service.BasketService;

@WebServlet(name = "BasketServlet", value = "/basket-servlet")
public class BasketServlet extends HttpServlet {

    static final String ERROR_MISSING_ITEM = "missing-item";
    static final String ERROR_INVALID_QUANTITY = "invalid-quantity";

    private static final Map<String, String> ERROR_MESSAGES = Map.of(
            ERROR_MISSING_ITEM, "Nie wybrano produktu.",
            ERROR_INVALID_QUANTITY, "Ilość musi być liczbą całkowitą większą od zera."
    );

    private BasketService basketService = new BasketService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<Basket> items = basketService.getAllItems();

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Oto aktualny stan Twojego koszyka:</h1>");

        String errorCode = request.getParameter("error");
        String error = errorCode == null ? null : ERROR_MESSAGES.get(errorCode);
        if (error != null) {
            out.println("<p style='color:red'>" + error + "</p>");
        }

        if (items != null && !items.isEmpty()) {
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Item</th><th>Ilość</th></tr>");
            for (Basket item : items) {
                out.println("<tr>");
                out.println("<td>" + item.getId() + "</td>");
                out.println("<td>" + item.getItem() + "</td>");
                out.println("<td>" + item.getQuantity() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            out.println("<br>");
            out.println("<form action='" + request.getContextPath() + "/clear-basket' method='post'>");
            out.println("<input type='submit' value='Wyczyść koszyk'>");
            out.println("</form>");
        } else {
            out.println("<p>Koszyk jest pusty.</p>");
        }

        out.println("<br><br>");
        out.println("<form action='" + request.getContextPath() + "/index.jsp' method='get'>");
        out.println("<input type='submit' value='Powrót do strony głównej'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
