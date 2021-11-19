package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.SmartphoneList;
import models.validators.SmartphoneListValidator;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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

            String manufacturing_company = request.getParameter("manufacturing_company");
            sl.setManufacturing_company(manufacturing_company);

            String product_name = request.getParameter("product_name");
            sl.setProduct_name(product_name);

            String release_date = request.getParameter("release_date");
            sl.setRelease_date(release_date);

            String stock = request.getParameter("stock");
            sl.setStock(stock);

            List<String> errors = SmartphoneListValidator.validate(sl);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("smartphonelist", sl);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/stocks/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                em.close();

                request.getSession().removeAttribute("smartphonelist_id");

                response.sendRedirect(request.getContextPath() + "/index");
            }
        }
    }

}
