package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import enums.Gender;
import repository.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testEmployeeSaveAndFind() {
        // Crear un objeto Employee para realizar las pruebas
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailId("john.doe@example.com");
        employee.setGender(Gender.MALE);

        // Guardar el empleado en la base de datos
        Employee savedEmployee = employeeRepository.save(employee);

        // Buscar el empleado por su ID
        Employee foundEmployee = employeeRepository.findById(savedEmployee.getId()).orElse(null);

        // Verificar que el empleado se haya guardado correctamente y se le haya asignado un ID
        assertNotNull(savedEmployee.getId());
        assertEquals("John", savedEmployee.getFirstName());
        assertEquals("Doe", savedEmployee.getLastName());
        assertEquals("john.doe@example.com", savedEmployee.getEmailId());

        // Verificar que se haya encontrado el empleado y que los datos coincidan
        assertNotNull(foundEmployee);
        assertEquals(savedEmployee.getId(), foundEmployee.getId());
        assertEquals("John", foundEmployee.getFirstName());
        assertEquals("Doe", foundEmployee.getLastName());
        assertEquals("john.doe@example.com", foundEmployee.getEmailId());
        assertEquals(Gender.MALE, foundEmployee.getGender());
    }

    // Puedes agregar más pruebas según tus necesidades

}
