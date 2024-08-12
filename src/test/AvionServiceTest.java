package test;

import dao.impl.DaoH2Avion;
import model.Avion;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.AvionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AvionServiceTest {
    static final Logger logger = Logger.getLogger(AvionServiceTest.class);
    private static AvionService avionService = new AvionService(new DaoH2Avion());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./Database/aviones;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
    @Test
    @DisplayName("Testear que un avion fue cargado correctamente")
    void caso1(){

        //Dado
        Avion avion = new Avion("boeing","af","v9j", LocalDate.of(2024,7,15));
        //cuando
        Avion avionDesdeDb = avionService.guardarAvion(avion);
        // entonces
        assertNotNull(avionDesdeDb);
    }



}