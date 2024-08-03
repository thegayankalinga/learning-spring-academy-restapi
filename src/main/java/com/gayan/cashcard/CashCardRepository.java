package com.gayan.cashcard;

import org.springframework.data.repository.CrudRepository;

//crud repository is a interface provided by spring data
//CashCard id field should have the @Id annotation for this to work
public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
