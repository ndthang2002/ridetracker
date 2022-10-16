package com.pluralsight.comtroller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pluralsight.model.Ride;

public class RestControllerTest {

  @Test(timeout=3000)
  public void testGetRlides() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
        "http://localhost:8080/ridetracker//rides", HttpMethod.GET,
        null, new ParameterizedTypeReference<List<Ride>>() {
        });
    List<Ride> rides = ridesResponse.getBody();

    for (Ride ride : rides) {
      System.out.println("Ride name: " + ride.getName());
    }
  }
  @Test(timeout=3000)
  public void testCreateRide() {
    RestTemplate restTemplate = new RestTemplate();
    Ride ride = new Ride();
    ride.setName("terakk");
    ride.setDuration(20);
   ride= restTemplate.postForObject("http://localhost:8080/ridetracker//ride", ride,Ride.class);
    System.out.println("ride: "+ride);
  }
  
  @Test(timeout = 3000)
  public void testGetRide() {
    RestTemplate restTemplate = new RestTemplate();
    Ride ride = restTemplate.getForObject("http://localhost:8080/ridetracker/ride/1", Ride.class);
  System.out.println("Ride name: "+ ride.getName());
  }
  
  @Test(timeout = 3000)
  public void testUpdateRide() {
    RestTemplate restTemplate = new RestTemplate();
    
    Ride ride = restTemplate.getForObject("http://localhost:8080/ridetracker/ride/1", Ride.class);
    ride.setDuration(ride.getDuration()+1);
    restTemplate.put("http://localhost:8080/ridetracker/ride", ride);
    System.out.println("Ride name: "+ ride.getDuration());
  }
  
  @Test(timeout = 3000)
  public void testBatchUpgate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getForObject("http://localhost:8080/ridetracker/batch", Object.class);
  }
  
  @Test(timeout = 3000)
  public void testDelete() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete("http://localhost:8080/ridetracker/delete/44");

  }
  
  @Test(timeout = 3000)
  public void testException() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getForObject("http://localhost:8080/ridetracker/test",Ride.class);

  }
}
