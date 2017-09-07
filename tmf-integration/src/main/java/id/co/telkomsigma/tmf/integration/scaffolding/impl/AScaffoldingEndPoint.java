package id.co.telkomsigma.tmf.integration.scaffolding.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.*;
import id.co.telkomsigma.tmf.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tmf.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tmf.data.mapper.IDATAMapper;
import id.co.telkomsigma.tmf.integration.exception.EndPointException;
import id.co.telkomsigma.tmf.integration.scaffolding.IDataBuilderEndPoint;
import id.co.telkomsigma.tmf.integration.scaffolding.IEndPointInitializer;
import id.co.telkomsigma.tmf.integration.scaffolding.IResponseConstructor;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.exception.ServiceException;
import id.co.telkomsigma.tmf.service.scaffolding.IScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * 
 */
public abstract class AScaffoldingEndPoint<DATA> implements IScaffoldingEndPoint<DATA>, IEndPointInitializer {

	protected IScaffoldingService<DATA> scaffoldingService;
	protected IDATAMapper dataMapperIntegration;
	protected Logger LOGGER = LoggerFactory.getLogger(AScaffoldingEndPoint.class);

	@Autowired
	protected IResponseConstructor<DATA> scaffoldingResponseConstructor;

	@Autowired
	protected IDataBuilderEndPoint iDataBuilderEndPoint;

	@Autowired
	protected AuthenticationProvider ethAuthenticationProvider;

