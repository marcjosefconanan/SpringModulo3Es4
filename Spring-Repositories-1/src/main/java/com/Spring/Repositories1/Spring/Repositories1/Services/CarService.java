package com.Spring.Repositories1.Spring.Repositories1.Services;

import com.Spring.Repositories1.Spring.Repositories1.Entities.Car;
import com.Spring.Repositories1.Spring.Repositories1.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public Car addCar (Car car){
        return carRepository.save(car);
        //salva e ritorna car
    }
    public List<Car> getCar (){
        return carRepository.findAll();
        //ritorna tutta la lista "ALL"
    }
    public Optional<Car> getCarId (Long id){
        return carRepository.findById(id);
        //ritorna l'ogetto tramite id
    }
    public Optional<Car> updateCar (Car car, Long id){
        //prendiamo l'oggetto da modificare via id e classe.
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()){
            //se l'oggetto e presente
            carOptional.get().setType(car.getType());
            Car carUpdated = carRepository.save(carOptional.get());
            // oggetto aggiornato
            return Optional.of(carUpdated);
        } else {
            //se non e presente lo facciamo ritornare vuoto.
            return Optional.empty();
        }
    }
    public Optional<Car> deleteCar (Long id){
        //identifichiamo l'oggetto da cancellare via id.
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()){
            carRepository.delete(carOptional.get());
        }else {
            //se non e presente torna un oggetto vuoto
            return Optional.empty();
        }
        //return oggetto eliminato
        return carOptional;
    }
}
