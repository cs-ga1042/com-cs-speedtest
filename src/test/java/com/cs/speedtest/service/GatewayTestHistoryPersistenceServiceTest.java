/*
package com.cs.speedtest.service;

import com.cs.speedtest.entities.GatewayTestHistory;
import com.cs.speedtest.repository.GatewayTestHistoryRepository;
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
public class GatewayTestHistoryPersistenceServiceTest {

    @InjectMocks
    private GatewayTestHistoryPersistenceService gatewayTestHistoryPersistenceService;


    @Mock
    private GatewayTestHistoryRepository gatewayTestHistoryRepository;

    @Test
    public void findByIdTest(){
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setGatewayDeviceGuid("Test1");
        when(gatewayTestHistoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayTestHistory1));
        GatewayTestHistory expected = gatewayTestHistoryPersistenceService.findById("Guid1234");
        assertNotNull(gatewayTestHistory1);
        assertEquals(expected, gatewayTestHistory1);
//        verify(userRepository).findAll();
    }

    @Test
    public void findAllTest(){

        List<GatewayTestHistory> gatewayTestHistorys =  new ArrayList<>();

        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        gatewayTestHistorys.add(gatewayTestHistory1);

        GatewayTestHistory gatewayTestHistory2 = new GatewayTestHistory();
        gatewayTestHistory2.setGuid("Guid1234");
        gatewayTestHistory2.setTestName("Test1");
        gatewayTestHistorys.add(gatewayTestHistory2);
        when(gatewayTestHistoryRepository.findAll()).thenReturn(gatewayTestHistorys);

        List<GatewayTestHistory> expected = gatewayTestHistoryPersistenceService.findAll();
        assertEquals(expected, gatewayTestHistorys);
        assertNotNull(gatewayTestHistory1);
        verify(gatewayTestHistoryRepository).findAll();

    }

    @Test
    public void countAllTest(){

        List<GatewayTestHistory> gatewayTestHistorys =  new ArrayList<>();

        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        gatewayTestHistorys.add(gatewayTestHistory1);

        GatewayTestHistory gatewayTestHistory2 = new GatewayTestHistory();
        gatewayTestHistory2.setGuid("Guid1234");
        gatewayTestHistory2.setTestName("Test1");
        gatewayTestHistorys.add(gatewayTestHistory2);
        long size = gatewayTestHistorys.size();
        when(gatewayTestHistoryRepository.count()).thenReturn(size);

        long expected = gatewayTestHistoryPersistenceService.countAll();
        assertEquals(expected, size);
        verify(gatewayTestHistoryRepository).count();

    }
    //
    @Test
    public void saveTest()
    {
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");

        when(gatewayTestHistoryRepository.save(ArgumentMatchers.any(GatewayTestHistory.class))).thenReturn(gatewayTestHistory1);
        GatewayTestHistory created = gatewayTestHistoryPersistenceService.save(gatewayTestHistory1);
        assertThat(created.getGuid()).isSameAs(gatewayTestHistory1.getGuid());
        verify(gatewayTestHistoryRepository).save(gatewayTestHistory1);
    }

    @Test
    public void UpdateTest()
    {
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");

        GatewayTestHistory newGatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("new Test1");
        when(gatewayTestHistoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayTestHistory1));
        when(gatewayTestHistoryRepository.save(ArgumentMatchers.any(GatewayTestHistory.class))).thenReturn(gatewayTestHistory1);
        boolean isExpected = gatewayTestHistoryPersistenceService.update(gatewayTestHistory1);
        assertEquals(isExpected, true);

    }



    @Test
    public void createTest()
    {
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");

        when(gatewayTestHistoryRepository.save(ArgumentMatchers.any(GatewayTestHistory.class))).thenReturn(gatewayTestHistory1);
        GatewayTestHistory created = gatewayTestHistoryPersistenceService.save(gatewayTestHistory1);
        assertThat(created.getGuid()).isSameAs(gatewayTestHistory1.getGuid());
        verify(gatewayTestHistoryRepository).save(gatewayTestHistory1);
    }

    @Test
    public void deleteByIdTest()
    {
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        gatewayTestHistory1.setTestDescription("TestDescription1");
//        gatewayTestHistory1.setTestConfiguraton(new byte[2]);
        gatewayTestHistory1.setTestDefinition("TestDefinition1");
        gatewayTestHistory1.setSchedule("Schedule");

        when(gatewayTestHistoryRepository.findById(gatewayTestHistory1.getGuid())).thenReturn(Optional.of(gatewayTestHistory1));
        gatewayTestHistoryPersistenceService.delete(gatewayTestHistory1);
        verify(gatewayTestHistoryRepository).delete(gatewayTestHistory1);
    }

    @Test
    public void deleteTest()
    {
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        gatewayTestHistory1.setTestDescription("TestDescription1");
//        gatewayTestHistory1.setTestConfiguraton(new byte[2]);
        gatewayTestHistory1.setTestDefinition("TestDefinition1");
        gatewayTestHistory1.setSchedule("Schedule");

        when(gatewayTestHistoryRepository.findById(gatewayTestHistory1.getGuid())).thenReturn(Optional.of(gatewayTestHistory1));
        gatewayTestHistoryPersistenceService.delete(gatewayTestHistory1);
        verify(gatewayTestHistoryRepository).delete(gatewayTestHistory1);
    }

    @Test
    public void existTest(){
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        when(gatewayTestHistoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayTestHistory1));
        boolean isExpected = gatewayTestHistoryPersistenceService.exists("Guid1234");
        assertEquals(isExpected, true);
    }

    @Test
    public void existsTest(){
        GatewayTestHistory gatewayTestHistory1 = new GatewayTestHistory();
        gatewayTestHistory1.setGuid("Guid1234");
        gatewayTestHistory1.setTestName("Test1");
        when(gatewayTestHistoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(gatewayTestHistory1));
        boolean isExpected  = gatewayTestHistoryPersistenceService.exists(gatewayTestHistory1);
        assertEquals(isExpected, true);
    }







}
*/
