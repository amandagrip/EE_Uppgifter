package com.amanda.lektion1.Uppgift8;

public sealed interface Animal permits Cat, Dog {
    void sound();
}
