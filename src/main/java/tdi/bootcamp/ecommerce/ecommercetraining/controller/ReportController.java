package tdi.bootcamp.ecommerce.ecommercetraining.controller;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tdi.bootcamp.ecommerce.ecommercetraining.entity.Transaksi;
import tdi.bootcamp.ecommerce.ecommercetraining.service.TransaksiService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    TransaksiService service;

    @GetMapping("/transaksi/struk/{id}")
    public void exampleReport(HttpServletResponse response, @PathVariable("id") String id) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/jasperReport.jasper");
        Map<String, Object> item = new HashMap<>();
        Optional<Transaksi> transaksi = service.findById(id);
        if (transaksi.isPresent()) {
            Transaksi transaksi1 = transaksi.get();
            item.put("transaksi", transaksi1);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, item, new JREmptyDataSource());
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=example.pdf");
            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        }
    }

    @GetMapping("/transaksi/list")
    public void reportTransaksi(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/2ndJesper.jasper");
        Map<String, Object> item = new HashMap<>();
        List listTransaksi = service.findAll();
        item.put("transaksi", listTransaksi);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, item, new JRBeanCollectionDataSource(listTransaksi));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=example.pdf");
        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }


}
