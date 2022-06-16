/*
package com.cs.speedtest.service;
import com.cs.speedtest.entities.BatchSpeedTestConfig;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.cs.speedtest.repository.BatchSpeedTestConfigRepository;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BatchSpeedTestConfigPersistenceServiceTest {

    @InjectMocks
    private BatchSpeedTestConfigPersistenceService batchSpeedTestConfigPersistenceService;


    @Mock
    private BatchSpeedTestConfigRepository batchSpeedTestConfigRepository;

    @Test
    public void findByIdTest(){
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        when(batchSpeedTestConfigRepository.findById(Mockito.anyString())).thenReturn(Optional.of(batchSpeedTestConfig1));
        BatchSpeedTestConfig expected = batchSpeedTestConfigPersistenceService.findById("Guid1234");
        assertNotNull(batchSpeedTestConfig1);
        assertEquals(expected, batchSpeedTestConfig1);
//        verify(userRepository).findAll();
    }

    @Test
    public void findAllTest(){

        List<BatchSpeedTestConfig> batchSpeedTestConfigs =  new ArrayList<>();

        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        batchSpeedTestConfigs.add(batchSpeedTestConfig1);

        BatchSpeedTestConfig batchSpeedTestConfig2 = new BatchSpeedTestConfig();
        batchSpeedTestConfig2.setGuid("Guid1234");
        batchSpeedTestConfig2.setTestName("Test1");
        batchSpeedTestConfigs.add(batchSpeedTestConfig2);
        when(batchSpeedTestConfigRepository.findAll()).thenReturn(batchSpeedTestConfigs);

        List<BatchSpeedTestConfig> expected = batchSpeedTestConfigPersistenceService.findAll();
        assertEquals(expected, batchSpeedTestConfigs);
        assertNotNull(batchSpeedTestConfig1);
        verify(batchSpeedTestConfigRepository).findAll();

    }

    @Test
    public void countAllTest(){

        List<BatchSpeedTestConfig> batchSpeedTestConfigs =  new ArrayList<>();

        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        batchSpeedTestConfigs.add(batchSpeedTestConfig1);

        BatchSpeedTestConfig batchSpeedTestConfig2 = new BatchSpeedTestConfig();
        batchSpeedTestConfig2.setGuid("Guid1234");
        batchSpeedTestConfig2.setTestName("Test1");
        batchSpeedTestConfigs.add(batchSpeedTestConfig2);
        long size = batchSpeedTestConfigs.size();
        when(batchSpeedTestConfigRepository.count()).thenReturn(size);

        long expected = batchSpeedTestConfigPersistenceService.countAll();
        assertEquals(expected, size);
        verify(batchSpeedTestConfigRepository).count();

    }
//
    @Test
    public void saveTest()
    {
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");

        when(batchSpeedTestConfigRepository.save(ArgumentMatchers.any(BatchSpeedTestConfig.class))).thenReturn(batchSpeedTestConfig1);
        BatchSpeedTestConfig created = batchSpeedTestConfigPersistenceService.save(batchSpeedTestConfig1);
        assertThat(created.getGuid()).isSameAs(batchSpeedTestConfig1.getGuid());
        verify(batchSpeedTestConfigRepository).save(batchSpeedTestConfig1);
    }

    @Test
    public void UpdateTest()
    {
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");

        BatchSpeedTestConfig newBatchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("new Test1");
        when(batchSpeedTestConfigRepository.findById(Mockito.anyString())).thenReturn(Optional.of(batchSpeedTestConfig1));
        when(batchSpeedTestConfigRepository.save(ArgumentMatchers.any(BatchSpeedTestConfig.class))).thenReturn(batchSpeedTestConfig1);
        boolean isExpected = batchSpeedTestConfigPersistenceService.update(batchSpeedTestConfig1);
        assertEquals(isExpected, true);

    }



    @Test
    public void createTest()
    {
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");

        when(batchSpeedTestConfigRepository.save(ArgumentMatchers.any(BatchSpeedTestConfig.class))).thenReturn(batchSpeedTestConfig1);
        BatchSpeedTestConfig created = batchSpeedTestConfigPersistenceService.save(batchSpeedTestConfig1);
        assertThat(created.getGuid()).isSameAs(batchSpeedTestConfig1.getGuid());
        verify(batchSpeedTestConfigRepository).save(batchSpeedTestConfig1);
    }

    @Test
    public void deleteByIdTest()
    {
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        batchSpeedTestConfig1.setTestDescription("TestDescription1");
//        batchSpeedTestConfig1.setTestConfiguraton(new byte[2]);
        batchSpeedTestConfig1.setTestDefinition("TestDefinition1");
        batchSpeedTestConfig1.setSchedule("Schedule");

        when(batchSpeedTestConfigRepository.findById(batchSpeedTestConfig1.getGuid())).thenReturn(Optional.of(batchSpeedTestConfig1));
        batchSpeedTestConfigPersistenceService.delete(batchSpeedTestConfig1);
        verify(batchSpeedTestConfigRepository).delete(batchSpeedTestConfig1);
    }

    @Test
    public void deleteTest()
    {
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        batchSpeedTestConfig1.setTestDescription("TestDescription1");
//        batchSpeedTestConfig1.setTestConfiguraton(new byte[2]);
        batchSpeedTestConfig1.setTestDefinition("TestDefinition1");
        batchSpeedTestConfig1.setSchedule("Schedule");

        when(batchSpeedTestConfigRepository.findById(batchSpeedTestConfig1.getGuid())).thenReturn(Optional.of(batchSpeedTestConfig1));
        batchSpeedTestConfigPersistenceService.delete(batchSpeedTestConfig1);
        verify(batchSpeedTestConfigRepository).delete(batchSpeedTestConfig1);
    }

    @Test
    public void existTest(){
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        when(batchSpeedTestConfigRepository.findById(Mockito.anyString())).thenReturn(Optional.of(batchSpeedTestConfig1));
        boolean isExpected = batchSpeedTestConfigPersistenceService.exists("Guid1234");
        assertEquals(isExpected, true);
    }

    @Test
    public void existsTest(){
        BatchSpeedTestConfig batchSpeedTestConfig1 = new BatchSpeedTestConfig();
        batchSpeedTestConfig1.setGuid("Guid1234");
        batchSpeedTestConfig1.setTestName("Test1");
        when(batchSpeedTestConfigRepository.findById(Mockito.anyString())).thenReturn(Optional.of(batchSpeedTestConfig1));
        boolean isExpected  = batchSpeedTestConfigPersistenceService.exists(batchSpeedTestConfig1);
        assertEquals(isExpected, true);
    }







}
*/
