package com.quintrix.jfs.quintrixspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.quintrix.jfs.quintrixspring.models.Cat;
import com.quintrix.jfs.quintrixspring.repositories.CatRepository;
import com.quintrix.jfs.quintrixspring.services.CatService;

@SpringBootTest
class QuintrixSpringApplicationTests {

  @Autowired
  CatService catService;

  @MockBean
  CatRepository catRepo;

  @Test
  public void getCatsTestAll() {
    List<Cat> testCats = new ArrayList<>();
    testCats.add(new Cat(1, "Coco", "Kitty", 1));
    testCats.add(new Cat(2, "MeowMeow", "Cate", 4));
    testCats.add(new Cat(3, "NyanCat", "Poptart", 11));

    when(catRepo.findAll()).thenReturn(testCats);

    assertEquals(3, catService.getCats(null).size());
  }

  @Test
  public void getCatsTestId() {
    List<Cat> testCats = new ArrayList<>();
    testCats.add(new Cat(1, "Coco", "Kitty", 1));
    testCats.add(new Cat(2, "MeowMeow", "Cate", 4));
    testCats.add(new Cat(3, "NyanCat", "Poptart", 11));

    int id = 1;

    when(catRepo.findById(id)).thenReturn(Optional.of(new Cat(1, "Coco", "Kitty", 1)));

    assertEquals(id, catService.getCatDetails(id).getId());
  }

  @Test
  public void postCatsTest() {
    Cat testCat = new Cat(1, "Coco", "Kitty", 1);
    when(catRepo.save(testCat)).thenReturn(testCat);
    assertEquals(testCat, catService.addCat(testCat));
  }
}
