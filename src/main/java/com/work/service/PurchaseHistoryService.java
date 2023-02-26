package com.work.service;

import com.work.model.PurchaseHistory;
import com.work.repository.PurchaseHistoryRepository;
import com.work.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    public List<PurchaseItem> findPurchaseItemsOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchaseOfUser(userId);
    }
}
