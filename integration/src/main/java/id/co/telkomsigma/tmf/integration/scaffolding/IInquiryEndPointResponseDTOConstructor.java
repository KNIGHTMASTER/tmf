package id.co.telkomsigma.tmf.integration.scaffolding;

import id.co.telkomsigma.tmf.data.dto.request.RequestFindByCode;
import id.co.telkomsigma.tmf.data.dto.request.RequestFindById;
import id.co.telkomsigma.tmf.data.dto.request.RequestFindByName;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/**
 * created on 2/1/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IInquiryEndPointResponseDTOConstructor<DATA> {

    GenericListResponseDTO findAllDTO() throws EndPointException;
    Page<?> findPaginationAllDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;

    /*Property ID*/
    GenericSingleDATAResponseDTO findByIdDTO(RequestFindById p_RequestFindById) throws EndPointException;

    /*Property Code*/
    GenericListResponseDTO findByCodeDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    GenericListResponseDTO findByCodeOrderByIdAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    GenericListResponseDTO findByCodeOrderByCodeAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    GenericListResponseDTO findByCodeOrderByCodeDescDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    Page<?> findPaginationByCodeOrderByCodeAscDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;

    /*Property Name*/
    GenericListResponseDTO findByNameDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    GenericListResponseDTO findByNameOrderByIdAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    GenericListResponseDTO findByNameOrderByNameAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    GenericListResponseDTO findByNameOrderByNameDescDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    Page<?> findPaginationByNameOrderByNameAscDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;
}
