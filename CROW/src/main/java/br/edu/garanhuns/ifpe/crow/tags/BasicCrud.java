package br.edu.garanhuns.ifpe.crow.tags;

import br.edu.garanhuns.ifpe.crow.classes.CrudElements;
import br.edu.garanhuns.ifpe.crow.classes.Utils;
import br.edu.garanhuns.ifpe.crow.interfaces.CrowActionController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1860915
 */
public class BasicCrud extends SimpleTagSupport {

    private String usedBean;
    private CrowActionController usedActionController;

    public void setUsedBean(String usedBean) {
        this.usedBean = usedBean;
    }

    public void setUsedActionController(CrowActionController usedActionController) {
        this.usedActionController = usedActionController;
    }

    @Override
    public void doTag() throws IOException {
        Class classBean = null;
        CrowActionController classController = null;
        
        try {
            classBean = Class.forName(usedBean);
            classController = usedActionController;
        } catch (ClassNotFoundException ex) {
            getJspContext().getOut().write("<h1>Erro the class " + ex.getMessage() + " was not found</h1>");
        }

        getJspContext().setAttribute("usedBean", classBean, PageContext.SESSION_SCOPE);
        getJspContext().setAttribute("usedController", classController, PageContext.SESSION_SCOPE);
        
        JspWriter out = getJspContext().popBody();

        CrudElements elements = new CrudElements();
        
        StringBuilder sb = new StringBuilder();
        
        InputStream in = getClass().getResourceAsStream("/META-INF/resources/templates/crud.ftlh");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (br.ready()) {
            String linha = br.readLine();
            sb.append(linha);
        }        
        br.close();
        
        String s = sb.toString();
        
        s = s.replace("${table}", elements.list(classBean, usedActionController.list()));
        s = s.replace("${dialogUpdate}", elements.modalUpdate(classBean, "", "GenericServletUpdate"));
        s = s.replace("${dialogInsert}", elements.modalCreate(classBean, "",  "GenericInsertServlet"));
        
        out.println(s);

        /*
         out.println("<script src='http://code.jquery.com/jquery-3.1.1.js'></script>"
         + "<script>$(function(){\n"
         + "    \n"
         + "    $(\"[value='cadastrar']\").click(function(){\n"
         + "       var fields = $(\"[name]\");\n"
         + "    \n"
         + "        var parametros = \"\";\n"
         + "    \n"
         + "        for(var i = 0;i<fields.length;i++){\n"
         + "            parametros += $(fields[i]).attr(\"name\")+\":\"+$(fields[i]).val()+\";\"; \n"
         + "        }\n"
         + "         console.log(parametros)"
         + "    \n"
         + "        $.post(\"GenericInsertServlet\",{param:parametros},\n"
         + "        function(data){\n"
         + "            $(\"#mensagem\").html(data);\n"
         + "        }); \n"
         + "        });\n"
         + "    \n"
         + "    \n"
         + "    \n"
         + "});</script>");
            
         out.println("<p id='mensagem'></p>");
         out.println("<form>");
         Field[] fields = classBean.getDeclaredFields();
         for (Field f : fields) {
         out.print(f.getName() + ": <input type='text' name='" + f.getName() + "'/><br/>");
         }
         out.print("<input type='button' value='cadastrar' />");
         out.println("</form>");
         */
    }

}
