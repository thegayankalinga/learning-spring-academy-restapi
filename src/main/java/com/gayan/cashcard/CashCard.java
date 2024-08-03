package com.gayan.cashcard;

import org.springframework.data.annotation.Id;

//@Id tells the crud repository this is the Id with long type.
record CashCard(@Id Long id, Double amount){}
