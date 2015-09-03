package com.company;

import java.io.IOException;

public interface Receipt {

    String calculateTotal();

    String displayReceipt() throws IOException;

}
