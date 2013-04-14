/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.servlet;

import com.supinfo.salesbetou.service.ChannelDao;
import com.supinfo.salesbetou.service.CountryDao;
import com.supinfo.salesbetou.service.CustomerDao;
import com.supinfo.salesbetou.service.ProductDao;
import com.supinfo.salesbetou.service.SaleDao;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yannick
 */
public class IndexServlet extends HttpServlet {

    @EJB
    private SaleDao saleDao;
    @EJB
    private ProductDao productDao;
    @EJB
    private ChannelDao channelDao;
    @EJB
    private CountryDao countryDao;
    @EJB
    private CustomerDao customerDao;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //THE DASHBOARD
        
        /*FILTERING*/
        request.setAttribute("countries", countryDao.getAllCountries());
        request.setAttribute("genders", customerDao.getGenders());
        request.setAttribute("incomeLevels", customerDao.getIncomeLevels());
        request.setAttribute("maritalStatuses", customerDao.getMaritalStatus());
        
        Map<String, String> filter = new HashMap<String, String>();
        filter.put("country", (!"".equals((String) request.getParameter("filter_country"))) ? (String) request.getParameter("filter_country") : null);
        filter.put("gender", (!"".equals((String) request.getParameter("filter_gender"))) ? (String) request.getParameter("filter_gender") : null);
        filter.put("maritalstatus", (!"".equals((String) request.getParameter("filter_maritalstatus"))) ? (String) request.getParameter("filter_maritalstatus") : null);
        filter.put("incomelevel", (!"".equals((String) request.getParameter("filter_incomelevel"))) ? (String) request.getParameter("filter_incomelevel") : null);
        
        request.setAttribute("filter_country", filter.get("country"));
        request.setAttribute("filter_gender", filter.get("gender"));
        request.setAttribute("filter_incomelevel", filter.get("incomelevel"));
        request.setAttribute("filter_maritalstatus", filter.get("maritalstatus"));
        
        /*GET ALL THE DATA*/
        request.setAttribute("salesNumber", saleDao.getNumberOfSales(filter));
        request.setAttribute("totalAmount", saleDao.getTotalAmount(filter));
        request.setAttribute("bestProducts", productDao.getBestSellingProducts(filter));
        request.setAttribute("worstProducts", productDao.getLessSoldProducts(filter));
        request.setAttribute("channelsBreakdown", channelDao.getBreadkdownByChannel(filter));
        request.setAttribute("countriesBreakdown", countryDao.getBreadkdownByCountry(filter));
        
        request.setAttribute("gendersBreakdown", customerDao.getBreakDownByGender(filter));
        request.setAttribute("maritalstatusesBreakdown", customerDao.getBreakDownByMaritalstatus(filter));
        request.setAttribute("incomelevelsBreakdown", customerDao.getBreakDownByIncomelevel(filter));
        request.setAttribute("bestCustomers", customerDao.getBestCustomers(filter));
        
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}
