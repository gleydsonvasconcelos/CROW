/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.crow.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casa01
 */
public class CrudElements<T> {

    public static final String TEXT = "text";
    public static final String SUBMIT = "submit";

    public static final String GET = "GET";
    public static final String POST = "POST";

    private String input(String name, String type, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"");
        sb.append(type);
        sb.append("\" name=\"");
        sb.append(name);
        sb.append("\" class=\"form-control\"");
        sb.append(" value=\"");
        sb.append(value);
        sb.append("\">");

        return sb.toString();
    }

    public String defaultButton(String id, String name, String type) {
        StringBuilder sb = new StringBuilder();

        sb.append("<button class=\"bt-padrao bt\" id=\"");
        sb.append(id);
        sb.append("\" type=\"");
        sb.append(type);
        sb.append("\">");
        sb.append(name);
        sb.append("</button>");

        return sb.toString();
    }

    private String input(String name, String type, String value, String label) {
        StringBuilder sb = new StringBuilder();
        sb.append("<label for>");
        sb.append(label);
        sb.append("</label>");
        sb.append("<input type=\"");
        sb.append(type);
        sb.append("\" name=\"");
        sb.append(name);
        sb.append("\" class=\"form-control\"");
        sb.append(" value=\"");
        sb.append(value);
        sb.append("\">");

        return sb.toString();
    }

    public String create(Class classBean, String method, String action) {
        String m;
        m = method.isEmpty() ? CrudElements.POST : method;

        StringBuilder sb = new StringBuilder();
        sb.append("<form ");
        sb.append(" method=\"");
        sb.append(m);
        sb.append("\" action=\"");
        sb.append(action);
        sb.append("\"");
        sb.append(">");
        sb.append("<div class=\"row\">");
        sb.append("<div class=\"col-xs-12\">");

        Field[] fields = classBean.getDeclaredFields();
        for (Field f : fields) {
            try {
                sb.append("<div class=\"form-grup\">");
                sb.append(this.input(f.getName(), CrudElements.TEXT, "", f.getName()));
                sb.append("</div>");
            } catch (SecurityException | IllegalArgumentException ex) {
                Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
            }

            sb.append("<br/>");
        }
        sb.append("</div>");
        sb.append("</div>");
        sb.append("<div class=\"modal-footer\">");
        sb.append(this.defaultButton("btSalvar", "Salvar Alterações", CrudElements.SUBMIT));
        sb.append("</div>");
        sb.append("</form>");

        return sb.toString();
    }

    public String modalCreate(Class classBean, String method, String action) {
        String m;
        m = method.isEmpty() ? CrudElements.POST : method;

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" id=\"modal-add\" aria-hidden=\"true\" style=\"display: none;\">");
        sb.append("<div class=\"modal-dialog\" role=\"document\">");
        sb.append("<div class=\"modal-content\">");
        sb.append("<div class=\"modal-header\">");
        sb.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>");
        sb.append("<h4 class=\"modal-title\">Adicionar</h4>");
        sb.append("</div>");

        sb.append("<form id=\"crow-add-form\" ");
        sb.append(" method=\"");
        sb.append(m);
        sb.append("\" action=\"");
        sb.append(action);
        sb.append("\"");
        sb.append(">");

        sb.append("<div class=\"modal-body\">");
        sb.append("<div class=\"row\">");
        sb.append("<div class=\"col-xs-12\">");

        Field[] fields = classBean.getDeclaredFields();
        for (Field f : fields) {
            try {
                sb.append("<div class=\"form-grup\">");
                sb.append(this.input(f.getName(), CrudElements.TEXT, "", f.getName()));
                sb.append("</div>");
            } catch (SecurityException | IllegalArgumentException ex) {
                Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("<div class=\"modal-footer\">");
        sb.append(this.defaultButton("btSalvar", "Salvar Alterações", CrudElements.SUBMIT));
        sb.append("</div>");
        sb.append("</form>");

        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }

    public String modalUpdate(Class classBean, String method, String action) {
        String m;
        m = method.isEmpty() ? CrudElements.POST : method;

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" id=\"modal-update\" aria-hidden=\"true\">");
        sb.append("<div class=\"modal-dialog\" role=\"document\">");
        sb.append("<div class=\"modal-content\">");
        sb.append("<div class=\"modal-header\">");
        sb.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>");
        sb.append("<h4 class=\"modal-title\">Editar</h4>");
        sb.append("</div>");

        sb.append("<form id=\"crow-update-form\" ");
        sb.append(" method=\"");
        sb.append(m);
        sb.append("\" action=\"");
        sb.append(action);
        sb.append("\"");
        sb.append(">");

        sb.append("<div class=\"modal-body\">");
        sb.append("<div class=\"row\">");
        sb.append("<div class=\"col-xs-12\">");

        
        
        Field[] fields = classBean.getDeclaredFields();
        
        for (Field f : fields) {
            try {
                sb.append("<div class=\"form-grup\">");
                sb.append(this.input(f.getName(), CrudElements.TEXT, "", f.getName()));
                sb.append("</div>");
            } catch (SecurityException | IllegalArgumentException ex) {
                Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("<div class=\"modal-footer\">");
        sb.append(this.defaultButton("btSalvar", "Salvar Alterações", CrudElements.SUBMIT));
        sb.append("</div>");
        sb.append("</form>");

        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }

    public String update(T objectBean, String method, String action) {
        Class classBean;
        classBean = objectBean.getClass();
        String m;
        m = method.isEmpty() ? CrudElements.POST : method;

        StringBuilder sb = new StringBuilder();
        sb.append("<form ");
        sb.append(" method=\"");
        sb.append(m);
        sb.append("\" action=\"");
        sb.append(action);
        sb.append("\"");
        sb.append(">");

        Field[] fields = classBean.getDeclaredFields();
        for (Field f : fields) {
            try {
                Method meth = classBean.getMethod("get" + StringUtil.upperCaseFirst(f.getName()));
                String value = String.valueOf(meth.invoke(objectBean)).equals("null") ? "" : String.valueOf(meth.invoke(objectBean));

                sb.append(this.input(f.getName(), CrudElements.TEXT, value, f.getName()));
            } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
            }

            sb.append("<br/>");
        }
        sb.append(this.input("", CrudElements.SUBMIT, "enviar"));
        sb.append("</form>");

        return sb.toString();
    }

    public String list(Class classBean, List<T> list) {

        List<String> atributtes = new ArrayList<String>();
        Field[] fields = classBean.getDeclaredFields();
        
        for (Field f : fields) {
            atributtes.add(f.getName());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"container\">");
        sb.append("<div class=\"row\">");
        sb.append("<div class=\"col-xs-12\">");
        sb.append("<button class=\"bt-padrao bt\" id=\"add-registro\">Adicionar</button>");
        sb.append("<div class=\"content\">");
        sb.append("<div class=\"table-responsive\">");
        sb.append("<table class=\"table table-hover table-striped\">");

        sb.append("<thead>");
        sb.append("<tr>");
        for (String value : atributtes) {
            sb.append("<th>");
            sb.append(value);
            sb.append("</th>");
        }
        
        sb.append("<th>");
        sb.append("Operação");
        sb.append("</th>");
        sb.append("</tr>");
        sb.append("</thead>");

        for (Object objectBean : list) {
            sb.append("<tbody>");
            sb.append("<tr>");
            for (String atributte : atributtes) {
                Method meth;
                try {
                    meth = classBean.getMethod("get" + StringUtil.upperCaseFirst(atributte));
                    String value = String.valueOf(meth.invoke(objectBean)).equals("null") ? "" : String.valueOf(meth.invoke(objectBean));

                    sb.append("<td>");
                    sb.append(value);
                    sb.append("</td>");
                } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(CrudElements.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            sb.append("<td>");
            sb.append("<a href=\"  \" class=\"tooltips\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Editar\">");
            sb.append("<div class=\"table-ops editar\"></div>");
            sb.append("</a>");

            sb.append("<a class=\"tooltips\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Excluir\">");
            sb.append("<div class=\"table-ops excluir bt-excluir\" data-info=\"info\"></div>");
            sb.append("</a>");
            sb.append("</tr>");
        }

        sb.append("</tbody>");
        sb.append("</table>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");

        return sb.toString();
    }

}
