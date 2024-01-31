package org.restfullbooker.allfiles;


import io.cucumber.java.en.Given;

public class RestFullBookerCreateToken {

    @Given("I have {int} cukes in my belly")
    public void i_have_n_cukes_in_my_belly(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
    }
}
