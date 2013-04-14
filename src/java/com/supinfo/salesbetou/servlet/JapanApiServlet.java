/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.servlet;

import com.supinfo.salesbetou.entity.Sale;
import com.supinfo.salesbetou.service.SaleDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yannick
 */
public class JapanApiServlet extends HttpServlet {

    @EJB
    private SaleDao saleDao;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sale> sales = saleDao.getSalesByCountry(new Long(52782));
        response.setContentType("text/csv");
        PrintWriter out = response.getWriter();
        out.println("\"timeId\",\"quantitySold\",\"amountSold\",\"saleId\",\"prodId\",\"prodName\",\"prodDesc\",\"prodSubcategory\",\"prodSubcategoryId\","
                + "\"prodSubcategoryDesc\",\"prodCategory\",\"prodCategoryId\",\"prodCategoryDesc\",\"prodWeightClass\",\"prodUnitOfMeasure\",\"prodPackSize\","
                + "\"supplierId\",\"prodStatus\",\"prodListPrice\",\"prodMinPrice\",\"prodTotal\",\"prodTotalId\",\"prodSrcId\",\"prodEffFrom\",\"prodEffTo\","
                + "\"prodValid\",\"custId\",\"custFirstName\",\"custLastName\",\"custGender\",\"custYearOfBirth\",\"custMaritalStatus\",\"custStreetAddress\","
                + "\"custPostalCode\",\"custCity\",\"custCityId\",\"custStateProvince\",\"custStateProvinceId\",\"custMainPhoneNumber\",\"custIncomeLevel\","
                + "\"custCreditLimit\",\"custEmail\",\"custTotal\",\"custTotalId\",\"custSrcId\",\"custEffFrom\",\"custEffTo\",\"custValid\",\"countryId\","
                + "\"promoId\",\"promoName\",\"promoSubcategory\",\"promoSubcategoryId\",\"promoCategory\",\"promoCategoryId\",\"promoCost\",\"promoBeginDate\","
                + "\"promoEndDate\",\"promoTotal\",\"promoTotalId\",\"channelId\",\"channelDesc\",\"channelClass\",\"channelClassId\",\"channelTotal\",\"channelTotalId\"");
        for (Sale sale : sales) {
            out.println( "\"" +
                sale.getTime() + "\",\"" + 
                sale.getQuantitySold() + "\",\"" + 
                sale.getAmountSold() + "\",\"" + 
                sale.getId() + "\",\"" + 
                sale.getQuantitySold() + "\",\"" + 
                sale.getProduct().getId() + "\",\"" + 
                sale.getProduct().getName() + "\",\"" + 
                sale.getProduct().getDesc() + "\",\"" + 
                sale.getProduct().getSubcategory() + "\",\"" + 
                sale.getProduct().getSubcategoryId() + "\",\"" + 
                sale.getProduct().getSubcategoryDesc() + "\",\"" + 
                sale.getProduct().getCategory() + "\",\"" + 
                sale.getProduct().getCategoryId() + "\",\"" + 
                sale.getProduct().getCategoryDesc() + "\",\"" + 
                sale.getProduct().getWeightClass() + "\",\"" + 
                sale.getProduct().getUnitOfMeasure() + "\",\"" + 
                sale.getProduct().getPackSize() + "\",\"" + 
                sale.getProduct().getSupplierId() + "\",\"" + 
                sale.getProduct().getStatus() + "\",\"" + 
                sale.getProduct().getListPrice() + "\",\"" + 
                sale.getProduct().getMinPrice() + "\",\"" + 
                sale.getProduct().getTotal() + "\",\"" + 
                sale.getProduct().getTotalId() + "\",\"" + 
                sale.getProduct().getSrcId() + "\",\"" + 
                sale.getProduct().getEffFrom() + "\",\"" + 
                sale.getProduct().getEffTo() + "\",\"" + 
                sale.getProduct().getValid() + "\",\"" + 
                sale.getCustomer().getId() + "\",\"" + 
                sale.getCustomer().getFirstName() + "\",\"" + 
                sale.getCustomer().getLastName() + "\",\"" + 
                sale.getCustomer().getGender() + "\",\"" + 
                sale.getCustomer().getYearOfBirth() + "\",\"" + 
                sale.getCustomer().getMaritalStatus() + "\",\"" + 
                sale.getCustomer().getStreetAddress() + "\",\"" + 
                sale.getCustomer().getPostalCode() + "\",\"" + 
                sale.getCustomer().getCity() + "\",\"" + 
                sale.getCustomer().getCityId() + "\",\"" + 
                sale.getCustomer().getStateProvince() + "\",\"" + 
                sale.getCustomer().getStateProvinceId() + "\",\"" + 
                sale.getCustomer().getMainPhoneNumber() + "\",\"" + 
                sale.getCustomer().getIncomeLevel() + "\",\"" + 
                sale.getCustomer().getCreditLimit() + "\",\"" + 
                sale.getCustomer().getEmail() + "\",\"" + 
                sale.getCustomer().getTotal() + "\",\"" + 
                sale.getCustomer().getTotalId() + "\",\"" + 
                sale.getCustomer().getSrcId() + "\",\"" + 
                sale.getCustomer().getEffFrom() + "\",\"" + 
                sale.getCustomer().getEffTo() + "\",\"" + 
                sale.getCustomer().getValid() + "\",\"" + 
                sale.getCustomer().getCountry().getId() + "\",\"" + 
                sale.getPromotion().getId() + "\",\"" + 
                sale.getPromotion().getName() + "\",\"" + 
                sale.getPromotion().getSubcategory() + "\",\"" + 
                sale.getPromotion().getSubcategoryId() + "\",\"" + 
                sale.getPromotion().getCategory() + "\",\"" + 
                sale.getPromotion().getCategoryId() + "\",\"" + 
                sale.getPromotion().getCost() + "\",\"" + 
                sale.getPromotion().getBeginDate() + "\",\"" + 
                sale.getPromotion().getEndDate() + "\",\"" + 
                sale.getPromotion().getTotal() + "\",\"" + 
                sale.getPromotion().getTotalId() + "\",\"" + 
                sale.getChannel().getId() + "\",\"" + 
                sale.getChannel().getDesc() + "\",\"" + 
                sale.getChannel().getChannelClass() + "\",\"" + 
                sale.getChannel().getChannelClassId() + "\",\"" + 
                sale.getChannel().getTotal() + "\",\"" + 
                sale.getChannel().getTotalId() + "\""
            );
        }
    }
}
