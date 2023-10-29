package org.Globant;

import org.Globant.service.UniversityService;
import org.Globant.ui.UI;

public class Main {
    public static void main(String[] args) {
        var ui = new UI(UniversityService.getInstance());
        ui.menu();
    }
}
