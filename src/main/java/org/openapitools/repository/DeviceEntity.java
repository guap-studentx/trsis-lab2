package org.openapitools.repository;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id; // Primary Key
    private String name;
    private String type;
    private String ip_address;
    private String location;

    public DeviceEntity(int id, String name, String type, String ip_address, String location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ip_address = ip_address;
        this.location = location;
    }

    public DeviceEntity() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getIp_address() {
        return ip_address;
    }

    public String getLocation() {
        return location;
    }
}