	/*===========================INQUIRY ENDPOINT IMPLEMENTATION===========================*/
	/*====================================DATA ENTITY======================================*/
	@Override
	public GenericListResponseDTO findAll(){
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result =  findAllDTO();
			}else {
				result =  scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findAll());
				/*System.out.println("Resutl endpoint size : "+result.getContent().size());
				System.out.println("Rest "+result.toString());*/
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT + e.toString());
		}
		return result;
	}

	@Override
	public Page<?> findPaginationAll(@RequestBody RequestPaginationAllDTO p_RequestPaginationAll) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationAll.getLimit(),
							p_RequestPaginationAll.getOffset(),
							p_RequestPaginationAll.getOrder(),
							p_RequestPaginationAll.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findAll(pr);
			if (dataMapperIntegration != null){
				return findPaginationAllDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public GenericSingleDATAResponseDTO findById(@RequestBody RequestFindById p_RequestFindById){
		GenericSingleDATAResponseDTO responseDTO = new GenericSingleDATAResponseDTO();
		responseDTO.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				responseDTO = findByIdDTO(p_RequestFindById);
			}else{
				return scaffoldingResponseConstructor.constructSingleFindResponse(scaffoldingService.findById(p_RequestFindById.getId()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return responseDTO;
	}

	@Override
	public GenericListResponseDTO findByCode(@RequestBody RequestFindByCode p_RequestFindByCode) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result =  findByCodeDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCode(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByCodeAsc(@RequestBody RequestFindByCode p_RequestFindByCode) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result =  findByCodeOrderByCodeAscDTO(p_RequestFindByCode);
			}else{
				result =  scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeAsc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByCodeDesc(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByCodeOrderByCodeDescDTO(p_RequestFindByCode);
			}else{
				result = scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeDesc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByIdAsc(@RequestBody RequestFindByCode p_RequestFindByCode) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByCodeOrderByIdAscDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByIdAsc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public Page<?> findPaginationByCodeOrderByCodeAsc(@RequestBody RequestPaginationByCodeDTO p_RequestPaginationByCode) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationByCode.getLimit(),
							p_RequestPaginationByCode.getOffset(),
							p_RequestPaginationByCode.getOrder(),
							p_RequestPaginationByCode.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findByCodeOrderByCodeAsc(p_RequestPaginationByCode.getCode(), pr);
			if (dataMapperIntegration != null){
				return findPaginationByCodeOrderByCodeAscDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(e.toString());
			return null;
		}
	}

	@Override
	public GenericListResponseDTO findByName(@RequestBody RequestFindByName p_RequestFindByName) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByNameDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByName(p_RequestFindByName.getName()));
			}
		} catch (EndPointException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameOrderByIdAsc(@RequestBody RequestFindByName p_RequestFindByName) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByNameOrderByIdAscDTO(p_RequestFindByName);
			}else{
				result = scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByIdAsc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameOrderByNameAsc(@RequestBody RequestFindByName p_RequestFindByName) {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByNameOrderByNameAscDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameAsc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameOrderByNameDesc(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			if (dataMapperIntegration != null){
				result = findByNameOrderByNameDescDTO(p_RequestFindByName);
			}else{
				result = scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameDesc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public Page<?> findPaginationByNameOrderByNameAsc(@RequestBody RequestPaginationByNameDTO p_RequestPaginationByName) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationByName.getLimit(),
							p_RequestPaginationByName.getOffset(),
							p_RequestPaginationByName.getOrder(),
							p_RequestPaginationByName.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findByNameOrderByNameAsc(
					p_RequestPaginationByName.getName(),pr

			);
			if (dataMapperIntegration != null){
				return findPaginationByNameOrderByNameAscDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public GenericListResponseDTO selectLOV() throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try{
			result = scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.selectLOV());
		}catch (EndPointException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	/*===========================INQUIRY ENDPOINT IMPLEMENTATION===========================*/
	/*=======================================DTO===========================================*/

	@Override
	public Page<?> findPaginationByNameOrderByNameAscDTO(@RequestBody PageRequest p_PageRequest, @RequestBody Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public GenericListResponseDTO findByNameOrderByNameDescDTO(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByNameDesc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameOrderByNameAscDTO(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByNameAsc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameOrderByIdAscDTO(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByIdAsc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByNameDTO(@RequestBody RequestFindByName p_RequestFindByName) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByName(p_RequestFindByName.getName())));
	}

	@Override
	public Page<?> findPaginationByCodeOrderByCodeAscDTO(@RequestBody PageRequest p_PageRequest, @RequestBody Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByCodeDescDTO(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByIdAsc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByCodeAscDTO(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByCodeDesc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeOrderByIdAscDTO(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result =  scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByCodeAsc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericListResponseDTO findByCodeDTO(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result =  scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCode(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return result;
	}

	@Override
	public GenericSingleDATAResponseDTO findByIdDTO(@RequestBody RequestFindById p_RequestFindById) throws EndPointException {
		GenericSingleDATAResponseDTO responseDTO = new GenericSingleDATAResponseDTO();
		responseDTO.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			responseDTO =  scaffoldingResponseConstructor.constructDTOSingleFindResponse(dataMapperIntegration.convert(scaffoldingService.findById(p_RequestFindById.getId())));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
		}
		return responseDTO;
	}

	@Override
	public Page<?> findPaginationAllDTO(@RequestBody PageRequest p_PageRequest, @RequestBody Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public GenericListResponseDTO findAllDTO() throws EndPointException {
		GenericListResponseDTO result = new GenericListResponseDTO();
		result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
		try {
			result = scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findAll()));
		} catch (ServiceException e) {
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT + e.toString());
		}
		return result;
	}

	/*@Override
	public Response advancedPagination(RequestAdvancedPaginationDTO p_RequestAdvancedPaginationDTO) throws EndPointException {
		try {
			if (p_RequestAdvancedPaginationDTO.getFilterKey() == null || p_RequestAdvancedPaginationDTO.getFilterValue() == null){
				return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findAll(
						iDataBuilderEndPoint.buildPageRequest(
								iDataBuilderEndPoint.buildDTOPagination(
										p_RequestAdvancedPaginationDTO.getLimit(),
										p_RequestAdvancedPaginationDTO.getOffset(),
										p_RequestAdvancedPaginationDTO.getOrder(),
										p_RequestAdvancedPaginationDTO.getSort())
						)
				));
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.advancedPagination(
						p_RequestAdvancedPaginationDTO.getFilterKey(),
						p_RequestAdvancedPaginationDTO.getFilterValue(),
						iDataBuilderEndPoint.buildPageRequest(
								iDataBuilderEndPoint.buildDTOPagination(
										p_RequestAdvancedPaginationDTO.getLimit(),
										p_RequestAdvancedPaginationDTO.getOffset(),
										p_RequestAdvancedPaginationDTO.getOrder(),
										p_RequestAdvancedPaginationDTO.getSort())
						)
				));
			}
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}*/

	/*===========================TRANSACTION ENDPOINT IMPLEMENTATION===========================*/
	@Override
	public ResponseData approveAll() throws EndPointException, ServiceException {
		try {
			scaffoldingService.approveAll();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData approveSingleData(@RequestBody RequestID p_RequestID) throws EndPointException, ServiceException {
		try {
			scaffoldingService.approveSingleData(Long.valueOf(p_RequestID.getId()));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData cancelAll() throws EndPointException, ServiceException {
		try {
			scaffoldingService.cancelAll();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData cancelSingleData(@RequestBody RequestID p_RequestID) throws EndPointException, ServiceException {
		try {
			scaffoldingService.cancelSingleData(Long.valueOf(p_RequestID.getId()));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData updateData(@RequestBody DATA p_DATA) throws EndPointException{
		try {
			scaffoldingService.update(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData insertData(@RequestBody DATA p_DATA) throws EndPointException {
		try {
//			scaffoldingService.setEthAuthenticationDTO(ethAuthenticationProvider.generateAuth());
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData insertAndFlushData(@RequestBody DATA p_DATA) throws EndPointException {
		try {
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData insertCollection(@RequestBody List<DATA> p_DATAs) throws EndPointException {
		try {
			scaffoldingService.insertCollection(p_DATAs);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData delete(@RequestBody String p_ID) throws EndPointException{
		try {
			scaffoldingService.delete(Long.valueOf(p_ID));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | NumberFormatException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData deleteByEntity(@RequestBody String p_Code) throws EndPointException{
		try {
			LOGGER.info("CODE DELETE ENTITY : {}"+p_Code);
			scaffoldingService.deleteByEntity(p_Code);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData deleteCollection(@RequestBody List<String> p_Codes) throws EndPointException{
		try {
			scaffoldingService.deleteCollection(p_Codes);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public ResponseData deleteCollectionById(@RequestBody List<String> p_IDs) throws EndPointException {
		try {
			List<Long> longList = new ArrayList<Long>();
			for (String str : p_IDs) longList.add(Long.valueOf(str));
			scaffoldingService.deleteCollectionById(longList);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(TMFConstant.InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}
}