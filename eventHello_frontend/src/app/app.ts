import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./header/header";
import { Home } from "./home/home";
import { Signup } from "./signup/signup";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Home, Signup],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'EventHello_frontend';
}
