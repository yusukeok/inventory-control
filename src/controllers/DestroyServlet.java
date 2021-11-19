package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.SmartphoneList;
import utils.DBUtil;

/**
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            SmartphoneList sl = em.find(SmartphoneList.class, (Integer)(request.getSession().getAttribute("smartphonelist_id")));

            em.getTransaction().begin();
            em.remove(sl);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "削除しました。");
            em.close();

            request.getSession().removeAttribute("smartphonelist_id");

            response.sendRedirect(request.getContextPath() + "/index");

        }

    }

}
