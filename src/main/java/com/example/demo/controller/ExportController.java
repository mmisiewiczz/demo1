package com.example.demo.controller;

import com.example.demo.service.CSVExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private CSVExportService csvExportService;

    @GetMapping("/clients")
    public void exportClientsToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=clients.csv");
        csvExportService.writeClientsToCsv(response.getWriter());
    }

    @GetMapping("/products")
    public void exportProductsToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=products.csv");
        csvExportService.writeProductsToCsv(response.getWriter());
    }

    @GetMapping("/orders")
    public void exportOrdersToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=orders.csv");
        csvExportService.writeOrdersToCsv(response.getWriter());
    }
}
