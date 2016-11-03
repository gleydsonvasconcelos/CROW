/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.crow.view.servlets;

import br.edu.garanhuns.ifpe.crow.classes.CrudAttribute;
import br.edu.garanhuns.ifpe.crow.classes.StringUtil;
import br.edu.garanhuns.ifpe.crow.classes.Utils;
import br.edu.garanhuns.ifpe.crow.interfaces.CrowActionController;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1860915
 */
@WebServlet(name = "GenericInsertServlet", urlPatterns = {"/GenericInsertServlet"})
public class GenericInsertServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userPath = request.getServletPath();

        Class usedBean = (Class) session.getAttribute("usedBean");
        CrowActionController usedController = (CrowActionController) session.getAttribute("usedController");

        List<CrudAttribute> atributos = Utils.getBeanNames(usedBean);

        Method m;
        
        Object bean = null;
        try {
            bean = usedBean.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (CrudAttribute a : atributos) {
            try {
                m = usedBean.getDeclaredMethod("set" + StringUtil.upperCaseFirst(a.getName()), a.getType());
                if (a.getType().getName().contains("Int")) {
                    m.invoke(bean, Integer.parseInt(request.getParameter(a.getName())));
                } else {
                    String p = request.getParameter(a.getName());
                    m.invoke(bean, p);
                }
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        usedController.create(bean);
        

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("Cadastrado com Sucesso");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
