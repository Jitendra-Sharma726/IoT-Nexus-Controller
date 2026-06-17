package com.example.demo.repository;

import com.example.demo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceReposiotory extends JpaRepository<Device, Long>{
}
