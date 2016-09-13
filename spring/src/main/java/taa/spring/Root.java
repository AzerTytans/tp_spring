package taa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Root implements CommandLineRunner{
  
  @Autowired
  private IRun client;
  
  public static void main(String[] args) {
    SpringApplication.run(Root.class, args);
  }

  public void run(String... arg0) throws Exception {
    this.client.run();
  }
}