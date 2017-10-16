package id.co.telkomsigma.tmf.service.crud;

import id.co.telkomsigma.tmf.dao.crud.ICrudDAO;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.ACrudDATA;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IServiceInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Service(TMFConstant.BeanName.CRUD_SERVICE_BEAN)
public abstract class ACrudService<DATA extends ACrudDATA> implements ICrudService<DATA, Long>, IServiceInitializer {

    private static Logger LOGGER = LoggerFactory.getLogger(ACrudService.class);

    protected ICrudDAO<DATA> scaffoldingDAO;

    /*Inquiry*/
    /*======================================================================================================*/
    @Override
    public List<DATA> findAll() throws ServiceException {
        return scaffoldingDAO.findAll();
    }
        

    @Override
    public Page<DATA> findAll(Pageable p_Pageable) {
        return scaffoldingDAO.findAll(p_Pageable);
    }


    @Override
    public DATA findById(Long p_ID) throws ServiceException {
        return scaffoldingDAO.findOne(p_ID);
    }

    /*Transaction*/
    /*======================================================================================================*/
    @Override
    public void insert(DATA p_DATA) throws ServiceException {
        try {
            scaffoldingDAO.save(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error insert ".concat(e.toString()));
        }
    }

    @Override
    public void flush() throws ServiceException {
        scaffoldingDAO.flush();
    }

    @Override
    public void insertAndFlush(DATA p_DATA) throws ServiceException {
        try {
            scaffoldingDAO.saveAndFlush(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error insert and flush ".concat(e.toString()));
        }
    }

    @Override
    public void insertCollection(List<DATA> p_DATA) throws ServiceException {
        try {
            scaffoldingDAO.save(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error insert collection ".concat(e.toString()));
        }
    }

    @Override
    public void update(DATA p_DATA) throws ServiceException {
        try {
            scaffoldingDAO.save(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error update ".concat(e.toString()));
        }
    }

    @Override
    public void delete(Long p_ID) throws ServiceException {
        try {
            scaffoldingDAO.delete(p_ID);
        } catch (Exception e) {
            throw new ServiceException("Error delete ".concat(e.toString()));
        }
    }

    @Override
    public void deleteByEntity(String p_Code) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteCollection(List<String> p_Codes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteCollectionById(List<Long> p_ID) {
        if (p_ID.size() > 0) {
            for (Long id : p_ID) {
                scaffoldingDAO.delete(id);
            }
        } else {
            LOGGER.error("ID size <= 0");
        }
    }

}