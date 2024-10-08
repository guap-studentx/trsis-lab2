package org.openapitools.service;


import org.openapitools.model.DeviceDTO;
import org.openapitools.model.DeviceDTOFull;
import org.openapitools.repository.DeviceRepository;
import org.openapitools.repository.DeviceEntity;
import java.util.List;

public interface DeviceService {

    boolean         checkExistenceById(int id);

    List<DeviceDTOFull> getAllDevices();
    DeviceDTOFull       createDevice(DeviceDTO dto);

    DeviceDTOFull   getDeviceById(int id);
    boolean         deleteById(int id);

    DeviceDTOFull   putDevice(int id, DeviceDTO dto);
    DeviceDTOFull   patchDevice(int id, DeviceDTO dto);
}
