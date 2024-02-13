package com.example.Wool_Amore;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ArtControllerTest {
    @Autowired
    ArtRepository artRepository;

    @Test
    @Transactional
    void editArt() {
        artRepository.deleteAll();
        Art art = new Art();
        art.setPrice("22");
        art.setName("art1");
        art = artRepository.save(art);

        Art art2 = new Art();
        art2.setId(art.getId());
        art2.setPrice("11");
        art2.setName("a");

        ArtController artController = new ArtController(artRepository);
        artController.updateArt(art2);

        assertEquals(art2, artRepository.getById(art.getId()));
        System.out.println("dupa");
    }

    @Test
    @Transactional
    void deleteArt() {
        artRepository.deleteAll();
        Art art = new Art();
        art.setPrice("22");
        art.setName("art1");
        art = artRepository.save(art);
        assertEquals(1, artRepository.count());

        ArtController artController = new ArtController(artRepository);
        artController.deleteArt(art.getId());

        assertEquals(0, artRepository.count());
    }

    @Test
    @Transactional
    void saveArt() {
        artRepository.deleteAll();
        Art art = new Art();
        art.setPrice("22");
        art.setName("art1");

        ArtController artController = new ArtController(artRepository);
        artController.saveArt(art);

        assertEquals("22", artRepository.findAll().get(0).getPrice());
        assertEquals("art1", artRepository.findAll().get(0).getName());
        assertNotNull(artRepository.findAll().get(0).getId());
    }
}