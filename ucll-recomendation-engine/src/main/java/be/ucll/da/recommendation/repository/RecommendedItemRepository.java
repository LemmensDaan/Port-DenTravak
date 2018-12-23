package be.ucll.da.recommendation.repository;

import be.ucll.da.recommendation.controllers.RecommendedItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecommendedItemRepository extends CrudRepository<RecommendedItem, Long> {

    List<RecommendedItem> findAllByEmailAddress(String emailAddress);

}
