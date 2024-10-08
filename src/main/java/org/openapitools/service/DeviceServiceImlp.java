package org.openapitools.service;

import org.openapitools.model.DeviceDTO;
import org.openapitools.model.DeviceDTOFull;
import org.openapitools.repository.DeviceEntity;
import org.openapitools.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DeviceServiceImlp implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    private DeviceDTOFull Entity_To_DTOFull(DeviceEntity entity) {
        DeviceDTOFull dtofull = new DeviceDTOFull();
        dtofull.setId(entity.getId());
        dtofull.setName(entity.getName());
        dtofull.setType(entity.getType());
        dtofull.setIpAddress(entity.getIp_address());
        dtofull.setLocation(entity.getLocation());
        return dtofull;
    }

    private DeviceDTO Entity_To_DTO(DeviceEntity entity){
        DeviceDTO dto = new DeviceDTO();
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setIpAddress(entity.getIp_address());
        dto.setLocation(entity.getLocation());
        return dto;
    }


    @Override
    public boolean checkExistenceById(int id) {
        return deviceRepository.existsById(id);
    }

    @Override
    public List<DeviceDTOFull> getAllDevices() {
        List<DeviceEntity> entities = (List<DeviceEntity>) deviceRepository.findAll();
        List<DeviceDTOFull> dtos = new ArrayList<>();
        for (DeviceEntity entity : entities) {
            dtos.add(Entity_To_DTOFull(entity));
        }
        return dtos;
    }

    @Override
    public DeviceDTOFull createDevice(DeviceDTO dto) {

        try {
            if (   dto.getName().isEmpty()
                    || dto.getType().isEmpty()
                    || dto.getIpAddress().isEmpty()
                    || dto.getLocation().isEmpty() ) {
                return null;
            }
        } catch (Exception e){
            return null;
        }

        DeviceEntity entity = new DeviceEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setIp_address(dto.getIpAddress());
        entity.setLocation(dto.getLocation());

        deviceRepository.save(entity);
        return Entity_To_DTOFull(entity);
    }

    @Override
    public DeviceDTOFull getDeviceById(int id) {
        Optional<DeviceEntity> deviceEntity = deviceRepository.findById(id);
        if (deviceEntity.isPresent()){
            return Entity_To_DTOFull(deviceEntity.get());
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        if (!checkExistenceById(id)){
            return false;
        }
        deviceRepository.deleteById(id);
        return true;
    }

    @Override
    public DeviceDTOFull putDevice(int id, DeviceDTO dto) {

        try {
            if (   dto.getName().isEmpty()
                    || dto.getType().isEmpty()
                    || dto.getIpAddress().isEmpty()
                    || dto.getLocation().isEmpty() ) {
                return null;
            }
        } catch (Exception e){
            return null;
        }

        DeviceEntity entity = new DeviceEntity();
        entity.setId(id);
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setIp_address(dto.getIpAddress());
        entity.setLocation(dto.getLocation());

        deviceRepository.save(entity);

        return Entity_To_DTOFull(entity);
    }

    @Override
    public DeviceDTOFull patchDevice(int id, DeviceDTO dto) {

        DeviceEntity entity = deviceRepository.findById(id).get();
        
        try {
            entity.setId(id);
        } catch (Exception e){};

        try {
            entity.setName(dto.getName());
        } catch (Exception e){};

        try {
            entity.setType(dto.getType());
        } catch (Exception e){};

        try {
            entity.setIp_address(dto.getIpAddress());
        } catch (Exception e){};

        try {
            entity.setLocation(dto.getLocation());
        } catch (Exception e){};

        deviceRepository.save(entity);

        return Entity_To_DTOFull(entity);
    }
}
