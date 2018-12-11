//package tdi.bootcamp.ecommerce.ecommercetraining.controller;
//
//
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tdi.bootcamp.ecommerce.ecommercetraining.service.TransaksiService;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.math.BigDecimal;
//import java.util.*;
//
//@Controller
//@RequestMapping("/report")
//public class ReportController {
//
//    @Autowired
//    TransaksiService service;
//
//    @GetMapping("/example")
//    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
//        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/jaspertest.jasper");
//        Map<String,Object> params = new HashMap<>();
////        params.put("nama","Bambange Esekese");
////        params.put("status",false);
////        params.put("saldo", new BigDecimal(2000000));
////        Rak rakBuku = new Rak("001","bleukamba",4);
////
////        List<Rak> listRak = new ArrayList(service.list());
////        params.values(listRak);
//
//
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,new JRBeanCollectionDataSource(asd));
//        response.setContentType("application/x-pdf");
//        response.setHeader("Content-disposition","inline;filename=example.pdf");
//
//        final OutputStream outStream = response.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint,outStream);
//    }
//
//
//}
