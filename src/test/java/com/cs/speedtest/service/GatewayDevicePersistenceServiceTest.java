/*
package com.cs.speedtest.service;

import com.cs.speedtest.entities.GatewayDevice;
import com.cs.speedtest.repository.GatewayDeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GatewayDevicePersistenceServiceTest {

    @InjectMocks
    private GatewayDevicePersistenceService GatewayDevicePersistenceService;


    @Mock
    private GatewayDeviceRepository gatewayDeviceRepository;

    @Test
    public void findByIdTest(){
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        gatewayDevice1.setPon("Test1");
        when(gatewayDeviceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayDevice1));
        GatewayDevice expected = GatewayDevicePersistenceService.findById("Guid1234");
        assertNotNull(gatewayDevice1);
        assertEquals(expected, gatewayDevice1);
    }

    @Test
    public void findAllTest(){

        List<GatewayDevice> gatewayDeviceList =  new ArrayList<>();

        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        gatewayDevice1.setPon("Test1");
        gatewayDeviceList.add(gatewayDevice1);

        GatewayDevice GatewayDevice2 = new GatewayDevice();
        GatewayDevice2.setGuid("Guid1234");
        GatewayDevice2.setSerialNumber("Test1");
        GatewayDevice2.setPon("Test2");
        gatewayDeviceList.add(GatewayDevice2);
        when(gatewayDeviceRepository.findAll()).thenReturn(gatewayDeviceList);

        List<GatewayDevice> expected = GatewayDevicePersistenceService.findAll();
        assertEquals(expected, gatewayDeviceList);
        assertNotNull(gatewayDevice1);
        verify(gatewayDeviceRepository).findAll();

    }

    @Test
    public void countAllTest(){

        List<GatewayDevice> gatewayDevices =  new ArrayList<>();

        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        gatewayDevices.add(gatewayDevice1);

        GatewayDevice gatewayDevice2 = new GatewayDevice();
        gatewayDevice2.setGuid("Guid1234");
        gatewayDevice2.setSerialNumber("Test1");
        gatewayDevices.add(gatewayDevice2);
        long size = gatewayDevices.size();
        when(gatewayDeviceRepository.count()).thenReturn(size);

        long expected = GatewayDevicePersistenceService.countAll();
        assertEquals(expected, size);
        verify(gatewayDeviceRepository).count();

    }
//
    @Test
    public void saveTest()
    {
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");

        when(gatewayDeviceRepository.save(ArgumentMatchers.any(GatewayDevice.class))).thenReturn(gatewayDevice1);
        GatewayDevice created = GatewayDevicePersistenceService.save(gatewayDevice1);
        assertThat(created.getGuid()).isSameAs(gatewayDevice1.getGuid());
        verify(gatewayDeviceRepository).save(gatewayDevice1);
    }

    @Test
    public void UpdateTest()
    {
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");

        GatewayDevice newGatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("new Test1");
        when(gatewayDeviceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayDevice1));
        when(gatewayDeviceRepository.save(ArgumentMatchers.any(GatewayDevice.class))).thenReturn(gatewayDevice1);
        boolean isExpected = GatewayDevicePersistenceService.update(gatewayDevice1);
        assertEquals(isExpected, true);

    }



    @Test
    public void createTest()
    {
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");

        when(gatewayDeviceRepository.save(ArgumentMatchers.any(GatewayDevice.class))).thenReturn(gatewayDevice1);
        GatewayDevice created = GatewayDevicePersistenceService.save(gatewayDevice1);
        assertThat(created.getGuid()).isSameAs(gatewayDevice1.getGuid());
        verify(gatewayDeviceRepository).save(gatewayDevice1);
    }

    @Test
    public void deleteByIdTest()
    {
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        gatewayDevice1.setPon("TestDescription1");

        when(gatewayDeviceRepository.findById(gatewayDevice1.getGuid())).thenReturn(Optional.of(gatewayDevice1));
        GatewayDevicePersistenceService.delete(gatewayDevice1);
        verify(gatewayDeviceRepository).delete(gatewayDevice1);
    }

    @Test
    public void deleteTest()
    {
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        gatewayDevice1.setPon("TestDescription1");

        when(gatewayDeviceRepository.findById(gatewayDevice1.getGuid())).thenReturn(Optional.of(gatewayDevice1));
        GatewayDevicePersistenceService.delete(gatewayDevice1);
        verify(gatewayDeviceRepository).delete(gatewayDevice1);
    }

    @Test
    public void existTest(){
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        when(gatewayDeviceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayDevice1));
        boolean isExpected = GatewayDevicePersistenceService.exists("Guid1234");
        assertEquals(isExpected, true);
    }

    @Test
    public void existsTest(){
        GatewayDevice gatewayDevice1 = new GatewayDevice();
        gatewayDevice1.setGuid("Guid1234");
        gatewayDevice1.setSerialNumber("Test1");
        when(gatewayDeviceRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayDevice1));
        boolean isExpected  = GatewayDevicePersistenceService.exists(gatewayDevice1);
        assertEquals(isExpected, true);
    }







}
*/
