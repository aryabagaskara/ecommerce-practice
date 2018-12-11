package tdi.bootcamp.ecommerce.ecommercetraining.controller;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRHibernateIterateDataSource;
import net.sf.jasperreports.engine.data.JRJpaDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;
import tdi.bootcamp.ecommerce.ecommercetraining.service.TransaksiService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    TransaksiService service;

    @GetMapping("/transaksi/{id}")
    public void exampleReport(HttpServletResponse response,@PathVariable("id") String id) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/jasperReport.jasper");
        Map<String,Object> item = new HashMap<>();
        Optional<Transaksi> transaksi = service.findById(id);
        if (transaksi.isPresent()) {
            Transaksi transaksi1 = transaksi.get();
            BigDecimal total = new BigDecimal(String.valueOf(transaksi1.getBiaya()));
            total = total.multiply(BigDecimal.valueOf(transaksi1.getQty()));
            item.put("total_biaya",total);
            item.put("transaksi",transaksi1);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, item, new JREmptyDataSource());
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=example.pdf");
            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        }

//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, item, new JREmptyDataSource());
//        response.setContentType("application/x-pdf");
//        response.setHeader("Content-disposition", "inline; filename=example.pdf");
//
//        final OutputStream outStream = response.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }



}
