package com.example.mngkw_springboot.services;


import com.example.mngkw_springboot.entity.Camps;
import com.example.mngkw_springboot.exception.CampsNotFoundException;
import com.example.mngkw_springboot.repository.CampsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampsService {

    private final CampsRepository campsRepository;

    public CampsService(CampsRepository campsRepository) {
        this.campsRepository = campsRepository;
    }

    public List<Camps> findAllCamps(){
        return campsRepository.findAll();
    }

    public Camps findCampsById(String id){
        return campsRepository.findById(id)
                .orElseThrow(() -> new CampsNotFoundException("Nie znaleziono grupy o danym id:" + id));
    }

    public Camps addCamps(Camps camps){
        return campsRepository.save(camps);
    }

    public Camps updateCamps(Camps camps){
        return campsRepository.save(camps);
    }

    public void deleteCampsById(String id){ campsRepository.deleteById(id); }


}
