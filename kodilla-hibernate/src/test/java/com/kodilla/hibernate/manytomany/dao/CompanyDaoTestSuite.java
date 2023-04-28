package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //when
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //cleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testEmployeeDaoNamedQuery() {
        //given
        Employee john = new Employee("John", "Jazz");
        Employee susan = new Employee("Susan", "Novak");
        Employee mark = new Employee("Mark", "Jazz");

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
        List<Employee> jazzNamed = employeeDao.retrieveEmployeesWithNameEqualTo("Jazz");

        //then
        try {
            assertEquals(2, jazzNamed.size());
        } finally {
            //cleanUp
            companyDao.deleteById(id);
        }

    }

    @Test
    void testCompanyDaoNamedNativeQuery() {
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
        List<Company> resultCompanies = companyDao.retrieveCompaniesWithNameStartingWith("Wor");

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
}
