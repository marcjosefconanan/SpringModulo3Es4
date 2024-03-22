package com.Spring.Repositories1.Spring.Repositories1.Controllers;

import com.Spring.Repositories1.Spring.Repositories1.Entities.Car;
import com.Spring.Repositories1.Spring.Repositories1.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar (@RequestBody Car car){
        return ResponseEntity.ok().body(carService.addCar(car));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Car>> getAllCars (){
        return ResponseEntity.ok().body(carService.getCar());
    }
    @GetMapping("/getcarid/{id}")
    public ResponseEntity<Car> getCarId (@PathVariable Long id){
        Optional<Car> carOptional = carService.getCarId(id);
        if (carOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar (@PathVariable Long id,@RequestBody Car car){
        Optional<Car> carOptional = carService.updateCar(car,id);
        if (carOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCar (@PathVariable Long id){
        Optional<Car> carOptional = carService.deleteCar(id);
        if (carOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }
}
