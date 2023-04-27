package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //given
        Product milk = new Product("milk");
        Product bread = new Product("bread");
        Product eggs = new Product("eggs");

        Item item1 = new Item(new BigDecimal(3.5), 2, new BigDecimal(7.0));
        Item item2 = new Item(new BigDecimal(5.5), 1, new BigDecimal(5.5));
        Item item3 = new Item(new BigDecimal(3.5), 1, new BigDecimal(3.5));
        Item item4 = new Item(new BigDecimal(2.0), 12, new BigDecimal(24.0));

        Invoice invoice = new Invoice("1/2023");

        item1.setProduct(milk);
        item2.setProduct(bread);
        item3.setProduct(milk);
        item4.setProduct(eggs);
        milk.getItems().add(item1);
        milk.getItems().add(item3);
        bread.getItems().add(item2);
        eggs.getItems().add(item4);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //when
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //then
        assertNotEquals(0, id);

        //cleanUp
        invoiceDao.deleteById(id);
    }
}
