package dao.impl;

import dao.IDao;
import model.Avion;
import org.apache.log4j.Logger;

import java.util.List;

public class DaoH2Avion implements IDao<Avion> {
    public static final Logger logger = Logger.getLogger(DaoH2Avion.class);
    public static final String INSERT = "INSERT INTO AVIONES VALUES (DEFAULT, ?,?,?,?)";


    @Override
    public Avion guardar(Avion avion) {
        return null;
    }

    @Override
    public Avion buscar(Integer id) {
        return null;
    }

    @Override
    public List<Avion> listarTodos() {
        return List.of();
    }
}
