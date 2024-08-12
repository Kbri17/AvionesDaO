package service;

import dao.IDao;
import model.Veterinario;

import java.util.List;

public class AvionService {
    private IDao<Veterinario> veterinarioIDao;

    public AvionService(IDao<Veterinario> veterinarioIDao) {
        this.veterinarioIDao = veterinarioIDao;
    }

    public Veterinario guardarVeterinario(Veterinario veterinario){
        return veterinarioIDao.guardar(veterinario);
    }
    public List<Veterinario> listarTodos() {
        return veterinarioIDao.listarTodos();
    }


    }


