package com.gayan.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
class CashCardController {
    private final CashCardRepository cashCardRepository;

    private CashCardController(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{requestId}")
    private ResponseEntity<CashCard> findById(@PathVariable  Long requestId){
        Optional<CashCard> cashCard = cashCardRepository.findById(requestId);

        if(cashCard.isPresent()){
            System.out.println(cashCard);
            return ResponseEntity.ok(cashCard.get());
        }else{
            return ResponseEntity.notFound().build();
        }

        //return cashCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
