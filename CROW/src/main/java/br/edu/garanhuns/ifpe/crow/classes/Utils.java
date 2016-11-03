/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.crow.classes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class Utils {

    public static List<CrudAttribute> getBeanNames(Class classBean) {

        List<CrudAttribute> beanNames = new ArrayList<>();
        Field[] fields = classBean.getDeclaredFields();
        CrudAttribute atributo;
        for (Field f : fields) {
            atributo = new CrudAttribute();
            atributo.setName(f.getName());
            atributo.setType(f.getType());
            beanNames.add(atributo);
        }
        return beanNames;
    }

    
}
