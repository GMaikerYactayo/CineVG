package dao;

import java.util.List;

public interface ICRUD<Generico> {

    void registrar(Generico gen) throws Exception;

    void modificar(Generico gen) throws Exception;

    void eliminar(Generico gen) throws Exception;

    List<Generico> listar() throws Exception;
    
    Generico filtrar(Generico gen) throws Exception;
}
