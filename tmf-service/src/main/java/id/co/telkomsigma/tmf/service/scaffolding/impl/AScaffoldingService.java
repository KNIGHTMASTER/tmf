package id.co.telkomsigma.tmf.service.scaffolding.impl;

import id.co.telkomsigma.tmf.dao.exception.DAOException;
import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.constant.TMFConstant.Common.Punctuation;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;
import id.co.telkomsigma.tmf.service.scaffolding.IServiceInitializer;
import id.co.telkomsigma.tmf.util.common.random.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Service(TMFConstant.BeanName.SCAFFOLDING_SERVICE_BEAN)
public abstract class AScaffoldingService<DATA extends AAuditTrail> implements IScaffoldingService<DATA>, IServiceInitializer {

    private static Logger LOGGER = LoggerFactory.getLogger(AScaffoldingService.class);

    protected IScaffoldingDAO<DATA> scaffoldingDAO;

    /*Inquiry*/
    /*======================================================================================================*/
    @Override
    public List<DATA> findAll() throws ServiceException {
        try {
            return scaffoldingDAO.findByStatus(TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }
        

    @Override
    public Page<DATA> findAll(Pageable p_Pageable) {
        return scaffoldingDAO.findAll(p_Pageable);
    }

    @Override
    public DATA findById(Long p_ID) throws ServiceException {
        return scaffoldingDAO.findOne(p_ID);
    }

    @Override
    public List<DATA> findByCode(String p_Code) throws ServiceException {
        try {
            return scaffoldingDAO.findByCodeContainingAndStatus(p_Code, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByCodeOrderByIdAsc(String p_Code) throws ServiceException {
        try {
            return scaffoldingDAO.findByCodeContainingAndStatusOrderByIdAsc(p_Code, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByCodeOrderByCodeAsc(String p_Code) throws ServiceException {
        try {
            return scaffoldingDAO.findByCodeContainingAndStatusOrderByCodeAsc(p_Code, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByCodeOrderByCodeDesc(String p_Code) throws ServiceException {
        try {
            return scaffoldingDAO.findByCodeContainingAndStatusOrderByCodeDesc(p_Code, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Page<DATA> findByCodeOrderByCodeAsc(String p_Code, Pageable p_Pageable) throws ServiceException {
        try {
            return scaffoldingDAO.findByCodeContainingAndStatusOrderByCodeAsc(p_Code, TMFConstant.Common.GeneralValue.ONE, p_Pageable);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByName(String p_Name) {
        try {
            return scaffoldingDAO.findByNameContainingAndStatus(p_Name, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByNameOrderByIdAsc(String p_Name) {
        try {
            return scaffoldingDAO.findByNameContainingAndStatusOrderByIdAsc(p_Name, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByNameOrderByNameAsc(String p_Name) throws ServiceException {
        try {
            return scaffoldingDAO.findByNameContainingAndStatusOrderByNameAsc(p_Name, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> findByNameOrderByNameDesc(String p_Name) throws ServiceException {
        try {
            return scaffoldingDAO.findByNameContainingAndStatusOrderByNameDesc(p_Name, TMFConstant.Common.GeneralValue.ONE);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Page<DATA> findByNameOrderByNameAsc(String p_Name, Pageable p_Pageable) throws ServiceException {
        try {
            return scaffoldingDAO.findByNameContainingAndStatusOrderByNameAsc(p_Name, TMFConstant.Common.GeneralValue.ONE, p_Pageable);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DATA> selectLOV() {
        try {
            return scaffoldingDAO.selectLOV();
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<String> getPhysicalColumnNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /*@Override
     public Page<DATA> advancedPagination(String p_FilterKey, String p_FilterValue, Pageable p_Pageable) throws ServiceException {
     try {
     return  scaffoldingDAO.advancedPagination(p_FilterKey, p_FilterValue, p_Pageable);
     } catch (DAOException e) {
     LOGGER.error(e.getMessage());
     return null;
     }
     }*/

    /*Transaction*/
    /*======================================================================================================*/
    @Override
    public void insert(DATA p_DATA) throws ServiceException {
        if (p_DATA.getCode() == null || p_DATA.getCode().equals(Punctuation.EMPTY)) {
            p_DATA.setCode(generateRandomCode());
        }
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
        if (p_DATA.getCode() == null || p_DATA.getCode().equals(Punctuation.EMPTY)) {
            p_DATA.setCode(generateRandomCode());
        }
        try {
            scaffoldingDAO.saveAndFlush(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error insert and flush ".concat(e.toString()));
        }
    }

    @Override
    public void insertCollection(List<DATA> p_DATA) throws ServiceException {
        for (DATA data : p_DATA) {
            if (data.getCode() == null || data.getCode().equals(Punctuation.EMPTY)) {
                data.setCode(generateRandomCode());
            }
        }
        try {
            scaffoldingDAO.save(p_DATA);
        } catch (Exception e) {
            throw new ServiceException("Error insert collection ".concat(e.toString()));
        }
    }

    @Override
    public void update(DATA p_DATA) throws ServiceException {
        p_DATA.setStatus(TMFConstant.Common.GeneralValue.ONE);
        if (p_DATA.getCode() == null) {
            p_DATA.setCode(generateRandomCode());
        }
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
        if (p_Code != null) {
            DATA data = null;
            try {
                data = scaffoldingDAO.findByCodeContainingAndStatus(p_Code, TMFConstant.Common.GeneralValue.ONE).get(0);
            } catch (DAOException e) {
                LOGGER.error("Data is not found {} " + e.getMessage());
            }
            if (data != null) {
                scaffoldingDAO.delete(data);
            } else {
                LOGGER.error("DATA is empty");
            }
        } else {
            LOGGER.error("Code is empty");
        }
    }

    @Override
    public void deleteCollection(List<String> p_Codes) {
        List<DATA> datas = new ArrayList<DATA>();
        for (String p_Code : p_Codes) {
            if (p_Code != null) {
                try {
                    datas.add(scaffoldingDAO.findByCodeContainingAndStatus(p_Code, TMFConstant.Common.GeneralValue.ONE).get(0));
                } catch (DAOException e) {
                    LOGGER.error(e.getMessage());
                }
            } else {
                LOGGER.error("Code is empty");
            }
        }
        if (datas.size() > 0) {
            scaffoldingDAO.delete(datas);
        } else {
            LOGGER.error("List of data is empty");
        }
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

    @Override
    public void approveAll() {
        try {
            scaffoldingDAO.approveAll();
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void approveSingleData(Long p_ID) {
        try {
            scaffoldingDAO.approveSingleData(p_ID);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void cancelAll() {
        try {
            scaffoldingDAO.cancelAll();
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void cancelSingleData(Long p_ID) {
        try {
            scaffoldingDAO.cancelSingleData(p_ID);
        } catch (DAOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String generateRandomCode() {
        String result = Punctuation.EMPTY;
        DATA randomData = null;
        do {
            try {
                result = RandomStringGenerator.generate(6, RandomStringGenerator.Mode.ALPHANUMERIC).toUpperCase();
                List<DATA> dataList = findByCode(result);
                if (dataList.size() > 0) {
                    randomData = dataList.get(0);
                }
            } catch (Exception e) {
                LOGGER.info("Code Finder NULL");
            }
        } while (result.equals("") || randomData != null);
        return result;
    }

}