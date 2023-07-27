package com.employeeportal.springboot;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import model.Employee;
import repository.EmployeeRepository;

@DataJpaTest
@ActiveProfiles("test")
public class EmployeeUnitTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        // Puedes realizar configuraciones adicionales antes de cada prueba si es necesario
    }

    @AfterEach
    public void tearDown() {
        // Puedes realizar limpieza o restauración después de cada prueba si es necesario
    }

    @Test
    public void testSaveEmployee() {
        // Crear un objeto Employee para insertar en la base de datos
        Employee employee = new Employee("John", "Doe", "john.doe@example.com");

        // Guardar el empleado en la base de datos
        Employee savedEmployee = employeeRepository.save(employee);

    
    }

    @Test
    public void testFindEmployeeById() {
        // Crear un objeto Employee para insertar en la base de datos
        Employee employee = new Employee("Jane", "Smith", "jane.smith@example.com");

        // Guardar el empleado en la base de datos
        Employee savedEmployee = employeeRepository.save(employee);

        // Buscar el empleado por su ID
      //  Employee foundEmployee = employeeRepository.findById(savedEmployee.getId()).orElse(null);

        String expectedToString = "Employee{id=1, firstName='Jane', lastName='Smith', emailId='jane.smith@example.com'}";
        assertEquals(expectedToString, employee.toString());
    }

    // Agrega aquí más pruebas unitarias según tus necesidades

}
