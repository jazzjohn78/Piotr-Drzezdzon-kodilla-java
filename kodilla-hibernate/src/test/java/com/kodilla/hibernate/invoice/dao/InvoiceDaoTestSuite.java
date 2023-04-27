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
        Item item5 = new Item(new BigDecimal(5.5), 3, new BigDecimal(16.5));
        Item item6 = new Item(new BigDecimal(2.0), 6, new BigDecimal(12.0));

        Invoice invoice1 = new Invoice("1/2023");
        Invoice invoice2 = new Invoice("2/2023");
        Invoice invoice3 = new Invoice("3/2023");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);
        invoice2.getItems().add(item4);
        invoice3.getItems().add(item5);
        invoice3.getItems().add(item6);
        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);
        item5.setInvoice(invoice3);
        item6.setInvoice(invoice3);

        //when
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);
        int id1 = invoice1.getId();
        int id2 = invoice2.getId();
        int id3 = invoice3.getId();

        item1.setProduct(milk);     //nie pozwalał mi tego ustawić przed wywołaniem invoiceDao.save
        item2.setProduct(bread);    //czy teraz się w ogóle zapisze w bazie?
        item3.setProduct(milk);     //czy może mam utworzyć instancję productDao i wywołać na niej save przed wywołaniem invoiceDao.save?
        item4.setProduct(eggs);
        item5.setProduct(bread);
        item6.setProduct(eggs);
        milk.getItems().add(item1);
        milk.getItems().add(item3);
        bread.getItems().add(item2);
        bread.getItems().add(item5);
        eggs.getItems().add(item4);
        eggs.getItems().add(item6);

        //then
        assertNotEquals(0, id1);
        assertNotEquals(0, id2);
        assertNotEquals(0, id3);

        //cleanUp
        invoiceDao.deleteById(id1);
        invoiceDao.deleteById(id2);
        invoiceDao.deleteById(id3);
    }
}
