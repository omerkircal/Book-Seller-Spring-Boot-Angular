package com.work.controller;

import com.work.model.PurchaseHistory;
import com.work.security.UserPrincipal;
import com.work.service.PurchaseHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {
    private final PurchaseHistoryService purchaseHistoryService;

    public PurchaseHistoryController(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @PostMapping
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory) {

        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<?> getAllPurchase(@AuthenticationPrincipal UserPrincipal userPrincipal){

        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemsOfUser(userPrincipal.getId()));
    }
}
