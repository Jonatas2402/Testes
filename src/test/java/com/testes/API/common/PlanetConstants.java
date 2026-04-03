package com.testes.API.common;

import com.testes.API.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name",
            "terrain",
            "climate");
    public static final Planet INVALID_PLANET = new Planet("",
            "","");
}
