package id.co.telkomsigma.tmf.integration.scaffolding;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.request.*;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IInquiryEndPoint {

    @ResponseBody
    @GetMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_ALL)
    @ApiOperation(value = "Find All", notes = "Find All Records From Entity", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findAll() throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_ALL_PAGINATION)
    @ApiOperation(value = "Find Pagination All", notes = "Find All Records From Entity with Paginated Response", response = Page.class)
    public Page<?> findPaginationAll(@RequestBody RequestPaginationAllDTO p_RequestPaginationAll) throws EndPointException;

    /*Property ID*/
    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_ID)
    @ApiOperation(value = "Find By Id", notes = "Find All Record From Entity with Filter Id", response = GenericSingleDATAResponseDTO.class)
    public GenericSingleDATAResponseDTO findById(@RequestBody RequestFindById p_RequestFindById) throws EndPointException;

    /*Property Code*/
    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE)
    @ApiOperation(value = "Find By Code", notes = "Find All Record From Entity with Filter Code", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByCode(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_ID_ASC)
    @ApiOperation(value = "Find By Code Order By Id ASC", notes = "Find All Record From Entity with Filter Code and Order Id Ascending", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByCodeOrderByIdAsc(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC)
    @ApiOperation(value = "Find By Code Order By Code ASC", notes = "Find All Record From Entity with Filter Code and Order Code Ascending", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByCodeOrderByCodeAsc(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC)
    @ApiOperation(value = "Find By Code Order By Code DESC", notes = "Find All Record From Entity with Filter Code and Order Code Descending", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByCodeOrderByCodeDesc(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_PAGINATION_BY_CODE)
    @ApiOperation(value = "Find Pagination By Code Order By Code ASC", notes = "Find All Record From Entity with Filter Code and Order Code Ascending and Response Paginated", response = Page.class)
    public Page<?> findPaginationByCodeOrderByCodeAsc(RequestPaginationByCodeDTO p_RequestPaginationByCode) throws EndPointException;

    /*Property Name*/
    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_NAME)
    @ApiOperation(value = "Find By Name", notes = "Find All Record From Entity with Filter Name", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByName(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_NAME_ORDER_BY_ID_ASC)
    @ApiOperation(value = "Find By Name Order By Id ASC", notes = "Find All Record From Entity with Filter Name and Order Id Ascending", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByNameOrderByIdAsc(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC)
    @ApiOperation(value = "Find By Name Order By Name ASC", notes = "Find All Record From Entity with Filter Name and Order Name Ascending", response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByNameOrderByNameAsc(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_NAME_DESC)
    @ApiOperation(value = "Find By Name Order By Name DESC", notes = "Find All Record From Entity with Filter Name and Order Name Descending",  response = GenericListResponseDTO.class)
    public GenericListResponseDTO findByNameOrderByNameDesc(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException;

    @ResponseBody
    @PostMapping(TMFConstant.PathName.PathScaffolding.PATH_FIND_PAGINATION_BY_NAME)
    @ApiOperation(value = "Find Pagination By Name Order By Name ASC", notes = "Find All Record From Entity with Filter Name and Order Name Ascending and Response Paginated",  response = GenericListResponseDTO.class)
    public Page<?> findPaginationByNameOrderByNameAsc(@RequestBody RequestPaginationByNameDTO p_RequestPaginationByName) throws EndPointException;

    @ResponseBody
    @GetMapping(TMFConstant.PathName.PathScaffolding.PATH_SELECT_LOV)
    @ApiOperation(value = "Select List Of Value", notes = "Find All Record From Entity Response as List Of Value",  response = GenericListResponseDTO.class)
    public GenericListResponseDTO selectLOV() throws EndPointException;
    
    /*@POST
    @Path(PathNameConstant.PathScaffolding.PATH_ADVANCED_PAGINATION)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response advancedPagination(RequestAdvancedPaginationDTO p_RequestAdvancedPaginationDTO) throws EndPointException;*/
}
