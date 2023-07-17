package com.codegym.backend.repository;

import com.codegym.backend.common.MyQuerySQL;
import com.codegym.backend.dto.CServiceDto;
import com.codegym.backend.dto.ServiceDto;
import com.codegym.backend.dto.IServiceDto;
import com.codegym.backend.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select * from service where enable_flag = 1",nativeQuery = true)
    Page<Service> findAllService(Pageable pageable);

    @Query(value = "select * from service where enable_flag = 1 and type_id = ?1",nativeQuery = true)
    Page<Service> findByServiceTypeId(int typeId,Pageable pageable);

    @Query(value = "select * from service where id = ?1 and enable_flag = 1",nativeQuery = true)
    Service findById(int id);

    @Query(value = "select * from service where enable_flag = 1",nativeQuery = true)
    List<Service> findAll();
    String sql_best = "SELECT s.id, s.name, s.img_url imgUrl, sum(bd.quantity) quantity\n" +
            "FROM service s\n" +
            "JOIN bill_detail bd ON s.id = bd.service_id \n" +
            "WHERE enable_flag = 1\n" +
            "GROUP BY s.id\n" +
            "ORDER BY quantity DESC\n" +
            "LIMIT 5;";
    @Query(value = sql_best, nativeQuery = true)
    List<ServiceDto> findBestSeller();

    String sql_new = "SELECT id, name, img_url imgUrl, created_date FROM service where enable_flag = 1 ORDER BY created_date DESC LIMIT 5";
    @Query(value = sql_new, nativeQuery = true)
    List<ServiceDto> findNewService();

    @Modifying
    @Query(value = MyQuerySQL.UPDATE_SERVICE_ENABLE_FLAG, nativeQuery = true)
    void updateServiceEnableFlag(int flag, int id);

    @Query(value = MyQuerySQL.SELECT_SERVICE, countQuery = MyQuerySQL.SELECT_SERVICE,  nativeQuery = true)
    Page<IServiceDto> getServiceList(Pageable pageable,
                                     String serviceName,
                                     String serviceType,
                                     String createdDateF,
                                     String createdDateT,
                                     String priceF,
                                     String priceT,
                                     String quantityF,
                                     String quantityT,
                                     String enableFlag,
                                     String paymentF,
                                     String paymentT,
                                     String paymentTimeF,
                                     String paymentTimeT
                                     );
    @Query(value = MyQuerySQL.SELECT_SERVICE_NO_JOIN,  nativeQuery = true)
    List<CServiceDto> getServiceListForRegister();
}
