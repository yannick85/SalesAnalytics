/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.rest;

import com.supinfo.salesbetou.entity.Sale;
import com.supinfo.salesbetou.service.SaleDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Yannick
 */
@Stateless
@Path("/api/sales")
public class SalesResource {
    
    @EJB
    private SaleDao saleDao;
    
    @GET @Path("/canada") @Produces(MediaType.APPLICATION_JSON)
    public List<Sale> getCanadaSaleList() {
        List<Sale> sales = saleDao.getSalesByCountry(Long.valueOf(52772));
        return sales;
    }

}
