package com.employeeportal.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import model.Employee;
import model.RFIDKey;
import repository.EmployeeRepository;
import repository.RFIDKeyRepository;

@DataJpaTest
@ActiveProfiles("test")
public class EmployeeServiceIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RFIDKeyRepository rfidKeyRepository;

    @BeforeEach
    public void setUp() {
        // Cargar datos de prueba antes de cada prueba
        Employee employee1 = new Employee("John", "Doe", "john.doe@example.com");
        Employee employee2 = new Employee("Jane", "Smith", "jane.smith@example.com");



        // Establecer la relación bidireccional antes de guardar los llaveros RFID
   //     employee1.getRfidKeys().add(rfidKey1);
    //    rfidKey1.setEmployee(employee1);


        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    public void testEmployeeRfidKeys() {
        // Aquí puedes realizar pruebas con las relaciones entre empleados y llaveros RFID
    }

    // Agrega aquí más pruebas de integración según tus necesidades
}
