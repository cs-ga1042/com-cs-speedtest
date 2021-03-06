/*
 * Created on 2022-06-09 ( 11:36:34 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.cs.speedtest.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "TestServer"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="test_server", schema="public" )
public class TestServer implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="guid", nullable=false, length=36)
    private String     guid ;

    //--- ENTITY DATA FIELDS 
    @Column(name="server_name", nullable=false, length=50)
    private String     serverName ;

    @Column(name="server_ip", nullable=false, length=50)
    private String     serverIp ;

    @Column(name="zone", nullable=false, length=50)
    private String     zone ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="testServer")
    private List<MetricGatewayHistory> listOfMetricGatewayHistory ; 

    @OneToMany(mappedBy="testServer")
    private List<GatewayTest> listOfGatewayTest ; 


    /**
     * Constructor
     */
    public TestServer() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setGuid( String guid ) {
        this.guid = guid ;
    }
    public String getGuid() {
        return this.guid;
    }

    public void setServerName( String serverName ) {
        this.serverName = serverName ;
    }
    public String getServerName() {
        return this.serverName;
    }

    public void setServerIp( String serverIp ) {
        this.serverIp = serverIp ;
    }
    public String getServerIp() {
        return this.serverIp;
    }

    public void setZone( String zone ) {
        this.zone = zone ;
    }
    public String getZone() {
        return this.zone;
    }

    //--- GETTERS FOR LINKS
    public List<MetricGatewayHistory> getListOfMetricGatewayHistory() {
        return this.listOfMetricGatewayHistory;
    } 

    public List<GatewayTest> getListOfGatewayTest() {
        return this.listOfGatewayTest;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(guid);
        sb.append("|");
        sb.append(serverName);
        sb.append("|");
        sb.append(serverIp);
        sb.append("|");
        sb.append(zone);
        return sb.toString(); 
    } 

}
