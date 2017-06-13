/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author admin
 */
public class SessionMessage {
    public static void getMessage(HttpServletRequest request)
    {
        String message = (String)request.getSession().getAttribute("message");
        if(message!=null)
        {
            request.getSession().setAttribute("message",null);
            request.setAttribute("message",message);
        }
    }
    public static void setMessage(HttpServletRequest request, String message)
    {
        request.getSession().setAttribute("message",message);
    }
    public static Integer getInt(HttpServletRequest request)
    {
        Integer i = (Integer)request.getSession().getAttribute("int");
        request.getSession().setAttribute("int", null);
        return i;
    }
    public static void setInt(HttpServletRequest request, int i)
    {
        request.getSession().setAttribute("int", i);
    }
}
