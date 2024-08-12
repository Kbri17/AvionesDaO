package dao.impl;

import dao.IDao;
import db.H2Connection;
import model.Avion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class DaoH2Avion implements IDao<Avion> {
    public static final Logger logger = Logger.getLogger(DaoH2Avion.class);
    public static final String INSERT = "INSERT INTO AVIONES VALUES (DEFAULT, ?,?,?,?)";
    public static final String SELECT_ID = "SELECT * FROM AVIONES WHERE ID = ?";


    @Override
    public Avion guardar(Avion avion) {
        Connection connection = null;
        Avion avionARetornar = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, avion.getMarca());
            preparedStatement.setString(2, avion.getModelo());
            preparedStatement.setString(3, avion.getMatricula());
            preparedStatement.setDate(4,Date.valueOf(avion.getFechaEntradaServicio()));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer idDesdeDB = resultSet.getInt(1);
                avionARetornar = new Avion(idDesdeDB, avion.getMarca(), avion.getModelo(), avion.getMatricula(),avion.getFechaEntradaServicio());
            }
            logger.info("avion guardado en base de datos"+ avionARetornar );

            connection.commit();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return avionARetornar;
    }

    @Override
    public Avion buscar(Integer id) {
        Connection connection = null;
        Avion avionEncontrado = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer idDB = resultSet.getInt(1);
                String marca = resultSet.getString(2);
                String modelo = resultSet.getString(3);
                String matricula = resultSet.getString(4);
                LocalDate fechaEntradaServicio = resultSet.getDate(5).toLocalDate();
                avionEncontrado = new Avion(idDB, marca, modelo, matricula, fechaEntradaServicio);
            }
            if(avionEncontrado!= null){
                logger.info("avion encontrado "+ avionEncontrado);
            } else {
                logger.info("avion no encontrado");
            }

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return avionEncontrado;
    }

    @Override
    public List<Avion> listarTodos() {
        return List.of();
    }
}
