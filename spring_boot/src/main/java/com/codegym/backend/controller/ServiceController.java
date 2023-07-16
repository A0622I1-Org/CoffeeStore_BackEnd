package com.codegym.backend.controller;

import com.codegym.backend.dto.*;
import com.codegym.backend.model.CoffeeTable;
import com.codegym.backend.model.Message;
import com.codegym.backend.model.Service;
import com.codegym.backend.model.ServiceType;
import com.codegym.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/private")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

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

    //    lấy danh sách service
    @GetMapping("/list/service")
    public ResponseEntity<Page<Service>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Service> serviceList = serviceService.findAllService(pageable);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @GetMapping("/list/listService")
    public ResponseEntity<Page<ServiceDto1>> getListWithCondition(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "8") int size,
                                                                  @RequestParam(defaultValue = "") String serviceName,
                                                                  @RequestParam(defaultValue = "") String serviceType,
                                                                  @RequestParam(defaultValue = "1900-01-01") String createdDateF,
                                                                  @RequestParam(defaultValue = "2100-01-01") String createdDateT,
                                                                  @RequestParam(defaultValue = "0.0") String priceF,
                                                                  @RequestParam(defaultValue = "10000000000.0") String priceT,
                                                                  @RequestParam(defaultValue = "0.0") String quantityF,
                                                                  @RequestParam(defaultValue = "10000000000.0") String quantityT,
                                                                  @RequestParam(defaultValue = "") String enableFlag) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ServiceDto1> serviceList = serviceService.findService(
                                                                    pageable,
                                                                    serviceName,
                                                                    serviceType,
                                                                    createdDateF,
                                                                    createdDateT,
                                                                    priceF,
                                                                    priceT,
                                                                    quantityF,
                                                                    quantityT,
                                                                    enableFlag);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    @PutMapping("/list/serviceList/changeServiceEnableFlag")
    public ResponseEntity<?> changeFlag(@RequestParam int id,@RequestParam boolean flag) {
       serviceService.updateEnableFlag(flag ? 1 : 0, id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    // lấy dữ liệu 1 service
    @GetMapping("/service/{id}")
    public ResponseEntity<Service> findService(@PathVariable int id) {
        Service service = serviceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }


    // tìm kiếm danh sách service theo service_type_id
    @GetMapping("/type_id")
    public ResponseEntity<Page<Service>> getByTypeId(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size, @RequestParam int id) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Service> serviceList = serviceService.findByServiceTypeId(id, pageable);
        if (serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }

    //lấy danh sách table chưa có người ngồi
    @GetMapping("/list/table")
    public ResponseEntity<List<CoffeeTable>> getListTable() {
        List<CoffeeTable> tableList = iTableService.findAllTable();
        if (tableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tableList, HttpStatus.OK);
    }

    // lấy danh sách billdetail theo table_id và payment_status = 0
    @GetMapping("/list/billdetail/table_id/{id}")
    public ResponseEntity<List<BillDetailListDTO>> getAllBillDetail(@PathVariable int id) {
        List<BillDetailListDTO> billDetailList = iBillDetailService.findByBillId(id);
        if (billDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billDetailList, HttpStatus.OK);
    }

    /**
     * Lấy bill theo table_id và payment_status = 0;
     */

    //Lấy bill theo table_id và payment_status = 0;
    @GetMapping("/bill/table_id/{id}")
    public ResponseEntity<BillDto> getBill(@PathVariable int id) {
        BillDto bill = iBillService.findByIdBill(id);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    //   Lấy dữ liệu bảng service_type
    @GetMapping("/list/service_type")
    public ResponseEntity<List<ServiceType>> getServiceType() {
        List<ServiceType> serviceTypeList = iServiceTypeService.findAllServiceType();
        if (serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
    }

    // thêm dữ liệu bill mới
    @PostMapping("/insert_bill")
    public ResponseEntity<?> insertBill(@Valid @RequestBody BillInsertDTO billInsertDTO) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        iBillService.insertBill(dtf.format(date), billInsertDTO.getPayment_status(), billInsertDTO.getPayment_time(),
                billInsertDTO.getTable_id(), billInsertDTO.getUser_id());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //thêm dữ liệu billdetail mới
    @PostMapping("/insert_bill_detail")
    public ResponseEntity<?> insertBillDetail(@Valid @RequestBody InsertBillDetailDTO billDetailDTO) {
        iBillDetailService.insertBillDetail(billDetailDTO.getQuantity(), billDetailDTO.getBill_id(), billDetailDTO.getService_id());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //    Lấy thông báo
    @GetMapping("/message")
    public ResponseEntity<List<Message>> getMessage() {
        List<Message> message = iMessageService.findMessage();
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //    xóa thông báo
    @DeleteMapping("/delete_message/{id}")
    public Map<String, Boolean> deleteMessage(@PathVariable Integer id) {
        Message message = iMessageService.findById(id);
        iMessageService.deleteMessage(message);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
