package service;

import dao.IDao;
import model.Avion;

import java.util.List;

public class AvionService {
    private IDao<Avion> avionIDao;

    public AvionService(IDao<Avion> avionIDao) {
        this.avionIDao = avionIDao;
    }

    public Avion guardarAvion(Avion avion){
        return avionIDao.guardar(avion);
    }
    public  Avion buscarAvion(Integer id){
        return  avionIDao.buscar(id);
    }

    public List<Avion> listarTodos() {
        return avionIDao.listarTodos();
    }



    }


