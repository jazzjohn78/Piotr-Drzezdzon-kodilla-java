package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacadeTestSuite {

    @Autowired
    private Facade facade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testCompanyFacadeSearch() {
        //given
        Company company1 = new Company("Data Processors");
        Company company2 = new Company("Work Sceptics");
        Company company3 = new Company("Worship Beginners");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        int id1 = company1.getId();
        int id2 = company2.getId();
        int id3 = company3.getId();

        //when
        List<Company> resultCompanies = facade.findCompaniesByNamePart("ce");

        //then
        try {
            assertEquals(2, resultCompanies.size());
        } finally {
            //cleanUp
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }
    }

    @Test
    void testEmployeeFacadeSearch() {
        List<Employee> theEmployees =  facade.findEmployeesByNamePart("va");
        System.out.println("Found employees:" + theEmployees.size());


        //given
        Employee john = new Employee("John", "Jazz");
        Employee susan = new Employee("Susan", "Novak");
        Employee mark = new Employee("Mark", "Buzzer");

        Company company = new Company("At Least Show Up");

        company.getEmployees().add(john);
        company.getEmployees().add(susan);
        company.getEmployees().add(mark);

        john.getCompanies().add(company);
        susan.getCompanies().add(company);
        mark.getCompanies().add(company);

        companyDao.save(company);
        int id = company.getId();

        //when
        List<Employee> resultEmployees = facade.findEmployeesByNamePart("zz");

        //then
        try {
            assertEquals(2, resultEmployees.size());
        } finally {
            //cleanUp
            companyDao.deleteById(id);
        }
    }
}
