package com.example.Wool_Amore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
public class WoolRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WoolRepository woolRepository;

    @Test
   public void testAddSave() throws InterruptedException {
        // Given
        Art newArt = new Art();
        newArt.setName("buukk");
        newArt.setPrice("100");

        // When
        woolRepository.save(newArt);

        // Then
        List<Art> finalArtList = woolRepository.getAll();
        System.out.println(finalArtList);
        Assert.assertTrue(finalArtList.contains(newArt), "New art should be in the updated list");

        if (!finalArtList.contains(newArt)) {
            System.out.println("List after save: " + finalArtList);
        }
    }
}

