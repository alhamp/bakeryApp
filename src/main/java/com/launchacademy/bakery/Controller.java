package com.launchacademy.bakery;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/bakeries", "/bakeries/new", "/bakeries/order", "/bakeries/cancel"})
public class Controller extends HttpServlet {

  List<BakeryOrder> previousOrders = new ArrayList<BakeryOrder>();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if(req.getServletPath().equals("/bakeries/new")) {
      HttpSession session  = req.getSession();
      req.setAttribute("bakeryOrder", session.getAttribute("bakeryOrder"));
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/bakery/form.jsp");
      dispatcher.forward(req, resp);
    }else if(req.getServletPath().equals("/bakeries/order")){
      HttpSession session = req.getSession();
      req.setAttribute("bakeryOrder", session.getAttribute("bakeryOrder"));
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/bakery/show.jsp");
      dispatcher.forward(req, resp);
    }else if(req.getServletPath().equals("/bakeries/cancel")){
      HttpSession session = req.getSession();
      session.removeAttribute("bakeryOrder");
      resp.sendRedirect("/bakeries/new");
    }else if(req.getServletPath().equals("/bakeries")){
      HttpSession session = req.getSession();
      req.setAttribute("allOrders", session.getAttribute("allOrders"));
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/bakery/index.jsp");
      dispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if(req.getServletPath().equals("/bakeries")) {
      BakeryOrder bakeryOrder = new BakeryOrder();
      try {
        BeanUtils.populate(bakeryOrder, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }

      previousOrders.add(bakeryOrder);


      HttpSession session = req.getSession();
      session.setAttribute("bakeryOrder", bakeryOrder);
      session.setAttribute("allOrders", previousOrders);

      resp.sendRedirect("/bakeries/order");
    }
  }
}
