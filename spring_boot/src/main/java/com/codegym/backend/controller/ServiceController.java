package com.codegym.backend.controller;

import com.codegym.backend.model.Service;
import com.codegym.backend.model.ServiceType;
import com.codegym.backend.service.IServiceService;
import com.codegym.backend.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceTypeService iServiceTypeService;


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

    //lấy danh sách service-type
    @GetMapping("/list/service_type")
    public ResponseEntity<List<ServiceType>> getServiceType() {
        List<ServiceType> serviceTypeList = iServiceTypeService.findAllServiceType();
        if (serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
    }
}
