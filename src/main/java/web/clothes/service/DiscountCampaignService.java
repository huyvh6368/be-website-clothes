package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.DiscountCampaignRequest;
import web.clothes.dto.response.DiscountCampaignResponse;
import web.clothes.entity.DiscountCampaign;
import web.clothes.mapper.DiscountCampaignMapper;
import web.clothes.repository.DiscountCampaignRepository;

@Service
@RequiredArgsConstructor
public class DiscountCampaignService {
    private final DiscountCampaignRepository discountCampaignRepository;

    public DiscountCampaignResponse create(DiscountCampaignRequest request) {
        DiscountCampaign discountCampaign = discountCampaignRepository.save(DiscountCampaignMapper.addRequestToEntity(request));
        return DiscountCampaignMapper.entityToResponse(discountCampaign);
    }

    public DiscountCampaignResponse update(DiscountCampaignRequest request, Long id) {
        DiscountCampaign discountCampaign = discountCampaignRepository.save(DiscountCampaignMapper.updateRequestToEntity(request, id));
        return DiscountCampaignMapper.entityToResponse(discountCampaign);
    }

    public Page<DiscountCampaignResponse> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<DiscountCampaign> discountCampaigns = discountCampaignRepository.findAll(pageable);
        return discountCampaigns.map(DiscountCampaignMapper::entityToResponse);
    }
}
