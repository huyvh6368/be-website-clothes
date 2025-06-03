package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.DiscountCampaign;

@Repository
public interface DiscountCampaignRepository extends JpaRepository<DiscountCampaign, Long> {
}
