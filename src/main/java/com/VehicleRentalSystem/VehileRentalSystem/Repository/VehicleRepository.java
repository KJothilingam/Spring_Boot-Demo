package com.VehicleRentalSystem.VehileRentalSystem.Repository;

import com.VehicleRentalSystem.VehileRentalSystem.Model.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // ✅ Find Bikes that need service (`lastServiceAt > 1500`)
    @Query("SELECT v FROM Vehicle v WHERE v.type = 'BIKE' AND v.lastServiceAt > 1500")
    List<Vehicle> findBikesForService();

    // ✅ Find Cars that need service (`lastServiceAt > 3000`)
    @Query("SELECT v FROM Vehicle v WHERE v.type = 'CAR' AND v.lastServiceAt > 3000")
    List<Vehicle> findCarsForService();


    List<Vehicle> findByNameContainingIgnoreCase(String name, Sort sort);

    List<Vehicle> findByNumberPlateContainingIgnoreCase(String numberPlate, Sort sort);

    List<Vehicle> findByAvailableCountGreaterThanEqual(Integer availableCount, Sort sort);


}