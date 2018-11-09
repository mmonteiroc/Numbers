import static org.junit.Assert.*;

public class pruebaTest {
    @org.junit.Test
    public void test1() {
        assertEquals("One", Numbers.say(1));
        assertEquals("Three", Numbers.say(3));
        assertEquals("Four", Numbers.say(4));
        assertEquals("Six", Numbers.say(6));
    }

    @org.junit.Test
    public void test2() {
        assertEquals("Ten", Numbers.say(10));
        assertEquals("Fourteen", Numbers.say(14));
        assertEquals("Nineteen", Numbers.say(19));
    }

    @org.junit.Test
    public void test3() {
        assertEquals("Twenty-four", Numbers.say(24));
        assertEquals("Sixty-five", Numbers.say(65));
        assertEquals("Eighty-three", Numbers.say(83));
        assertEquals("Ninety", Numbers.say(90));
    }

    @org.junit.Test
    public void test4() {
        assertEquals("One hundred", Numbers.say(100));
        assertEquals("Three hundred", Numbers.say(300));
        assertEquals("Seven hundred", Numbers.say(700));
        assertEquals("Two hundred and one", Numbers.say(201));
        assertEquals("Four hundred and thirty-two", Numbers.say(432));
        assertEquals("Five hundred and eleven", Numbers.say(511));
    }

    @org.junit.Test
    public void test5() {
        assertEquals("Two thousand three", Numbers.say(2003));
        assertEquals("One thousand", Numbers.say(1000));
        assertEquals("Two thousand three hundred", Numbers.say(2300));
        assertEquals("Four thousand five hundred and sixty-one", Numbers.say(4561));
    }

    @org.junit.Test
    public void test6() {
        assertEquals("Ten thousand", Numbers.say(10000));
        assertEquals("Thirteen thousand", Numbers.say(13000));
        assertEquals("Twenty-one thousand", Numbers.say(21000));
        assertEquals("Twenty-one thousand three hundred and one", Numbers.say(21301));
        assertEquals("Ninety-nine thousand seven hundred and twenty-one", Numbers.say(99721));
    }

    @org.junit.Test
    public void test7() {
        assertEquals("Two hundred thousand", Numbers.say(200000));
        assertEquals("Three hundred and eleven thousand twenty-five", Numbers.say(311025));
        assertEquals("Three hundred and eleven thousand nine hundred and twenty-five", Numbers.say(311925));
    }

    @org.junit.Test
    public void test8() {
        assertEquals("One million", Numbers.say(1000000));
        assertEquals("Three million ten thousand", Numbers.say(3010000));
        assertEquals("Five million four hundred and thirty-two thousand six hundred and fifty-three",
                Numbers.say(5432653));
        assertEquals("Seven million six hundred and fifty thousand five hundred and six",
                Numbers.say(7650506));
        assertEquals("Five million two hundred and fifty thousand four hundred and twenty-two",
                Numbers.say(5_250_422));
    }

    @org.junit.Test
    public void test9() {
        assertEquals("One billion", Numbers.say(1_000_000_000));
        assertEquals("One billion forty-three million six hundred and fifty", Numbers.say(1_043_000_650));
        assertEquals("Six billion three hundred and forty-two million two hundred and thirty-one thousand one hundred and nineteen",
                Numbers.say(6342231119L));

        assertEquals("Three hundred and twenty-two billion ten million four hundred and thirty thousand one hundred and fifty-three",
                Numbers.say(322_010_430_153L));

        assertEquals("Two trillion", Numbers.say(2_000_000_000_000L));
        assertEquals("Twenty-three trillion six hundred and fifty-three billion two hundred and thirty-one million seven hundred and sixty-four thousand four hundred and thirty-eight",
                Numbers.say(23_653_231_764_438L));

        assertEquals("Five hundred and forty-three quadrillion four hundred and thirty-two trillion six hundred and fifty-five billion sixty-five million five hundred and forty-three thousand four hundred and thirty-two",
                Numbers.say(543_432_655_065_543_432L));

        assertEquals("Two quintillion three hundred and twenty-three quadrillion three hundred and forty-two trillion seven hundred and fifty-five billion five hundred and fifty-three million four hundred and thirty-four thousand two hundred and thirteen",
                Numbers.say(2_323_342_755_553_434_213L));

    }

    @org.junit.Test
    public void revTest1() {
        assertEquals(0, Numbers.words("zero"));
        assertEquals(1, Numbers.words("one"));
        assertEquals(5, Numbers.words("five"));
        assertEquals(9, Numbers.words("nine"));
    }

    @org.junit.Test
    public void revTest2() {
        assertEquals(10, Numbers.words("ten"));
        assertEquals(16, Numbers.words("sixteen"));
        assertEquals(18, Numbers.words("eighteen"));
    }

    @org.junit.Test
    public void revTest3() {
        assertEquals(21, Numbers.words("twenty-one"));
        assertEquals(65, Numbers.words("sixty-five"));
        assertEquals(79, Numbers.words("seventy-nine"));
    }

    @org.junit.Test
    public void revTest4() {
        assertEquals(200, Numbers.words("two hundred"));
        assertEquals(700, Numbers.words("seven hundred"));
        assertEquals(900, Numbers.words("nine hundred"));
        assertEquals(321, Numbers.words("three hundred and twenty-one"));
        assertEquals(901, Numbers.words("nine hundred and one"));
        assertEquals(760, Numbers.words("seven hundred and sixty"));
    }

    @org.junit.Test
    public void revTest5() {
        assertEquals(1500, Numbers.words("one thousand five hundred"));
        assertEquals(4320, Numbers.words("four thousand three hundred and twenty"));
        assertEquals(7632, Numbers.words("seven thousand six hundred and thirty-two"));
        assertEquals(9000, Numbers.words("nine thousand"));
    }

    @org.junit.Test
    public void revTest6() {
        assertEquals(1_000_000, Numbers.words("one million"));
        assertEquals(5_432_653, Numbers.words("Five million four hundred and thirty-two thousand six hundred and fifty-three"));
        assertEquals(43_000_010, Numbers.words("forty-three million and ten"));
        assertEquals(43_432_235, Numbers.words("forty-three million four hundred and thirty-two thousand two hundred and thirty-five"));
        assertEquals(243_432_235, Numbers.words("two hundred and forty-three million four hundred and thirty-two thousand two hundred and thirty-five"));
        assertEquals(5_243_432_235L, Numbers.words("five billion two hundred and forty-three million four hundred and thirty-two thousand two hundred and thirty-five"));
    }

    @org.junit.Test
    public void revTest7() {
        assertEquals(322_010_430_153L,
                Numbers.words("Three hundred and twenty-two billion ten million four hundred and thirty thousand one hundred and fifty-three"));

        assertEquals(234_234_456_674_432_432L,
                Numbers.words("Two hundred and thirty-four quadrillion two hundred and thirty-four trillion four hundred and fifty-six billion six hundred and seventy-four million four hundred and thirty-two thousand four hundred and thirty-two"));

        assertEquals(5_004_320_432_861_903_541L,
                Numbers.words("Five quintillion four quadrillion three hundred and twenty trillion four hundred and thirty-two billion eight hundred and sixty-one million nine hundred and three thousand five hundred and forty-one"));
    }


}
