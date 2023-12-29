package com.codegym.backend.controller;

import com.codegym.backend.dto.*;
import com.codegym.backend.model.*;
import com.codegym.backend.service.*;
import com.codegym.backend.validation.ServiceCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/private")
public class ServiceController {
    @Autowired
    IServiceService iServiceService;
    @Autowired
    IMaterialService iMaterialService;
    @Autowired
    IServiceTypeService iServiceTypeService;
    @Autowired
    ITableService iTableService;
    @Autowired
    IBillDetailService iBillDetailService;
    @Autowired
    IBillService iBillService;
    @Autowired
    IMessageService iMessageService;
    @Autowired
    IMessageService iMessgaeServie;
    @Autowired
    ServiceCreateValidator serviceCreateValidator;
    @Autowired
    IRecipeService iRecipeService;

    @GetMapping("/list/service")
    public ResponseEntity<Page<Service>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Service> serviceList = iServiceService.findAllService(pageable);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @GetMapping("/list/listService")
    public ResponseEntity<Page<IServiceDto>> getListWithCondition(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "8") int size,
                                                                  @RequestParam(defaultValue = "") String serviceName,
                                                                  @RequestParam(defaultValue = "") String serviceType,
                                                                  @RequestParam(defaultValue = "1900-01-01 00:00") String createdDateF,
                                                                  @RequestParam(defaultValue = "2100-01-01 23:59") String createdDateT,
                                                                  @RequestParam(defaultValue = "0.0") String priceF,
                                                                  @RequestParam(defaultValue = "10000000000.0") String priceT,
                                                                  @RequestParam(defaultValue = "0.0") String quantityF,
                                                                  @RequestParam(defaultValue = "10000000000.0") String quantityT,
                                                                  @RequestParam(defaultValue = "") String enableFlag,
                                                                  @RequestParam(defaultValue = "0.0") String paymentF,
                                                                  @RequestParam(defaultValue = "10000000000.0") String paymentT,
                                                                  @RequestParam(defaultValue = "1900-01-01 00:00") String paymentTimeF,
                                                                  @RequestParam(defaultValue = "2100-01-01 23:59") String paymentTimeT) {

        Pageable pageable = PageRequest.of(page, size);
        Page<IServiceDto> serviceList = iServiceService.findService(
                pageable,
                serviceName,
                serviceType,
                createdDateF,
                createdDateT,
                priceF,
                priceT,
                paymentTimeF,
                paymentTimeT,
                quantityF,
                quantityT,
                enableFlag,
                paymentF,
                paymentT);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @PostMapping(value = "list/createService")
    public ResponseEntity<?> createService(@Valid @RequestBody CServiceDto serviceDto, BindingResult
            bindingResult) throws MessagingException {

//        serviceCreateValidator.validate(serviceDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
//        }
        iServiceService.createService(serviceDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "list/updateService")
    public ResponseEntity<?> updateService(@Valid @RequestBody CServiceDto serviceDto, BindingResult
            bindingResult) throws MessagingException {

//        serviceCreateValidator.validate(serviceDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
//        }
        iServiceService.updateService(serviceDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "list/createRecipe")
    public ResponseEntity<?> createRecipe(@Valid @RequestBody List<RecipeDto> ListRecipeDto, BindingResult
            bindingResult) throws MessagingException {
        for (RecipeDto recipeDto : ListRecipeDto) {
            Long serviceId = iRecipeService.findLastServiceId();
            iRecipeService.insertRecipe(serviceId, recipeDto.getMaterialId(), recipeDto.getQuantity(), recipeDto.getPrice());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("list/deleteRecipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable long id) {
        List<IRecipeDto> iRecipeDto = iServiceService.findRecipeByServiceId(id);
        for (IRecipeDto recipe : iRecipeDto) {
            iRecipeService.deleteRecipe(recipe.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "list/updateRecipe")
    public ResponseEntity<?> updateRecipe(@Valid @RequestBody List<CRecipeDto> ListRecipeDto, BindingResult
            bindingResult) throws MessagingException {
        if (!ListRecipeDto.isEmpty()) {
            Long serviceId = ListRecipeDto.get(0).getServiceId();
            List<IRecipeDto> originRecipes = iServiceService.findRecipeByServiceId(serviceId);
            for (IRecipeDto recipe : originRecipes) {
                boolean deleteFlag = true;
                for (CRecipeDto recipeDto : ListRecipeDto) {
                    if (Objects.equals(recipe.getMaterialId(), recipeDto.getMaterialId())) {
                        deleteFlag = false;
                        break;
                    }
                }
                if (deleteFlag) {
                    iRecipeService.deleteRecipe(recipe.getId());
                }
            }

            for (CRecipeDto recipeDto : ListRecipeDto) {
                if (recipeDto.getId() == null) {
                    iRecipeService.insertRecipe(recipeDto.getServiceId(), recipeDto.getMaterialId(), recipeDto.getQuantity(), recipeDto.getPrice());
                } else {
                    iRecipeService.updateRecipe(recipeDto.getQuantity(), recipeDto.getPrice(), recipeDto.getId());
                }
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/list/serviceList/changeServiceEnableFlag")
    public ResponseEntity<?> changeFlag(@RequestParam(defaultValue = "9999") int id, @RequestParam(defaultValue = "true") boolean flag) {
        iServiceService.updateEnableFlag(flag ? 1 : 0, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/recipe/{id}")
    public ResponseEntity<List<IRecipeDto>> findRecipe(@PathVariable Long id) {
        List<IRecipeDto> iRecipeDto = iServiceService.findRecipeByServiceId(id);
        if (iRecipeDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iRecipeDto, HttpStatus.OK);
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<Service> findService(@PathVariable int id) {
        Service service = iServiceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/type_id")
    public ResponseEntity<Page<Service>> getByTypeId(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size, @RequestParam int id) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Service> serviceList = iServiceService.findByServiceTypeId(id, pageable);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @GetMapping("/list/table")
    public ResponseEntity<List<CoffeeTable>> getListTable() {
        List<CoffeeTable> tableList = iTableService.findAllTable();
        if (tableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableList, HttpStatus.OK);
    }

    @GetMapping("/list/billdetail/table_id/{id}")
    public ResponseEntity<List<BillDetailListDTO>> getAllBillDetail(@PathVariable int id) {
        List<BillDetailListDTO> billDetailList = iBillDetailService.findByBillId(id);
        if (billDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billDetailList, HttpStatus.OK);
    }

    @GetMapping("/bill/table_id/{id}")
    public ResponseEntity<BillDto> getBill(@PathVariable int id) {
        BillDto bill = iBillService.findByIdBill(id);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @GetMapping("/list/service_type")
    public ResponseEntity<List<ServiceType>> getServiceType() {
        List<ServiceType> serviceTypeList = iServiceTypeService.findAllServiceType();
        if (serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
    }

    @PostMapping("/insert_bill")
    public ResponseEntity<?> insertBill(@Valid @RequestBody BillInsertDTO billInsertDTO) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        iBillService.insertBill(dtf.format(date), billInsertDTO.getPayment_status(), billInsertDTO.getPayment_time(),
                billInsertDTO.getTable_id(), billInsertDTO.getUser_id());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/insert_bill_detail")
    public ResponseEntity<?> insertBillDetail(@Valid @RequestBody InsertBillDetailDTO billDetailDTO) {
        iBillDetailService.insertBillDetail(billDetailDTO.getQuantity(), billDetailDTO.getBill_id(), billDetailDTO.getService_id());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/message")
    public ResponseEntity<List<Message>> getMessage() {
        List<Message> message = iMessageService.findMessage();
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete_message/{id}")
    public Map<String, Boolean> deleteMessage(@PathVariable Integer id) {
        Message message = iMessageService.findById(id);
        iMessageService.deleteMessage(message);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/service/material")
    public ResponseEntity<List<IMaterialDto>> getListMaterial() {
        List<IMaterialDto> materials = iMaterialService.findAllMaterial();
        if (materials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(materials, HttpStatus.OK);
    }
}
