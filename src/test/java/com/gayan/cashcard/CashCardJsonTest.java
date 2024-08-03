package com.gayan.cashcard;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import java.io.IOException;

@JsonTest // this
class CashCardJsonTest {
    @Autowired //directs spring ot create an object of the requested type.
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException{

        CashCard cashCard = new CashCard(99L, 123.45);

        assertThat(json.write(cashCard))
                .isStrictlyEqualToJson("expected.json");
        //add the json file to test/resources/expected.json

        assertThat(json.write(cashCard))
                .hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard))
                .extractingJsonPathNumberValue("@.id").isEqualTo(99L);
        assertThat(json.write(cashCard))
                .hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard))
                .extractingJsonPathNumberValue("@.amount").isEqualTo(123.45D);
    }

    @Test
    void cashCardDeserialisationTest() throws IOException{
        String expected = """
                {
                    "id": 99,
                    "amount": 123.45
                }
                """;

        assertThat(json.parse(expected))
                .isEqualTo((new CashCard(99L, 123.45)));

        assertThat(json.parseObject(expected).id())
                .isEqualTo(99);

        assertThat(json.parseObject(expected).amount())
                .isEqualTo(123.45);
    }

}