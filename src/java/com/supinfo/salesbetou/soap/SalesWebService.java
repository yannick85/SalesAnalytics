/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.soap;

import com.supinfo.salesbetou.entity.Sale;
import com.supinfo.salesbetou.service.SaleDao;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Yannick
 */
@WebService (
        name="SalesWebService",
        serviceName="SalesWS"
)
public class SalesWebService {
    
    @EJB
    private SaleDao saleDao;
    
    @WebMethod( operationName="franceSales" )
    public List<Sale> getFranceSaleList() {
        List<Sale> sales = saleDao.getSalesByCountry(Long.valueOf(52779));
        return sales;
    }
}
