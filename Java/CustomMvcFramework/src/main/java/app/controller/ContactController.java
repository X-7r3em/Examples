package app.controller;

import MVCFramework.annotation.GetMapping;
import MVCFramework.annotation.Controller;
import MVCFramework.controller.AbstractController;
import httpServer.data.response.HttpResponse;

@Controller
public class ContactController extends AbstractController {
    @GetMapping("/contact")
    public HttpResponse contact() {
        return view("contact");
    }
}
