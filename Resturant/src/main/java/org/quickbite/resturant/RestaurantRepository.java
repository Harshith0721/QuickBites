package org.quickbite.resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Integer> {
    @Query(value = "SELECT * FROM restaurant_entity",nativeQuery = true)
    List<RestaurantEntity> findAllItems();
    @Override
    Optional<RestaurantEntity> findById(Integer integer);
}
